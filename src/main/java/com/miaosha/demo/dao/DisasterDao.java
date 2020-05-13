package com.miaosha.demo.dao;

import com.miaosha.demo.domain.Disaster;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DisasterDao {
    @Insert("INSERT INTO commdisaster(`ID`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES " +
            "(#{disaster.id},#{disaster.date},#{disaster.location},#{disaster.type}," +
            "#{disaster.grade},#{disaster.picture},#{disaster.note},#{disaster.reporting_unit})")
    public void Insert(@Param("disaster") Disaster disaster);

    @Select("select * from commdisaster")
    public List<Disaster> selectAll();

    @Select("select * from commdisaster where type = #{type}")
    public List<Disaster> selectByType(@Param("type") String type);

    @Select("select * from commdisaster where reporting_unit = #{reporting_unit}")
    public List<Disaster> selectByUnit(@Param("reporting_unit") String reporting_unit);

    @Insert({
     "<script>",
     "INSERT INTO commdisaster(`ID`, `date`, `location`, `type`, `grade`, `picture`,`note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.type}, #{item.grade}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<Disaster> list);
}
