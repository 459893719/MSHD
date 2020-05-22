package com.miaosha.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.CivilStructureDao;
import com.miaosha.demo.domain.CivilStructure;

@Service
public class CivilStructureService {
	@Autowired
	CivilStructureDao csdao;
	
    public List<CivilStructure> selectAll() {
        return  csdao.selectAll();
    }

    public boolean insertByJson(List<CivilStructure> list){
        return csdao.insertForeach(list);
    }

    public void insertOne(CivilStructure cs){
        csdao.Insert(cs);
    }
    
    public List<CivilStructure> selectByKey(String key) {return csdao.selectByKey(key);}

    public List<CivilStructure> selectByUnit(String reporting_unit){return csdao.selectByUnit(reporting_unit);}

}
