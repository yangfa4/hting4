package com.sy.demo.action.tjc;

import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.tjz.BusinessBiz;
import com.sy.demo.vo.tjc.RefundVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/business")
public class BusinessAction {

    @Autowired
    private BusinessBiz biz;

    @GetMapping("queryAllRefund/{pageNum}/{pageSize}/{sid}")
    public PageInfo<RefundVo> queryAllRefund(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable Integer sid){
        return biz.queryAllRefund(pageNum,pageSize,sid);
    }

    @GetMapping("agree/{rid}/{oid}/{uid}/{money}")
    public Map<String,String> agree(@PathVariable Integer rid,@PathVariable String oid,@PathVariable Integer uid,@PathVariable Integer money){
        Map<String,String> map = new HashMap<>();
        try{
            biz.agree(rid,oid,uid,money);
            map.put("code","200");
        }catch (Exception e){
            map.put("code","400");
            e.printStackTrace();
        }
        return map;
    }
    @GetMapping("disagree/{rid}/{oid}/{reason}")
    public Map<String,String> disagree(@PathVariable Integer rid,@PathVariable  String oid,@PathVariable String reason){

        Map<String,String> map = new HashMap<>();
        try{
            biz.disagree(rid,oid,reason);
            map.put("code","200");
        }catch (Exception e){
            map.put("code","400");
            e.printStackTrace();
        }
        return map;
    }

}
