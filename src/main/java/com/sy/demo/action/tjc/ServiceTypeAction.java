package com.sy.demo.action.tjc;

import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.tjz.ServiceTypeBiz;
import com.sy.demo.pojo.Servicetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServiceTypeAction {

    @Autowired
    private ServiceTypeBiz biz;

    /*根据父级ID查询所有服务类型*/
    @GetMapping(value = {"queryServicetypeBystPid/{pageNum}/{pageSize}/{stPid}","queryServicetypeBystPid/{pageNum}/{pageSize}"})
    public PageInfo<Servicetype> queryServicetypeBystPid(@PathVariable Integer pageNum, @PathVariable Integer pageSize,
                                                         @PathVariable(required = false) Integer stPid) {
        return  biz.queryServicetypeBystPid(pageNum,pageSize,stPid);
    }

    /*根据服务类型ID删除该服务及所有子服务*/
    @DeleteMapping("delServicetypeBystid/{stid}")
    public Map<String,String> delServicetypeBystid(@PathVariable Integer stid){

        Map<String,String> map = new HashMap<String, String>();
        try{
            biz.delServicetypeBystid(stid);
            map.put("code","200");
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


}
