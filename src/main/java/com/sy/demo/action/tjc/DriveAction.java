package com.sy.demo.action.tjc;

import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.tjz.DriveBiz;
import com.sy.demo.pojo.Servicelevel;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.vo.tjc.ServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DriveAction {

    @Autowired
    private DriveBiz biz;

    @GetMapping("queryCountries")
    public List<Sharea> queryCountries() {
        return biz.queryCountries();
    }

    @GetMapping("queryCities/{id}")
    public List<Sharea> queryCities(@PathVariable Integer id) {
        return biz.queryCities(id);
    }

    @GetMapping("queryLevel/{id}")
    public List<Servicelevel> queryLevel(@PathVariable Integer id) {
        return biz.queryLevel(id);
    }

    @GetMapping("queryServices/{pageNum}/{pageSize}/{stid}")
    public PageInfo<ServiceDetail> queryServices(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @PathVariable Integer stid) {
        return biz.queryServices(pageNum, pageSize, stid);
    }

    @GetMapping("querySd/{id}")
    public ServiceDetail querySd(@PathVariable Integer id) {
        return biz.querySd(id);
    }

    @GetMapping("queryCollectByUidAndSid/{uid}/{sid}")
    public Map<String, String> queryCollectByUidAndSid(@PathVariable Integer uid, @PathVariable Integer sid) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            if (biz.queryCollectByUidAndSid(uid, sid) == null) {
                map.put("code", "400");
            } else {
                map.put("code", "200");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @GetMapping("collect/{uid}/{sid}")
    public void collect(@PathVariable Integer uid, @PathVariable Integer sid) {
        biz.collect(uid, sid);
    }

    @GetMapping("addOrder/{totalPrice}/{userID}/{scheduledStartTime}/{scheduledEndTime}/{population}/{serviceID}/{remarks}")
    public void addOrder(@PathVariable Float totalPrice, @PathVariable Integer userID, @PathVariable String scheduledStartTime, @PathVariable String scheduledEndTime,
                         @PathVariable Integer population, @PathVariable Integer serviceID, @PathVariable String remarks) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        biz.addOrder(totalPrice, userID, df.parse(scheduledStartTime), df.parse(scheduledEndTime), population, serviceID, remarks);
    }
}
