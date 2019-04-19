package com.sy.demo.dao.tjc;


import com.sy.demo.pojo.Servicetype;
import org.apache.ibatis.annotations.Param;

public interface IServiceCheckDao {

    /*修改服务审核*/
    void updateServiceCheck(@Param("st") Servicetype st);
}
