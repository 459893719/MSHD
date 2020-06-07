package com.miaosha.demo.dao;

import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.Ranqi;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RanqiDao {
    @Insert("INSERT INTO ranqi(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    public void Insert(@Param("disaster") Ranqi disaster);

    @Select("select * from ranqi")
    public List<Ranqi> selectAll();

    @Select("select * from ranqi where type = #{type}")
    public List<Ranqi> selectByType(@Param("type") String type);

    @Select("select * from ranqi where reporting_unit = #{reporting_unit}")
    public List<Ranqi> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from ranqi where `key` = #{key}")
    public List<Ranqi> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO ranqi(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Ranqi> list);
    
    @Insert({
        "<script>",
        "INSERT INTO ranqi_b(`id`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Ranqi> list);
    
    @Delete("delete from ranqi where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from ranqi")
    public void deleteAll(); 
    
    @Update("update ranqi SET id=#{disaster.id},date=#{disaster.date},location=#{disaster.location},type=#{disaster.type},grade=#{disaster.grade},"
    		+ "picture=#{disaster.picture},note=#{disaster.note},reporting_unit=#{disaster.reporting_unit} where `key` = #{disaster.key} ")
    public void updateByKey(@Param("disaster") Ranqi disaster);
}
