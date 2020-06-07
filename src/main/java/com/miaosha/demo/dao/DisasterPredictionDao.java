package com.miaosha.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.domain.DisasterPrediction;
import com.miaosha.demo.domain.DisasterRequest;

public interface DisasterPredictionDao {
    @Insert("INSERT INTO disaster_prediction(`id`, `date`, `location`, `longitude`, `latitude`, `depth`, `magnitude`, `intensity`, `type`, `picture`, `note`, `reporting_unit`) VALUES " +
            "(#{item.id}, #{item.date}, #{item.location}, #{item.longitude}, #{item.latitude}, #{item.depth}, #{item.magnitude}, #{item.intensity}, #{item.type}, #{item.picture}, #{item.note},#{item.reporting_unit})")
    public void Insert(@Param("item") DisasterPrediction item);

    @Select("select * from disaster_prediction")
    public List<DisasterPrediction> selectAll();

    @Select("select * from disaster_prediction where type = #{type}")
    public List<DisasterPrediction> selectByType(@Param("type") String type);

    @Select("select * from disaster_prediction where reporting_unit = #{reporting_unit}")
    public List<DisasterPrediction> selectByUnit(@Param("reporting_unit") String reporting_unit);
    
    @Select("select * from disaster_prediction where `key` = #{key}")
    public List<DisasterPrediction> selectByKey(@Param("key") String key);
    
    @Insert({
     "<script>",
     "INSERT INTO disaster_prediction(`id`, `date`, `location`, `longitude`, `latitude`, `depth`, `magnitude`, `intensity`, `type`, `picture`, `note`, `reporting_unit`) VALUES",
     "<foreach collection='list' item='item' index='index' separator=','>",
     "(#{item.id}, #{item.date}, #{item.location}, #{item.longitude}, #{item.latitude}, #{item.depth}, #{item.magnitude}, #{item.intensity}, #{item.type}, #{item.picture}, #{item.note},#{item.reporting_unit})",
     "</foreach>",
     "</script>"
    })
    public boolean insertForeach(@Param(value = "list") List<DisasterPrediction> list);
    
    @Insert({
        "<script>",
        "INSERT INTO disaster_prediction_b(`id`, `date`, `location`, `longitude`, `latitude`, `depth`, `magnitude`, `intensity`, `type`, `picture`, `note`, `reporting_unit`) VALUES",
        "<foreach collection='list' item='item' index='index' separator=','>",
        "(#{item.id}, #{item.date}, #{item.location}, #{item.longitude}, #{item.latitude}, #{item.depth}, #{item.magnitude}, #{item.intensity}, #{item.type}, #{item.picture}, #{item.note},#{item.reporting_unit})",
        "</foreach>",
        "</script>"
       })
    public boolean beifen(@Param(value = "list") List<DisasterPrediction> list);
    
    @Delete("delete from disaster_prediction where `key` = #{key}")
    public void deleteByKey(@Param("key") String key);
    
    @Delete("delete from disaster_prediction")
    public void deleteAll();   
    
    @Update("update disaster_prediction SET id=#{item.id}, date=#{item.date}, location=#{item.location}, longitude=#{item.longitude}, latitude=#{item.latitude}, depth=#{item.depth}, "
    		+ "magnitude=#{item.magnitude}, intensity=#{item.intensity}, type=#{item.type}, picture=#{item.picture}, note=#{item.note}, reporting_unit=#{item.reporting_unit} where `key` = #{item.key} ")
    public void updateByKey(@Param("item") DisasterPrediction item);
}
