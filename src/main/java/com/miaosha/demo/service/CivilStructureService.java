package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.CivilStructureDao;
import com.miaosha.demo.domain.CivilStructure;

@Service
public class CivilStructureService {
	@Autowired
	CivilStructureDao ddd;
	
	static
	CivilStructureDao csdao;
	
    @PostConstruct
    public void init() {
    	csdao = ddd;
    }
    
    public static List<CivilStructure> selectAll() {
        return  csdao.selectAll();
    }

    public static boolean insertByJson(List<CivilStructure> list){
        return csdao.insertForeach(list);
    }

    public static void insertOne(CivilStructure cs){
        csdao.Insert(cs);
    }
    
    public static void deleteByKey(String key) {
    	csdao.deleteByKey(key);
    }
    
    public static void updateByKey(CivilStructure cs) {
    	csdao.updateByKey(cs);
    }
    
    public static List<CivilStructure> selectByKey(String key) {return csdao.selectByKey(key);}

    public static List<CivilStructure> selectByUnit(String reporting_unit){return csdao.selectByUnit(reporting_unit);}
    
    public static void beifen() {
    	List<CivilStructure> list = csdao.selectAll();
    	csdao.beifen(list);
    	csdao.deleteAll();
    }

}
