package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.UserDao;
import com.miaosha.demo.dao.YanrongtantaDao;
import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.Yanrongtanta;

@Service
public class YanrongtantaService {
	
	static
	YanrongtantaDao crdao;
	
	@Autowired
	YanrongtantaDao ddd;
	
    @PostConstruct
    public void init() {
    	crdao = ddd;
    }
    
    public static List<Yanrongtanta> selectAll() {
        return  crdao.selectAll();
    }

    public static boolean insertByJson(List<Yanrongtanta> list){
        return crdao.insertForeach(list);
    }

    public static void insertOne(Yanrongtanta cr){
    	crdao.Insert(cr);
    }

    public static List<Yanrongtanta> selectByType(String type){return crdao.selectByType(type);}
    
    public static List<Yanrongtanta> selectByKey(String key) {return crdao.selectByKey(key);}

    public static List<Yanrongtanta> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public static void updateByKey(Yanrongtanta cr) {
    	crdao.updateByKey(cr);
    }
    
    public static void beifen() {
    	List<Yanrongtanta> list = crdao.selectAll();
    	crdao.beifen(list);
    	crdao.deleteAll();
    }
}
