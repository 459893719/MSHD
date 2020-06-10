package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.GongshuiDao;
import com.miaosha.demo.dao.HuapoDao;
import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.Huapo;

@Service
public class HuapoService {
	
	static
	HuapoDao crdao;
	
	@Autowired
	HuapoDao ddd;
	
    @PostConstruct
    public void init() {
    	crdao = ddd;
    }
    
    public static List<Huapo> selectAll() {
        return  crdao.selectAll();
    }

    public static boolean insertByJson(List<Huapo> list){
        return crdao.insertForeach(list);
    }

    public static void insertOne(Huapo cr){
    	crdao.Insert(cr);
    }

    public static List<Huapo> selectByType(String type){return crdao.selectByType(type);}
    
    public static List<Huapo> selectByKey(String key) {return crdao.selectByKey(key);}

    public static List<Huapo> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public static void updateByKey(Huapo cr) {
    	crdao.updateByKey(cr);
    }
    
    public static void beifen() {
    	List<Huapo> list = crdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	crdao.beifen(list);
    	crdao.deleteAll();
    }
}
