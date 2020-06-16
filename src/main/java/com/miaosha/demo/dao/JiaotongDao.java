package com.miaosha.demo.dao;

import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.Jiaotong;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface JiaotongDao {
    @Insert("INSERT INTO jiaotong(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    public void Insert(@Param("disaster") Jiaotong disaster);

    @Select("select * from jiaotong ORDER BY `key` ASC")
    public List<Jiaotong> selectAll();

    @Select("select * from jiaotong where type = #{type}")
    public List<Jiaotong> selectByType(@Param("type") String type);

    @Select("select * from jiaotong where reporting_unit = #{reporting_unit}")
    public List<Jiaotong> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from jiaotong where `key` = #{key}")
    public List<Jiaotong> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO jiaotong_b(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean beifen(@Param(value = "list") List<Jiaotong> list);
    
    @Insert({
        "<script>",
        "INSERT INTO jiaotong(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean insertForeach(@Param(value = "list") List<Jiaotong> list);
    
    @Delete("delete from jiaotong where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from jiaotong")
    public void deleteAll();  
    
    @Update("update jiaotong SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    public void updateByKey(@Param("disaster") Jiaotong disaster);
}
