package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DimianchenjiangDao;
import com.miaosha.demo.dao.DisasterPredictionDao;
import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.DisasterPrediction;

@Service
public class DisasterPredictionService {
	
	static
	DisasterPredictionDao dpdao;
	
	@Autowired
	DisasterPredictionDao ddd;
	
    @PostConstruct
    public void init() {
    	dpdao = ddd;
    }
    
	public static List<DisasterPrediction> selectAll() {
        return  dpdao.selectAll();
    }

    public static boolean insertByJson(List<DisasterPrediction> list){
        return dpdao.insertForeach(list);
    }

    public static void insertOne(DisasterPrediction dp){
    	dpdao.Insert(dp);
    }

    public static List<DisasterPrediction> selectByType(String type){return dpdao.selectByType(type);}
    
    public static List<DisasterPrediction> selectByKey(String key) {return dpdao.selectByKey(key);}

    public static List<DisasterPrediction> selectByUnit(String reporting_unit){return dpdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	dpdao.deleteByKey(key);
    }
    
    public static void updateByKey(DisasterPrediction dp) {
    	dpdao.updateByKey(dp);
    }
    
    public static void beifen() {
    	List<DisasterPrediction> list = dpdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	dpdao.beifen(list);
    	dpdao.deleteAll();
    }
}
