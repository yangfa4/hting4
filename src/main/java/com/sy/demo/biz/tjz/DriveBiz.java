package com.sy.demo.biz.tjz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.tjc.IDriveDao;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Servicecollection;
import com.sy.demo.pojo.Servicelevel;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.vo.tjc.ServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SuppressWarnings("all")
@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly= true)
public class DriveBiz {

    @Autowired
    private IDriveDao dao;

    public List<Sharea> queryCountries(){
        return dao.queryCountries();
    }

    public List<Sharea> queryCities(Integer id){
        return dao.queryCities(id);
    }

    public  List<Servicelevel> queryLevel(Integer id){
        return dao.queryLevel(id);
    }

    public PageInfo<ServiceDetail> queryServices(Integer pageNum, Integer pageSize, Integer stid){
        PageHelper.startPage(pageNum,pageSize);
        return  new PageInfo<>(dao.queryServices(stid));
    }

    public ServiceDetail querySd(Integer id){
    	System.out.println("id:"+id);
        ServiceDetail sd = dao.querySd(id);
        sd.setOrderCount(dao.queryOrderCount(id));
        sd.setCollectCount(dao.queryCollectCount(id));
        return sd;
    }

    public Servicecollection queryCollectByUidAndSid(Integer uid, Integer sid){
        return dao.queryCollectByUidAndSid(uid,sid);
    }

    public void collect(Integer uid,Integer sid){
        Servicecollection s = dao.queryCollectByUidAndSid(uid,sid);
        if(s==null){
            dao.addCollect(uid,sid);
        }else{
            dao.delCollet(s.getSerColleID());
        }
    }

    public void addOrder(Float totalPrice, Integer userID,  Date scheduledStartTime,  Date scheduledEndTime,
                         Integer population, Integer serviceID, String remarks){

        Orders order = new Orders();

        order.setTotalPrice(totalPrice);
        order.setUserID(userID);
        order.setScheduledStartTime(scheduledStartTime);
        order.setScheduledEndTime(scheduledEndTime);
        order.setPopulation(population);
        order.setServiceID(serviceID);
        order.setRemarks(remarks);



        /*下单时间*/
        order.setOrderTime(new Date());
        /*订单状态（预定，待付款1）*/
        order.setOrderStatus(1);

        /*订单号*/
        Random r = new Random();
        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderId=f.format(now);

        for (int i=0;i<6;i++){
            orderId+=r.nextInt(10);
        }
        order.setOrderID(orderId);
        dao.addOrder(order);
    }


}
