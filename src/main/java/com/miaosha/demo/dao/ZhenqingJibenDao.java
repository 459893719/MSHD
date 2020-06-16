package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.ZhenqingJiben;

public interface ZhenqingJibenDao {
    @Insert("INSERT INTO zhenqingjiben(`id`, `date`, `location`, `longitude`, `latitude`, `depth`, `magnitude`, `intensity`, `type`, `picture`, `note`, `reporting_unit`) VALUES " +
            "(#{item.id}, #{item.date}, #{item.location}, #{item.longitude}, #{item.latitude}, #{item.depth}, #{item.magnitude}, #{item.intensity}, #{item.type}, #{item.picture}, #{item.note},#{item.reporting_unit})")
    public void Insert(@Param("item") ZhenqingJiben item);

    @Select("select * from zhenqingjiben ORDER BY `key` ASC")
    public List<ZhenqingJiben> selectAll();

    @Select("select * from zhenqingjiben where type = #{type}")
    public List<ZhenqingJiben> selectByType(@Param("type") String type);

    @Select("select * from zhenqingjiben where reporting_unit = #{reporting_unit}")
    public List<ZhenqingJiben> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from zhenqingjiben where `key` = #{key}")
    public List<ZhenqingJiben> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO zhenqingjiben(`id`, `date`, `location`, `longitude`, `latitude`, `depth`, `magnitude`, `intensity`, `type`, `picture`, `note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.longitude}, #{item.latitude}, #{item.depth}, #{item.magnitude}, #{item.intensity}, #{item.type}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<ZhenqingJiben> list);
    
    @Insert({
        "<script>",
        "INSERT INTO zhenqingjiben_b(`id`, `date`, `location`, `longitude`, `latitude`, `depth`, `magnitude`, `intensity`, `type`, `picture`, `note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.longitude}, #{item.latitude}, #{item.depth}, #{item.magnitude}, #{item.intensity}, #{item.type}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<ZhenqingJiben> list);
    
    @Delete("delete from zhenqingjiben where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from zhenqingjiben")
    public void deleteAll(); 
    
    @Update("update zhenqingjiben SET id=#{item.id}, date=#{item.date}, location=#{item.location}, longitude=#{item.longitude}, latitude=#{item.latitude}, depth=#{item.depth}, "
    		+ "magnitude=#{item.magnitude}, intensity=#{item.intensity}, type=#{item.type}, picture=#{item.picture}, note=#{item.note}, reporting_unit=#{item.reporting_unit} where `key` = #{item.key} ")
    public void updateByKey(@Param("item") ZhenqingJiben item);
}
