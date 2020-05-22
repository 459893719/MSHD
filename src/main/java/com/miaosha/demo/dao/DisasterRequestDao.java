package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.miaosha.demo.domain.DisasterRequest;

public interface DisasterRequestDao {
    @Insert("INSERT INTO disaster_request('key', `ID`, `date`, `disaster_type`, `status`, `o_url`, `request_unit`) VALUES " +
            "(#{dr.key},#{dr.id},#{dr.date},#{dr.disaster_type},#{dr.status}," +
            "#{dr.o_url},#{dr.reporting_unit})")
    public void Insert(@Param("dr") DisasterRequest dr);

    @Select("select * from disaster_request")
    public List<DisasterRequest> selectAll();

    @Select("select * from disaster_request where key = #{key}")
    public List<DisasterRequest> selectByKey(@Param("key") String key);
    
}
