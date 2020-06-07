package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.YanrongtantaDao;
import com.miaosha.demo.dao.ZhenqingJibenDao;
import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.ZhenqingJiben;

@Service
public class ZhenqingJibenService {
	
	static
	ZhenqingJibenDao dpdao;
	
	@Autowired
	ZhenqingJibenDao ddd;
	
    @PostConstruct
    public void init() {
    	dpdao = ddd;
    }
    
	public static List<ZhenqingJiben> selectAll() {
        return  dpdao.selectAll();
    }

    public static boolean insertByJson(List<ZhenqingJiben> list){
        return dpdao.insertForeach(list);
    }

    public static void insertOne(ZhenqingJiben dp){
    	dpdao.Insert(dp);
    }

    public static List<ZhenqingJiben> selectByType(String type){return dpdao.selectByType(type);}
    
    public static List<ZhenqingJiben> selectByKey(String key) {return dpdao.selectByKey(key);}

    public static List<ZhenqingJiben> selectByUnit(String reporting_unit){return dpdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	dpdao.deleteByKey(key);
    }
    
    public static void updateByKey(ZhenqingJiben dp) {
    	dpdao.updateByKey(dp);
    }
    
    public static void beifen() {
    	List<ZhenqingJiben> list = dpdao.selectAll();
    	dpdao.beifen(list);
    	dpdao.deleteAll();
    }
}
