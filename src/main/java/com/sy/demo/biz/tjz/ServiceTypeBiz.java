package com.sy.demo.biz.tjz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.tjc.IServiceTypeDao;
import com.sy.demo.pojo.Servicetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("ALL")
@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly= true)
public class ServiceTypeBiz {
 
    @Autowired
    private IServiceTypeDao dao;

    public PageInfo<Servicetype> queryServicetypeBystPid(Integer pageNum, Integer pageSize, Integer stPid){
        PageHelper.startPage(pageNum,pageSize);
        return  new PageInfo<Servicetype>(dao.queryServicetypeBystPid(stPid));
    }


    public Servicetype queryServicetypeBystid(Integer stid){
        return dao.queryServicetypeBystid(stid);
    }

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly= false)
    public  void  updateServicetypeBystid( Servicetype st){
        dao.updateServicetypeBystid(st);
    }

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly= false)
    public  void  delServicetypeBystid(Integer stid){
        dao.delServicetypeBystid(stid);
    }

    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly= false)
    public void addServicetype(Servicetype st){
        dao.addServicetype(st);
    }
}
