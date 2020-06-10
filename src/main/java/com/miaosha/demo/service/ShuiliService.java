package com.miaosha.demo.service;

import com.miaosha.demo.dao.ShoushangDao;
import com.miaosha.demo.dao.ShuiliDao;
import com.miaosha.demo.domain.Shuili;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class ShuiliService {
    
    static
    ShuiliDao disasterDao;
    
	@Autowired
	ShuiliDao ddd;
	
    @PostConstruct
    public void init() {
    	disasterDao = ddd;
    }
    
    public static List<Shuili> selectAll() {
        return  disasterDao.selectAll();
    }

    public static boolean insertByJson(List<Shuili> list){
        return disasterDao.insertForeach(list);
    }

    public static void insertOne(Shuili disaster){
        disasterDao.Insert(disaster);
    }

    public static List<Shuili> selectByType(String type){return disasterDao.selectByType(type);}
    
    public static List<Shuili> selectByKey(String key) {return disasterDao.selectByKey(key);}

    public static List<Shuili> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public static boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
    
    public static void deleteByKey(String key) {
    	disasterDao.deleteByKey(key);
    }
    
    public static void updateByKey(Shuili d) {
    	disasterDao.updateByKey(d);
    }
    
    public static void beifen() {
    	List<Shuili> list = disasterDao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	disasterDao.beifen(list);
    	disasterDao.deleteAll();
    }
}
