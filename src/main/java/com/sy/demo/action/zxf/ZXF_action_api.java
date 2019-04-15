package com.sy.demo.action.zxf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.demo.biz.zxf.ZXF_shopbiz;
import com.sy.demo.pojo.Servicetype;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.pojo.User;
import com.sy.demo.util.zxf.Number;
import com.sy.demo.vo.zxf.Ordersvo1;
import com.sy.demo.vo.zxf.RefundListVo;
import com.sy.demo.vo.zxf.ServiceTypeVo;

@RestController
@RequestMapping("/zxf/api")
public class ZXF_action_api {

	@Autowired
	private ZXF_shopbiz biz;

	/**
	 * 返回地址信息
	 * 
	 * @methodName: getsharea
	 * @param pid
	 * @return
	 *
	 */
	@GetMapping("/getsharea")
	public List<Sharea> getsharea(Integer pid) {
		List<Sharea> lt = biz.QueryShareaAll();
		List<Sharea> lt2 = new CopyOnWriteArrayList<Sharea>();
		for (Sharea shar : lt)
			if (shar.getPid() == pid)
				lt2.add(shar);
		return lt2;
	}

	/**
	 * 返回服务名称by stid
	 * 
	 * @methodName: getstName
	 * @param stid
	 * @return
	 *
	 */
	@GetMapping("/getstName")
	public String getstName(Integer stid) {
		String name = "";
		for (Servicetype st : biz.QueryservicetypeAll()) {
			if (st.getStid() == stid) {
				name = st.getStName();
				break;
			}
		}
		return name;
	}

	/**
	 * 修改订单状态
	 * 
	 * @methodName: orderstatupdate
	 * @param OID
	 * @param stat
	 * @return
	 *
	 */
	@PutMapping("/order")
	public Map<String, Object> OID(String OID, Integer stat) {
		Map<String, Object> mg = new ConcurrentHashMap<String, Object>();
		List<Ordersvo1> lt = biz.queryOrders(null, null,OID, null);
		Integer order = null;
		Float money = null;
		if(lt!=null&&lt.size()>0) {
			order = lt .get(0).getSer().getUserID();
			money = lt .get(0).getTotalPrice();
		}
		if (biz.ordersStatupdate(OID, stat,money,order) > 0) {
			mg.put("struts", "ok");
		} else {
			mg.put("struts", "no");
		}
		return mg;
	}
	/**
	 * 同意退款
	 * 
	 * @methodName: tosjtk
	 * @param refundID
	 * @param orderid
	 * @return
	 *
	 */
	@PostMapping("refundok")
	public String tosjtk(Integer refundID) {
		RefundListVo rv = biz.queryrefundbyid(refundID);
		System.out.println(rv);
		if (biz.ordersrefundstatusupdate(rv,null) > 0) 
			return "true";
		return "false";
	}
	
	/**
	 * 身份证验证
	 * 
	 * @methodName: sfz_yz
	 * @param sfz
	 * @return
	 * @throws Exception
	 *
	 */
	@GetMapping(value = "/sfz_yz/{sfz}", produces = "text/html;charset=UTF-8")
	public String sfz_yz(@PathVariable String sfz) throws Exception {
		return jhyz("http://apis.juhe.cn/idcard/index?cardno=" + sfz + "&key=4cf775e1c696f52197d642506442fbe8");
	}

	/**
	 * 电话号码验证
	 * 
	 * @methodName: dh_yz
	 * @param dh
	 * @return
	 * @throws Exception
	 *
	 */
	@GetMapping(value = "/dh_yz/{dh}", produces = "text/html;charset=UTF-8")
	public String dh_yz(@PathVariable String dh) throws Exception {
		return jhyz("http://apis.juhe.cn/mobile/get?phone=" + dh + "&key=5ddfdcb65ee003df0f458e8e518c7080");
	}

	/**
	 * 聚合验证接口调用
	 * 
	 * @methodName: jhyz
	 * @param uri
	 * @return
	 * @throws Exception
	 *
	 */
	public String jhyz(String uri) throws Exception {
		BufferedReader br = null;
		StringBuffer data = new StringBuffer();
		try {
			// 1.定义标识符
			URL url = new URL(uri);
			// 2.获得连接资源
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// 3.设置连接信息
			httpConn.setRequestMethod("GET");
			httpConn.setReadTimeout(50 * 1000);
			httpConn.setConnectTimeout(4 * 1000);
			// 4.开始连接
			httpConn.connect();
			// 5.接收响应信息
			int rsCode = httpConn.getResponseCode();
			switch (rsCode) {
			case HttpURLConnection.HTTP_OK:
				// 6.利用流处理数据
				// 高级字符流
				br = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				for (String rs; (rs = br.readLine()) != null;) {
					data.append(rs);
				}
				break;
			case HttpURLConnection.HTTP_NOT_FOUND:
				break;
			case HttpURLConnection.HTTP_INTERNAL_ERROR:
				break;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data.toString();
	}

}
