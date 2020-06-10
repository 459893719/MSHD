package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DianliDao;
import com.miaosha.demo.dao.DiliefengDao;
import com.miaosha.demo.domain.Diliefeng;

@Service
public class DiliefengService {
	
	static
	DiliefengDao crdao;
	
	@Autowired
	DiliefengDao ddd;
	
    @PostConstruct
    public void init() {
    	crdao = ddd;
    }
    
    public static List<Diliefeng> selectAll() {
        return crdao.selectAll();
    }

    public static boolean insertByJson(List<Diliefeng> list){
        return crdao.insertForeach(list);
    }

    public static void insertOne(Diliefeng cr){
    	crdao.Insert(cr);
    }

    public static List<Diliefeng> selectByType(String type){return crdao.selectByType(type);}
    
    public static List<Diliefeng> selectByKey(String key) {return crdao.selectByKey(key);}

    public static List<Diliefeng> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public static void updateByKey(Diliefeng cr) {
    	crdao.updateByKey(cr);
    }
    
    public static void beifen() {
    	List<Diliefeng> list = crdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	crdao.beifen(list);
    	crdao.deleteAll();
    }
}
