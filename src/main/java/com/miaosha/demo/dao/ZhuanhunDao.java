package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.Zhuanhun;

public interface ZhuanhunDao {
    @Insert("INSERT INTO zhuanhun(`id`, `date`, `location`, `basically_intact_square`, `damaged_square`, `destroyed_square`,`note`, `reporting_unit`) VALUES " +
            "(#{cs.id},#{cs.date},#{cs.location},#{cs.basically_intact_square},#{cs.damaged_square}," +
            "#{cs.destroyed_square},#{cs.note},#{cs.reporting_unit})")
    public void Insert(@Param("cs") Zhuanhun cs);

    @Select("select * from zhuanhun ORDER BY `key` ASC")
    public List<Zhuanhun> selectAll();

    @Select("select * from zhuanhun where reporting_unit = #{reporting_unit}")
    public List<Zhuanhun> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from zhuanhun where `key` = #{key}")
    public List<Zhuanhun> selectByKey(@Param("key") String key);
    
    @Delete("delete from zhuanhun where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from zhuanhun")
    public void deleteAll(); 
    
    @Update("update zhuanhun SET id = #{cs.id}, date = #{cs.date}, location = #{cs.location}, basically_intact_square = #{cs.basically_intact_square}, damaged_square=#{cs.damaged_square},"
    		+ "destroyed_square = #{cs.destroyed_square},note = #{cs.note},reporting_unit = #{cs.reporting_unit} where `key` = #{cs.key} ")
    public void updateByKey(@Param("cs") Zhuanhun cs);
    
    @Insert({
     "<script>",
     "INSERT INTO zhuanhun(`id`, `date`, `location`, `basically_intact_square`, `damaged_square`, `destroyed_square`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.basically_intact_square}, #{item.damaged_square}, #{item.destroyed_square}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Zhuanhun> list);
    
    @Insert({
        "<script>",
        "INSERT INTO zhuanhun_b(`id`, `date`, `location`, `basically_intact_square`, `damaged_square`, `destroyed_square`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.basically_intact_square}, #{item.damaged_square}, #{item.destroyed_square}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Zhuanhun> list);
}
