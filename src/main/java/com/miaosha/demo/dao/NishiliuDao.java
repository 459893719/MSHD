package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.Nishiliu;

public interface NishiliuDao {
    @Insert("INSERT INTO nishiliu(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    public void Insert(@Param("cr") Nishiliu cr);

    @Select("select * from nishiliu")
    public List<Nishiliu> selectAll();

    @Select("select * from nishiliu where type = #{type}")
    public List<Nishiliu> selectByType(@Param("type") String type);

    @Select("select * from nishiliu where reporting_unit = #{reporting_unit}")
    public List<Nishiliu> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from nishiliu where `key` = #{key}")
    public List<Nishiliu> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO nishiliu(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Nishiliu> list);
    
    @Insert({
        "<script>",
        "INSERT INTO nishiliu_b(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<Nishiliu> list);
    
    @Delete("delete from nishiliu where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from nishiliu")
    public void deleteAll(); 
    
    @Update("update nishiliu SET id = #{cr.id},location=#{cr.location},date=#{cr.date},type=#{cr.type},status=#{cr.status},note=#{cr.note},picture=#{cr.picture},reporting_unit=#{cr.reporting_unit} where `key` = #{cr.key} ")
    public void updateByKey(@Param("cr") Nishiliu cr);
}
