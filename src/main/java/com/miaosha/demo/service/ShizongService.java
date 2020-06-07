package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.RanqiDao;
import com.miaosha.demo.dao.ShizongDao;
import com.miaosha.demo.domain.Shizong;

@Service
public class ShizongService {
	
	static
	ShizongDao dsdao;
	
	@Autowired
	ShizongDao ddd;
	
    @PostConstruct
    public void init() {
    	dsdao = ddd;
    }
    
	public static List<Shizong> selectAll() {
        return  dsdao.selectAll();
    }

    public static boolean insertByJson(List<Shizong> list){
        return dsdao.insertForeach(list);
    }

    public static void insertOne(Shizong dr){
    	dsdao.Insert(dr);
    }
    
    public static List<Shizong> selectByKey(String key) {return dsdao.selectByKey(key);}

    public static List<Shizong> selectByUnit(String reporting_unit){return dsdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	dsdao.deleteByKey(key);
    }
    
    public static void updateByKey(Shizong ds) {
    	dsdao.updateByKey(ds);
    }
    
    public static void beifen() {
    	List<Shizong> list = dsdao.selectAll();
    	dsdao.beifen(list);
    	dsdao.deleteAll();
    }
}
