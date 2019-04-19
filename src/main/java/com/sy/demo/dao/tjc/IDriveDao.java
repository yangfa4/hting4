package com.sy.demo.dao.tjc;

import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Servicecollection;
import com.sy.demo.pojo.Servicelevel;
import com.sy.demo.pojo.Sharea;
import com.sy.demo.vo.tjc.ServiceDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDriveDao {

    /*查询所有的国家*/
    List<Sharea> queryCountries();

    /*根据国家id查询所有城市*/
    List<Sharea> queryCities(@Param("id") Integer id);

    /*根据服务Id查询所有服务级别*/
    List<Servicelevel> queryLevel(@Param("id") Integer id);

    /*多条件查询服务*/
    List<ServiceDetail> queryServices(@Param("stid") Integer stid);

    /*根据服务ID查询服务详情*/
    ServiceDetail querySd(@Param("id") Integer id);


    /*根据服务ID查询订单数量*/
    int queryOrderCount(@Param("id") Integer id);

    /*根据服务ID查询收藏数量*/
    int queryCollectCount(@Param("id") Integer id);

    /*查询用户是否收藏当前商品*/
    Servicecollection queryCollectByUidAndSid(@Param("uid") Integer uid, @Param("sid") Integer sid);

    /*收藏*/
    void collect(@Param("uid") Integer uid, @Param("sid") Integer sid);

    /*添加收藏*/
    void addCollect(@Param("uid") Integer uid, @Param("sid") Integer sid);

    /*删除收藏*/
    void delCollet(@Param("id") Integer id);

    /*添加预定*/
    void addOrder(@Param("order") Orders order);
}
