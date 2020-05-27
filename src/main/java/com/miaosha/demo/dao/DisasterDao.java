package com.miaosha.demo.dao;

import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.domain.DisasterRequest;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DisasterDao {
    @Insert("INSERT INTO comm_disaster(`key`, `id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.key},#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    public void Insert(@Param("disaster") Disaster disaster);

    @Select("select * from comm_disaster")
    public List<Disaster> selectAll();

    @Select("select * from comm_disaster where type = #{type}")
    public List<Disaster> selectByType(@Param("type") String type);

    @Select("select * from comm_disaster where reporting_unit = #{reporting_unit}")
    public List<Disaster> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from comm_disaster where `key` = #{key}")
    public List<Disaster> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO comm_disaster(`key`,`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.key},#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Disaster> list);
    
    @Delete("delete from comm_disaster where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Update("update comm_disaster SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    public void updateByKey(@Param("disaster") Disaster disaster);
}
