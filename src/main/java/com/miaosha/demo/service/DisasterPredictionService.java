package com.miaosha.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DisasterPredictionDao;
import com.miaosha.demo.domain.DisasterPrediction;

@Service
public class DisasterPredictionService {
	@Autowired
	DisasterPredictionDao dpdao;
	
	public List<DisasterPrediction> selectAll() {
        return  dpdao.selectAll();
    }

    public boolean insertByJson(List<DisasterPrediction> list){
        return dpdao.insertForeach(list);
    }

    public void insertOne(DisasterPrediction dp){
    	dpdao.Insert(dp);
    }

    public List<DisasterPrediction> selectByType(String type){return dpdao.selectByType(type);}
    
    public List<DisasterPrediction> selectByKey(String key) {return dpdao.selectByKey(key);}

    public List<DisasterPrediction> selectByUnit(String reporting_unit){return dpdao.selectByUnit(reporting_unit);}
}
