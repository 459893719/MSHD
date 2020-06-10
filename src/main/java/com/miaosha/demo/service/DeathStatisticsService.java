package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.CollapseRecordDao;
import com.miaosha.demo.dao.DeathStatisticsDao;
import com.miaosha.demo.domain.CollapseRecord;
import com.miaosha.demo.domain.DeathStatistics;

@Service
public class DeathStatisticsService {
	
	static
	DeathStatisticsDao dsdao;
	
	@Autowired
	DeathStatisticsDao ddd;
	
    @PostConstruct
    public void init() {
    	dsdao = ddd;
    }
    
	public static List<DeathStatistics> selectAll() {
        return  dsdao.selectAll();
    }

    public static boolean insertByJson(List<DeathStatistics> list){
        return dsdao.insertForeach(list);
    }

    public static void insertOne(DeathStatistics dr){
    	dsdao.Insert(dr);
    }
    
    public static List<DeathStatistics> selectByKey(String key) {return dsdao.selectByKey(key);}

    public static List<DeathStatistics> selectByUnit(String reporting_unit){return dsdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	dsdao.deleteByKey(key);
    }
    
    public static void updateByKey(DeathStatistics ds) {
    	dsdao.updateByKey(ds);
    }
    
    public static void beifen() {
    	List<DeathStatistics> list = dsdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	dsdao.beifen(list);
    	dsdao.deleteAll();
    }
}
