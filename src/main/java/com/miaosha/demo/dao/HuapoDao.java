package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.Huapo;

public interface HuapoDao {
    @Insert("INSERT INTO huapo(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    public void Insert(@Param("cr") Huapo cr);

    @Select("select * from huapo")
    public List<Huapo> selectAll();

    @Select("select * from huapo where type = #{type}")
    public List<Huapo> selectByType(@Param("type") String type);

    @Select("select * from huapo where reporting_unit = #{reporting_unit}")
    public List<Huapo> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from huapo where `key` = #{key}")
    public List<Huapo> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO huapo(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Huapo> list);
    
    @Insert({
        "<script>",
        "INSERT INTO huapo_b(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Huapo> list);
    
    @Delete("delete from huapo where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from huapo")
    public void deleteAll();   
    
    @Update("update huapo SET id = #{cr.id},location=#{cr.location},date=#{cr.date},type=#{cr.type},status=#{cr.status},note=#{cr.note},picture=#{cr.picture},reporting_unit=#{cr.reporting_unit} where `key` = #{cr.key} ")
    public void updateByKey(@Param("cr") Huapo cr);
}
