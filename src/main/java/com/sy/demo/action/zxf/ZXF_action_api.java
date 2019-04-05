package com.sy.demo.action.zxf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.demo.biz.zxf.ZXF_shopbiz;
import com.sy.demo.pojo.Sharea;

@RestController
@RequestMapping("/zxf/api")
public class ZXF_action_api {

	@Autowired
	private ZXF_shopbiz biz;

	@GetMapping("/getsharea")
	public List<Sharea> getsharea(Integer pid) {
		List<Sharea> lt = biz.QueryShareaAll();
		List<Sharea> lt2 = new CopyOnWriteArrayList<Sharea>();
		for (Sharea shar : lt)
			if (shar.getPid() == pid)
				lt2.add(shar);  
		return lt2;
	}
    
	@GetMapping(value="/sfz_yz/{sfz}", produces = "text/html;charset=UTF-8")
	public String sfz_yz(@PathVariable String sfz) throws Exception {
		return jhyz("http://apis.juhe.cn/idcard/index?cardno=" + sfz + "&key=4cf775e1c696f52197d642506442fbe8");
	}
	@GetMapping(value="/dh_yz/{dh}", produces = "text/html;charset=UTF-8")
	public String dh_yz(@PathVariable String dh) throws Exception {
		return jhyz("http://apis.juhe.cn/mobile/get?phone=" + dh + "&key=5ddfdcb65ee003df0f458e8e518c7080");
	}
	/**
	 * 聚合验证
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
