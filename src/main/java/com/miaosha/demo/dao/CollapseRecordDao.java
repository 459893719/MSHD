package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.CollapseRecord;

public interface CollapseRecordDao {
    @Insert("INSERT INTO collapse_record(`key`, `id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES " +
            "(#{cr.key},#{cr.id},#{cr.location},#{cr.date}," +
            "#{cr.type},#{cr.status},#{cr.note},#{cr.picture},#{cr.reporting_unit})")
    public void Insert(@Param("cr") CollapseRecord cr);

    @Select("select * from collapse_record")
    public List<CollapseRecord> selectAll();

    @Select("select * from collapse_record where type = #{type}")
    public List<CollapseRecord> selectByType(@Param("type") String type);

    @Select("select * from collapse_record where reporting_unit = #{reporting_unit}")
    public List<CollapseRecord> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from collapse_record where `key` = #{key}")
    public List<CollapseRecord> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO collapse_record(`key`, `id`, `location`, `date`, `type`, `status`, `note`, `picture`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.key}, #{item.id}, #{item.location}, #{item.date}, #{item.type}, #{item.status}, #{item.note}, #{item.picture}, #{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<CollapseRecord> list);
    
    @Delete("delete from collapse_record where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Update("update collapse_record SET id = #{cr.id},location=#{cr.location},date=#{cr.date},type=#{cr.type},status=#{cr.status},note=#{cr.note},picture=#{cr.picture},reporting_unit=#{cr.reporting_unit} where `key` = #{cr.key} ")
    public void updateByKey(@Param("cr") CollapseRecord cr);
}
