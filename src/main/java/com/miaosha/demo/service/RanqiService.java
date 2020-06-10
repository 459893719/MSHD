package com.miaosha.demo.service;

import com.miaosha.demo.dao.NishiliuDao;
import com.miaosha.demo.dao.RanqiDao;
import com.miaosha.demo.domain.Ranqi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class RanqiService {
    
    static
    RanqiDao disasterDao;
    
	@Autowired
	RanqiDao ddd;
	
    @PostConstruct
    public void init() {
    	disasterDao = ddd;
    }
    
    public static List<Ranqi> selectAll() {
        return  disasterDao.selectAll();
    }

    public static boolean insertByJson(List<Ranqi> list){
        return disasterDao.insertForeach(list);
    }

    public static void insertOne(Ranqi disaster){
        disasterDao.Insert(disaster);
    }

    public static List<Ranqi> selectByType(String type){return disasterDao.selectByType(type);}
    
    public static List<Ranqi> selectByKey(String key) {return disasterDao.selectByKey(key);}

    public static List<Ranqi> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public static boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
    
    public static void deleteByKey(String key) {
    	disasterDao.deleteByKey(key);
    }
    
    public static void updateByKey(Ranqi d) {
    	disasterDao.updateByKey(d);
    }
    
    public static void beifen() {
    	List<Ranqi> list = disasterDao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	disasterDao.beifen(list);
    	disasterDao.deleteAll();
    }
}
