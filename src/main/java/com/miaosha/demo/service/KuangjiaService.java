package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.JiaotongDao;
import com.miaosha.demo.dao.KuangjiaDao;
import com.miaosha.demo.domain.Kuangjia;

@Service
public class KuangjiaService {
	
	static
	KuangjiaDao csdao;
	
	@Autowired
	KuangjiaDao ddd;
	
    @PostConstruct
    public void init() {
    	csdao = ddd;
    }
    
    public static List<Kuangjia> selectAll() {
        return  csdao.selectAll();
    }

    public static boolean insertByJson(List<Kuangjia> list){
        return csdao.insertForeach(list);
    }

    public static void insertOne(Kuangjia cs){
        csdao.Insert(cs);
    }
    
    public static void deleteByKey(String key) {
    	csdao.deleteByKey(key);
    }
    
    public static void updateByKey(Kuangjia cs) {
    	csdao.updateByKey(cs);
    }
    
    public static List<Kuangjia> selectByKey(String key) {return csdao.selectByKey(key);}

    public static List<Kuangjia> selectByUnit(String reporting_unit){return csdao.selectByUnit(reporting_unit);}
    
    public static void beifen() {
    	List<Kuangjia> list = csdao.selectAll();
    	csdao.beifen(list);
    	csdao.deleteAll();
    }

}
