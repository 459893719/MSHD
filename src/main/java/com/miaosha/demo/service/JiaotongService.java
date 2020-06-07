package com.miaosha.demo.service;

import com.miaosha.demo.dao.HuapoDao;
import com.miaosha.demo.dao.JiaotongDao;
import com.miaosha.demo.domain.Jiaotong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class JiaotongService {
    
	static
    JiaotongDao disasterDao;
    
	@Autowired
	JiaotongDao ddd;
	
    @PostConstruct
    public void init() {
    	disasterDao = ddd;
    }
    
    public static List<Jiaotong> selectAll() {
        return  disasterDao.selectAll();
    }

    public static boolean insertByJson(List<Jiaotong> list){
        return disasterDao.insertForeach(list);
    }

    public static void insertOne(Jiaotong disaster){
        disasterDao.Insert(disaster);
    }

    public static List<Jiaotong> selectByType(String type){return disasterDao.selectByType(type);}
    
    public static List<Jiaotong> selectByKey(String key) {return disasterDao.selectByKey(key);}

    public static List<Jiaotong> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public static boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
    
    public static void deleteByKey(String key) {
    	disasterDao.deleteByKey(key);
    }
    
    public static void updateByKey(Jiaotong d) {
    	disasterDao.updateByKey(d);
    }
    
    public static void beifen() {
    	List<Jiaotong> list = disasterDao.selectAll();
    	disasterDao.beifen(list);
    	disasterDao.deleteAll();
    }
}
