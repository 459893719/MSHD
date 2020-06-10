package com.miaosha.demo.service;

import com.miaosha.demo.dao.DeathStatisticsDao;
import com.miaosha.demo.dao.DianliDao;
import com.miaosha.demo.domain.Dianli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class DianliService {
	
    static
    DianliDao disasterDao;
    
	@Autowired
	DianliDao ddd;
	
    @PostConstruct
    public void init() {
    	disasterDao = ddd;
    }
    
    public static List<Dianli> selectAll() {
        return  disasterDao.selectAll();
    }

    public static boolean insertByJson(List<Dianli> list){
        return disasterDao.insertForeach(list);
    }

    public static void insertOne(Dianli disaster){
        disasterDao.Insert(disaster);
    }

    public static List<Dianli> selectByType(String type){return disasterDao.selectByType(type);}
    
    public static List<Dianli> selectByKey(String key) {return disasterDao.selectByKey(key);}

    public static List<Dianli> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public static boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
    
    public static void deleteByKey(String key) {
    	disasterDao.deleteByKey(key);
    }
    
    public static void updateByKey(Dianli d) {
    	disasterDao.updateByKey(d);
    }
    
    public static void beifen() {
    	List<Dianli> list = disasterDao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	disasterDao.beifen(list);
    	disasterDao.deleteAll();
    }
}
