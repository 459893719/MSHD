package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.Yanrongtanta;

public interface YanrongtantaDao {
    @Insert("INSERT INTO yanrongtanta(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    public void Insert(@Param("cr") Yanrongtanta cr);

    @Select("select * from yanrongtanta ORDER BY `key` ASC")
    public List<Yanrongtanta> selectAll();

    @Select("select * from yanrongtanta where type = #{type}")
    public List<Yanrongtanta> selectByType(@Param("type") String type);

    @Select("select * from yanrongtanta where reporting_unit = #{reporting_unit}")
    public List<Yanrongtanta> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from yanrongtanta where `key` = #{key}")
    public List<Yanrongtanta> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO yanrongtanta(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Yanrongtanta> list);
    
    @Insert({
        "<script>",
        "INSERT INTO yanrongtanta_b(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Yanrongtanta> list);
    
    @Delete("delete from yanrongtanta where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from yanrongtanta")
    public void deleteAll(); 
    
    @Update("update yanrongtanta SET id = #{cr.id},location=#{cr.location},date=#{cr.date},type=#{cr.type},status=#{cr.status},note=#{cr.note},picture=#{cr.picture},reporting_unit=#{cr.reporting_unit} where `key` = #{cr.key} ")
    public void updateByKey(@Param("cr") Yanrongtanta cr);
}
