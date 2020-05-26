package com.miaosha.demo.service;

import com.miaosha.demo.dao.UserDao;
import com.miaosha.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<User> selectAll() {
        return userDao.selectAll();
    }
    
    public List<User> getById(int id) {
    	List<User> user=new ArrayList<User>();
    	user.add(userDao.getById(id));
        return user;
    }
    public void insertUser(User user) {
        userDao.insert(user);
    }
    public void modifyById(int id,User user) {
        userDao.modifyById(id, user);;
    }
    public void deleteById(int id) {
        userDao.deleteById(id);
    }
}
