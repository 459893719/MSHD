package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DisasterRequestDao;
import com.miaosha.demo.dao.FangwuQitaDao;
import com.miaosha.demo.domain.FangwuQita;

@Service
public class FangwuQitaService {
	
	static
	FangwuQitaDao csdao;
	
	@Autowired
	FangwuQitaDao ddd;
	
    @PostConstruct
    public void init() {
    	csdao = ddd;
    }
    
    public static List<FangwuQita> selectAll() {
        return  csdao.selectAll();
    }

    public static boolean insertByJson(List<FangwuQita> list){
        return csdao.insertForeach(list);
    }

    public static void insertOne(FangwuQita cs){
        csdao.Insert(cs);
    }
    
    public static void deleteByKey(String key) {
    	csdao.deleteByKey(key);
    }
    
    public static void updateByKey(FangwuQita cs) {
    	csdao.updateByKey(cs);
    }
    
    public static List<FangwuQita> selectByKey(String key) {return csdao.selectByKey(key);}

    public static List<FangwuQita> selectByUnit(String reporting_unit){return csdao.selectByUnit(reporting_unit);}
    
    public static void beifen() {
    	List<FangwuQita> list = csdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	csdao.beifen(list);
    	csdao.deleteAll();
    }

}
