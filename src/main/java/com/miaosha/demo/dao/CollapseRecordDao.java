package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.miaosha.demo.domain.CollapseRecord;

public interface CollapseRecordDao {
    @Insert("INSERT INTO collapse_record(`key`, `ID`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.key},#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    public void Insert(@Param("cr") CollapseRecord cr);

    @Select("select * from collapse_record")
    public List<CollapseRecord> selectAll();

    @Select("select * from collapse_record where type = #{type}")
    public List<CollapseRecord> selectByType(@Param("type") String type);

    @Select("select * from collapse_record where reporting_unit = #{reporting_unit}")
    public List<CollapseRecord> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from collapse_record where `key` = #{key}")
    public List<CollapseRecord> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO collapse_record(`key`, `ID`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.key}, #{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<CollapseRecord> list);
}
