package com.miaosha.demo.dao;

import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.Dianli;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DianliDao {
    @Insert("INSERT INTO dianli(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    public void Insert(@Param("disaster") Dianli disaster);

    @Select("select * from dianli")
    public List<Dianli> selectAll();

    @Select("select * from dianli where type = #{type}")
    public List<Dianli> selectByType(@Param("type") String type);

    @Select("select * from dianli where reporting_unit = #{reporting_unit}")
    public List<Dianli> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from dianli where `key` = #{key}")
    public List<Dianli> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO dianli(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Dianli> list);
    
    @Insert({
        "<script>",
        "INSERT INTO dianli_b(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Dianli> list);
    
    @Delete("delete from dianli where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from dianli")
    public void deleteAll();    
    
    @Update("update dianli SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    public void updateByKey(@Param("disaster") Dianli disaster);
}
