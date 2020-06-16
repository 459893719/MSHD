package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.Shizong;


public interface ShizongDao {
    @Insert("INSERT INTO shizong(`id`, `location`, `date`, `number`, `reporting_unit`) VALUES " +
            "(#{ds.id},#{ds.location},#{ds.date}," +
            "#{ds.number},#{ds.reporting_unit})")
    public void Insert(@Param("ds") Shizong ds);

    @Select("select * from shizong ORDER BY `key` ASC")
    public List<Shizong> selectAll();


    @Select("select * from shizong where reporting_unit = #{reporting_unit}")
    public List<Shizong> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from shizong where `key` = #{key}")
    public List<Shizong> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO shizong(`id`, `location`, `date`, `number`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.number}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Shizong> list);
    
    @Insert({
        "<script>",
        "INSERT INTO shizong_b(`id`, `location`, `date`, `number`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.number}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Shizong> list);
    
    @Delete("delete from shizong where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from shizong")
    public void deleteAll(); 
    
    @Update("update shizong SET id=#{ds.id},location=#{ds.location},date=#{ds.date},number=#{ds.number},reporting_unit=#{ds.reporting_unit} where `key` = #{ds.key} ")
    public void updateByKey(@Param("ds") Shizong ds);
}
