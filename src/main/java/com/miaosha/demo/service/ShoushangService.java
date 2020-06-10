package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.ShizongDao;
import com.miaosha.demo.dao.ShoushangDao;
import com.miaosha.demo.domain.Shoushang;

@Service
public class ShoushangService {
	
	static
	ShoushangDao dsdao;
	
	@Autowired
	ShoushangDao ddd;
	
    @PostConstruct
    public void init() {
    	dsdao = ddd;
    }
    
	public static List<Shoushang> selectAll() {
        return  dsdao.selectAll();
    }

    public static boolean insertByJson(List<Shoushang> list){
        return dsdao.insertForeach(list);
    }

    public static void insertOne(Shoushang dr){
    	dsdao.Insert(dr);
    }
    
    public static List<Shoushang> selectByKey(String key) {return dsdao.selectByKey(key);}

    public static List<Shoushang> selectByUnit(String reporting_unit){return dsdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	dsdao.deleteByKey(key);
    }
    
    public static void updateByKey(Shoushang ds) {
    	dsdao.updateByKey(ds);
    }
    
    public static void beifen() {
    	List<Shoushang> list = dsdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	dsdao.beifen(list);
    	dsdao.deleteAll();
    }
}
