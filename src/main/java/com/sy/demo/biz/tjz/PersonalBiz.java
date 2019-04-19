package com.sy.demo.biz.tjz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.tjc.IPersonalDao;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Refund;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.tjc.CollectVo;
import com.sy.demo.vo.tjc.OrderDetail;
import com.sy.demo.vo.tjc.RefundVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly= true)
@SuppressWarnings("all")
public class PersonalBiz {

    @Autowired
    private IPersonalDao dao;


    public User queryUserById(Integer id){
        return dao.queryUserById(id);
    }

    public PageInfo<OrderDetail> queryOrdersByIdAndStatusId(Integer uid, Integer statusId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(dao.queryOrdersByIdAndStatusId(uid,statusId));
    }

    public OrderDetail queryOrderByOid(String oid){
        return dao.queryOrderByOid(oid);
    }

    public void orderPay(Integer uid,Integer totalPrice,String oid){
        dao.orderPay(uid,totalPrice,oid,(int)(totalPrice*0.1));
    };

    public void orderCancel(String oid){
        dao.orderCancel(oid);
    }

    public PageInfo<CollectVo> queryMyCollectByUid(Integer uid,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return  new PageInfo<>(dao.queryMyCollectByUid(uid));
    }

    public void addOrderRefund( Refund refund){
        dao.addOrderRefund(refund);
    }

    public PageInfo<RefundVo> queryRefundDetail(Integer uid,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return  new PageInfo<>(dao.queryRefundDetail(uid));
    }

    public  RefundVo queryRefundDetailByOid(String oid){
        return dao.queryRefundDetailByOid(oid);
    }

    public void applyAdmin(Integer rid,String oid){
         dao.applyAdmin(rid,oid);
    }
}
