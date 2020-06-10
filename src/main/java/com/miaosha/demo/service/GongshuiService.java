package com.miaosha.demo.service;

import com.miaosha.demo.dao.FangwuQitaDao;
import com.miaosha.demo.dao.GongshuiDao;
import com.miaosha.demo.domain.Gongshui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class GongshuiService {
    
    static
    GongshuiDao disasterDao;
    
	@Autowired
	GongshuiDao ddd;
	
    @PostConstruct
    public void init() {
    	disasterDao = ddd;
    }
    
    public static List<Gongshui> selectAll() {
        return  disasterDao.selectAll();
    }

    public static boolean insertByJson(List<Gongshui> list){
        return disasterDao.insertForeach(list);
    }

    public static void insertOne(Gongshui disaster){
        disasterDao.Insert(disaster);
    }

    public static List<Gongshui> selectByType(String type){return disasterDao.selectByType(type);}
    
    public static List<Gongshui> selectByKey(String key) {return disasterDao.selectByKey(key);}

    public static List<Gongshui> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public static boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
    
    public static void deleteByKey(String key) {
    	disasterDao.deleteByKey(key);
    }
    
    public static void updateByKey(Gongshui d) {
    	disasterDao.updateByKey(d);
    }
    
    public static void beifen() {
    	List<Gongshui> list = disasterDao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	disasterDao.beifen(list);
    	disasterDao.deleteAll();
    }
}
