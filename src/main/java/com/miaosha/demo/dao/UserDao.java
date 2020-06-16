package com.miaosha.demo.dao;

import com.miaosha.demo.domain.User;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserDao {
	@Select("select * from t_user ORDER BY id ASC")
	public List<User> selectAll();
	
    @Select("select * from t_user where id=#{id}")//@Param("id")进行引用
    public User getById(@Param("id") int id);
    
    @Insert("INSERT INTO t_user(`id`,`name`,`password`)  VALUES (#{user.id},#{user.name},#{user.password})")  //id为自增的，所以可以不用设置id
    public void insert(@Param("user") User user);
    
    @Update("UPDATE t_user SET name = #{user.name}, password = #{user.password} where id = #{user.id} ")//@Param("id")进行引用
    public void modifyById(@Param("id") int id, @Param("user") User user);
    
    @Delete("delete from t_user where id = #{id}")
    public void deleteById(@Param("id") int id);
    
    @Select("select * from t_user where id=#{id}")
    public List<User> selectById(@Param("id") int id);
    
    @Select("select * from t_user where `name`= #{name}")
    public List<User> selectByUsername(@Param("name") String name);
}
