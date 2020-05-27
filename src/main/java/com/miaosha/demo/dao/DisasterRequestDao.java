package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.DisasterPrediction;
import com.miaosha.demo.domain.DisasterRequest;

public interface DisasterRequestDao {
    @Insert("INSERT INTO disaster_request('key', `id`, `date`, `disaster_type`, `status`, `o_url`, `request_unit`) VALUES " +
            "(#{dr.key},#{dr.id},#{dr.date},#{dr.disaster_type},#{dr.status}," +
            "#{dr.o_url},#{dr.reporting_unit})")
    public void Insert(@Param("dr") DisasterRequest dr);

    @Select("select * from disaster_request")
    public List<DisasterRequest> selectAll();

    @Select("select * from disaster_request where `key` = #{key}")
    public List<DisasterRequest> selectByKey(@Param("key") String key);
    
    @Delete("delete from disaster_request where 'key' = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Update("update collapse_record SET status=#{dr.status} where `key` = #{item.key} ")
    public void updateByKey(@Param("dr") DisasterRequest dr);
}
