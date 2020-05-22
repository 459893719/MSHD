package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.miaosha.demo.domain.DeathStatistics;


public interface DeathStatisticsDao {
    @Insert("INSERT INTO death_statistics(`key`, `ID`, `location`, `date`, `number`, `reporting_unit`) VALUES " +
            "(#{ds.key},#{ds.id},#{ds.location},#{ds.date}," +
            "#{ds.number},#{ds.reporting_unit})")
    public void Insert(@Param("ds") DeathStatistics ds);

    @Select("select * from death_statistics")
    public List<DeathStatistics> selectAll();


    @Select("select * from death_statistics where reporting_unit = #{reporting_unit}")
    public List<DeathStatistics> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from death_statistics where `key` = #{key}")
    public List<DeathStatistics> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO death_statistics(`key`, `ID`, `location`, `date`, `number`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.key}, #{item.id}, #{item.location}, #{item.date}, #{item.number}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<DeathStatistics> list);
}
