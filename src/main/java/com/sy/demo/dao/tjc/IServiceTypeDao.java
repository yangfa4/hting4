package com.sy.demo.dao.tjc;

import com.sy.demo.pojo.Servicetype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@SuppressWarnings("all")
public interface IServiceTypeDao {

    /*根据父级Id查询服务类型*/
    List<Servicetype> queryServicetypeBystPid(@Param("stPid") Integer stPid);

    /*根据Id查询服务类型对象*/
    Servicetype queryServicetypeBystid(@Param("stid") Integer stid);

    /*根据Id修改服务类型对象*/
    void updateServicetypeBystid(@Param("st") Servicetype st);

    /*根据Id删除服务类型对象*/
    void delServicetypeBystid(@Param("stid") Integer stid);

    /*添加服务类型*/
    void addServicetype(@Param("st") Servicetype st);

}
