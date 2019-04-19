package com.sy.demo.biz.tjz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.tjc.IBusinessDao;
import com.sy.demo.vo.tjc.RefundVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SuppressWarnings("all")
@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly= true)
public class BusinessBiz {

    @Autowired
    private IBusinessDao dao;

    public PageInfo<RefundVo> queryAllRefund(Integer pageNum,Integer pageSize,Integer sid){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(dao.queryAllRefund(sid));
    }

    public void agree(Integer rid, String oid,   Integer uid, Integer money){
        Integer integral = (int)(money/0.9-money);
        dao.agreeRefund(rid,oid,new Date(),uid,money,integral);
    }

    public void disagree(Integer rid, String oid, String reason){
        dao.disagreeRefund(rid,oid,reason,new Date());
    }

}
