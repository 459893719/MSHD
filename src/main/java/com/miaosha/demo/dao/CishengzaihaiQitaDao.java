package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.CishengzaihaiQita;

public interface CishengzaihaiQitaDao {
    @Insert("INSERT INTO cishengzaihaiqita(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    public void Insert(@Param("cr") CishengzaihaiQita cr);

    @Select("select * from cishengzaihaiqita ORDER BY `key` ASC")
    public List<CishengzaihaiQita> selectAll();

    @Select("select * from cishengzaihaiqita where type = #{type}")
    public List<CishengzaihaiQita> selectByType(@Param("type") String type);

    @Select("select * from cishengzaihaiqita where reporting_unit = #{reporting_unit}")
    public List<CishengzaihaiQita> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from cishengzaihaiqita where `key` = #{key}")
    public List<CishengzaihaiQita> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO cishengzaihaiqita(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<CishengzaihaiQita> list);
    
    @Insert({
        "<script>",
        "INSERT INTO cishengzaihaiqita_b(`id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<CishengzaihaiQita> list);
    
    @Delete("delete from cishengzaihaiqita where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from cishengzaihaiqita")
    public void deleteAll();
    
    @Update("update cishengzaihaiqita SET id = #{cr.id},location=#{cr.location},date=#{cr.date},type=#{cr.type},status=#{cr.status},note=#{cr.note},picture=#{cr.picture},reporting_unit=#{cr.reporting_unit} where `key` = #{cr.key} ")
    public void updateByKey(@Param("cr") CishengzaihaiQita cr);
}
