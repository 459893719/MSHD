package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.Zhuanmu;

public interface ZhuanmuDao {
    @Insert("INSERT INTO zhuanmu(`id`, `date`, `location`, `basically_intact_square`, `damaged_square`, `destroyed_square`,`note`, `reporting_unit`) VALUES " +
            "(#{cs.id},#{cs.date},#{cs.location},#{cs.basically_intact_square},#{cs.damaged_square}," +
            "#{cs.destroyed_square},#{cs.note},#{cs.reporting_unit})")
    public void Insert(@Param("cs") Zhuanmu cs);

    @Select("select * from zhuanmu")
    public List<Zhuanmu> selectAll();

    @Select("select * from zhuanmu where reporting_unit = #{reporting_unit}")
    public List<Zhuanmu> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from zhuanmu where `key` = #{key}")
    public List<Zhuanmu> selectByKey(@Param("key") String key);
    
    @Delete("delete from zhuanmu where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from zhuanmu")
    public void deleteAll(); 
    
    @Update("update zhuanmu SET id = #{cs.id}, date = #{cs.date}, basically_intact_square = #{cs.basically_intact_square}, damaged_square=#{cs.damaged_square},"
    		+ "destroyed_square = #{cs.destroyed_square},note = #{cs.note},reporting_unit = #{cs.reporting_unit} where `key` = #{cs.key} ")
    public void updateByKey(@Param("cs") Zhuanmu cs);
    
    @Insert({
     "<script>",
     "INSERT INTO zhuanmu(`id`, `date`, `location`, `basically_intact_square`, `damaged_square`, `destroyed_square`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.basically_intact_square}, #{item.damaged_square}, #{item.destroyed_square}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Zhuanmu> list);
    
    @Insert({
        "<script>",
        "INSERT INTO zhuanmu_b(`id`, `date`, `location`, `basically_intact_square`, `damaged_square`, `destroyed_square`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.basically_intact_square}, #{item.damaged_square}, #{item.destroyed_square}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Zhuanmu> list);
}
