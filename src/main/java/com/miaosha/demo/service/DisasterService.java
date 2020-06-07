package com.miaosha.demo.service;

import com.miaosha.demo.dao.DisasterDao;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.domain.DisasterPrediction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class DisasterService {
    @Autowired
    DisasterDao ddd;
    
    static
    DisasterDao disasterDao;
    
    @PostConstruct
    public void init() {
    	disasterDao = ddd;
    }
    
    public static List<Disaster> selectAll() {
        return  disasterDao.selectAll();
    }

    public static boolean insertByJson(List<Disaster> list){
        return disasterDao.insertForeach(list);
    }

    public static void insertOne(Disaster disaster){
        disasterDao.Insert(disaster);
    }

    public static List<Disaster> selectByType(String type){return disasterDao.selectByType(type);}
    
    public static List<Disaster> selectByKey(String key) {return disasterDao.selectByKey(key);}

    public static List<Disaster> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public static boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
    
    public static void deleteByKey(String key) {
    	disasterDao.deleteByKey(key);
    }
    
    public static void updateByKey(Disaster d) {
    	disasterDao.updateByKey(d);
    }
    
    public static void beifen() {
    	List<Disaster> list = disasterDao.selectAll();
    	disasterDao.beifen(list);
    	disasterDao.deleteAll();
    }
}
