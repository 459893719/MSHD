package com.miaosha.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DeathStatisticsDao;
import com.miaosha.demo.domain.DeathStatistics;

@Service
public class DeathStatisticsService {
	@Autowired
	DeathStatisticsDao dsdao;
	
	public List<DeathStatistics> selectAll() {
        return  dsdao.selectAll();
    }

    public boolean insertByJson(List<DeathStatistics> list){
        return dsdao.insertForeach(list);
    }

    public void insertOne(DeathStatistics dr){
    	dsdao.Insert(dr);
    }
    
    public List<DeathStatistics> selectByKey(String key) {return dsdao.selectByKey(key);}

    public List<DeathStatistics> selectByUnit(String reporting_unit){return dsdao.selectByUnit(reporting_unit);}
    
    public void deleteByKey(String key) {
    	dsdao.deleteByKey(key);
    }
    
    public void updateByKey(DeathStatistics ds) {
    	dsdao.updateByKey(ds);
    }
}
