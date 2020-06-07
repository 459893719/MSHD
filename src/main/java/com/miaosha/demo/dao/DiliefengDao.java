package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.Diliefeng;

public interface DiliefengDao {
    @Insert("INSERT INTO diliefeng(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.key},#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    public void Insert(@Param("cr") Diliefeng cr);

    @Select("select * from diliefeng")
    public List<Diliefeng> selectAll();

    @Select("select * from diliefeng where type = #{type}")
    public List<Diliefeng> selectByType(@Param("type") String type);

    @Select("select * from diliefeng where reporting_unit = #{reporting_unit}")
    public List<Diliefeng> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from diliefeng where `key` = #{key}")
    public List<Diliefeng> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO diliefeng(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Diliefeng> list);
    
    @Insert({
        "<script>",
        "INSERT INTO diliefeng_b_b(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Diliefeng> list);
    
    @Delete("delete from diliefeng where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from diliefeng")
    public void deleteAll();   
    
    @Update("update diliefeng SET id = #{cr.id},location=#{cr.location},date=#{cr.date},type=#{cr.type},status=#{cr.status},note=#{cr.note},picture=#{cr.picture},reporting_unit=#{cr.reporting_unit} where `key` = #{cr.key} ")
    public void updateByKey(@Param("cr") Diliefeng cr);
}
