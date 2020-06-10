package com.miaosha.demo.service;

import com.miaosha.demo.dao.ShuiliDao;
import com.miaosha.demo.dao.ShuyouDao;
import com.miaosha.demo.domain.Shuyou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class ShuyouService {
    
    static
    ShuyouDao disasterDao;
    
	@Autowired
	ShuyouDao ddd;
	
    @PostConstruct
    public void init() {
    	disasterDao = ddd;
    }
    
    public static List<Shuyou> selectAll() {
        return  disasterDao.selectAll();
    }

    public static boolean insertByJson(List<Shuyou> list){
        return disasterDao.insertForeach(list);
    }

    public static void insertOne(Shuyou disaster){
        disasterDao.Insert(disaster);
    }

    public static List<Shuyou> selectByType(String type){return disasterDao.selectByType(type);}
    
    public static List<Shuyou> selectByKey(String key) {return disasterDao.selectByKey(key);}

    public static List<Shuyou> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public static boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
    
    public static void deleteByKey(String key) {
    	disasterDao.deleteByKey(key);
    }
    
    public static void updateByKey(Shuyou d) {
    	disasterDao.updateByKey(d);
    }
    
    public static void beifen() {
    	List<Shuyou> list = disasterDao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	disasterDao.beifen(list);
    	disasterDao.deleteAll();
    }
}
