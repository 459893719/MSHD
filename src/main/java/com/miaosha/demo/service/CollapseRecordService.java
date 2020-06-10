package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.CollapseRecordDao;
import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.CollapseRecord;

@Service
public class CollapseRecordService {
	static
	CollapseRecordDao crdao;
	
	@Autowired
	CollapseRecordDao ddd;
	
    @PostConstruct
    public void init() {
    	crdao = ddd;
    }
    
    public static List<CollapseRecord> selectAll() {
        return  crdao.selectAll();
    }

    public static boolean insertByJson(List<CollapseRecord> list){
        return crdao.insertForeach(list);
    }

    public static void insertOne(CollapseRecord cr){
    	crdao.Insert(cr);
    }

    public static List<CollapseRecord> selectByType(String type){return crdao.selectByType(type);}
    
    public static List<CollapseRecord> selectByKey(String key) {return crdao.selectByKey(key);}

    public static List<CollapseRecord> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public static void updateByKey(CollapseRecord cr) {
    	crdao.updateByKey(cr);
    }
    
    public static void beifen() {
    	List<CollapseRecord> list = crdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	crdao.beifen(list);
    	crdao.deleteAll();
    }
}
