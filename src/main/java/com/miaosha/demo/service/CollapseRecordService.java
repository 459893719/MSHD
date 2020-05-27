package com.miaosha.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.CollapseRecordDao;
import com.miaosha.demo.domain.CollapseRecord;

@Service
public class CollapseRecordService {
	@Autowired
	CollapseRecordDao crdao;
	
    public List<CollapseRecord> selectAll() {
        return  crdao.selectAll();
    }

    public boolean insertByJson(List<CollapseRecord> list){
        return crdao.insertForeach(list);
    }

    public void insertOne(CollapseRecord cr){
    	crdao.Insert(cr);
    }

    public List<CollapseRecord> selectByType(String type){return crdao.selectByType(type);}
    
    public List<CollapseRecord> selectByKey(String key) {return crdao.selectByKey(key);}

    public List<CollapseRecord> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public void updateByKey(CollapseRecord cr) {
    	crdao.updateByKey(cr);
    }
}
