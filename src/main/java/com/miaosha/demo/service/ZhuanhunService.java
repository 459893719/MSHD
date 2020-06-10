package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.ZhenqingJibenDao;
import com.miaosha.demo.dao.ZhuanhunDao;
import com.miaosha.demo.domain.Zhuanhun;

@Service
public class ZhuanhunService {
	
	static
	ZhuanhunDao csdao;
	
	@Autowired
	ZhuanhunDao ddd;
	
    @PostConstruct
    public void init() {
    	csdao = ddd;
    }
    
    public static List<Zhuanhun> selectAll() {
        return  csdao.selectAll();
    }

    public static boolean insertByJson(List<Zhuanhun> list){
        return csdao.insertForeach(list);
    }

    public static void insertOne(Zhuanhun cs){
        csdao.Insert(cs);
    }
    
    public static void deleteByKey(String key) {
    	csdao.deleteByKey(key);
    }
    
    public static void updateByKey(Zhuanhun cs) {
    	csdao.updateByKey(cs);
    }
    
    public static List<Zhuanhun> selectByKey(String key) {return csdao.selectByKey(key);}

    public static List<Zhuanhun> selectByUnit(String reporting_unit){return csdao.selectByUnit(reporting_unit);}
    
    public static void beifen() {
    	List<Zhuanhun> list = csdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	csdao.beifen(list);
    	csdao.deleteAll();
    }

}
