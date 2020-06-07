package com.miaosha.demo.service;

import com.miaosha.demo.dao.ShuyouDao;
import com.miaosha.demo.dao.UserDao;
import com.miaosha.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    
    static
    UserDao userDao;
    
	@Autowired
	UserDao ddd;
	
    @PostConstruct
    public void init() {
    	userDao = ddd;
    }
    
    public static List<User> selectAll() {
        return userDao.selectAll();
    }
    
    public static List<User> getById(int id) {
    	List<User> user=new ArrayList<User>();
    	user.add(userDao.getById(id));
        return user;
    }
    public static void insertUser(User user) {
        userDao.insert(user);
    }
    public static void modifyById(int id,User user) {
        userDao.modifyById(id, user);;
    }
    public static void deleteById(int id) {
        userDao.deleteById(id);
    }
    
    public static boolean isIdExist(int id) {
    	List<User> ulist = userDao.selectById(id);
    	if(!ulist.isEmpty()) return true;
    	return false;
    }
    
    public static boolean checkLogin(String username, String password) {
    	List<User> ulist = userDao.selectByUsername(username);
    	if(ulist.isEmpty()) return false;
    	if(!ulist.get(0).getPassword().equals(password)) return false;
    	return true;
    }
}
