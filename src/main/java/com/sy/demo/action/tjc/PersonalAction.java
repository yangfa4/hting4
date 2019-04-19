package com.sy.demo.action.tjc;

import com.github.pagehelper.PageInfo;
import com.sy.demo.biz.tjz.PersonalBiz;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Refund;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.tjc.CollectVo;
import com.sy.demo.vo.tjc.OrderDetail;
import com.sy.demo.vo.tjc.RefundVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PersonalAction {

    @Autowired
    private PersonalBiz biz;

    @ResponseBody
    @GetMapping("queryUserById/{id}")
    public User queryUserById(@PathVariable Integer id){
        return biz.queryUserById(id);
    }

    @ResponseBody
    @GetMapping("queryOrdersByIdAndStatusId/{uid}/{statusId}/{pageNum}/{pageSize}")
    public PageInfo<OrderDetail> queryOrdersByIdAndStatusId(@PathVariable Integer uid, @PathVariable Integer statusId, @PathVariable Integer pageNum, @PathVariable Integer pageSize){
       return biz.queryOrdersByIdAndStatusId(uid,statusId,pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("queryOrderByOid/{oid}")
    public OrderDetail queryOrderByOid(@PathVariable String oid){
        return biz.queryOrderByOid(oid);
    }

    @ResponseBody
    @GetMapping("orderPay/{uid}/{totalPrice}/{oid}")
    public Map<String,String> orderPay(@PathVariable Integer uid,@PathVariable Integer totalPrice,@PathVariable String oid){

        Map<String,String> map = new HashMap<>();
        try{
            biz.orderPay(uid,totalPrice,oid);
            map.put("code","200");
        }catch (Exception e){
            map.put("code","400");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @GetMapping("orderCancel/{oid}")
    public Map<String,String> orderCancel(@PathVariable String oid){

        Map<String,String> map = new HashMap<>();
        try{
            biz.orderCancel(oid);
            map.put("code","200");
        }catch (Exception e){
            map.put("code","400");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @GetMapping("queryMyCollectByUid/{uid}/{pageNum}/{pageSize}")
    public  PageInfo<CollectVo> queryMyCollectByUid(@PathVariable Integer uid,@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        return  biz.queryMyCollectByUid(uid,pageNum,pageSize);
    }

    @PostMapping("addOrderRefund")
    public String addOrderRefund(MultipartFile file,String orderID,
                              String refundReason, Integer userID,
                               Float applyRefundMoney,String refundExplain) throws Exception{

        System.err.println(orderID);
        Refund refund = new Refund();

        /*退款提交时间*/
        refund.setApplicationTime(new Date());
        refund.setPoint(1);
        refund.setOrderID(orderID);
        refund.setUserID(userID);
        refund.setApplyRefundMoney(applyRefundMoney);
        refund.setRefundExplain(refundExplain);
        refund.setRefundReason(refundReason);


        /*文件本地化*/
        String fileName = file.getOriginalFilename();
        refund.setRefundImg(File.separator + fileName);
        file.transferTo(new File("E:\\myfile" + File.separator + fileName));
        biz.addOrderRefund(refund);

        return "redirect:../grzx-refund.html";

    }

    @ResponseBody
    @GetMapping ("queryRefundDetail/{uid}/{pageNum}/{pageSize}")
    public PageInfo<RefundVo> queryRefundDetail(@PathVariable Integer uid,@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        return biz.queryRefundDetail(uid,pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("queryRefundDetailByOid/{oid}")
    public  RefundVo queryRefundDetailByOid(@PathVariable String oid){
        return biz.queryRefundDetailByOid(oid);
    }

    @ResponseBody
    @GetMapping("applyAdmin/{rid}/{oid}")
    public Map<String,String> applyAdmin(@PathVariable Integer rid,@PathVariable String oid){

        Map<String,String> map = new HashMap<>();
        try{
            biz.applyAdmin(rid,oid);
            map.put("code","200");
        }catch (Exception e){
            map.put("code","400");
            e.printStackTrace();
        }
        return map;
    }

}
