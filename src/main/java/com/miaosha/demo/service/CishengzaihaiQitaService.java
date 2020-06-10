package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.CishengzaihaiQitaDao;
import com.miaosha.demo.dao.DisasterDao;
import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.CishengzaihaiQita;

@Service
public class CishengzaihaiQitaService {
    
	@Autowired
	CishengzaihaiQitaDao ddd;
	
	static
	CishengzaihaiQitaDao crdao;
	
    @PostConstruct
    public void init() {
    	crdao = ddd;
    }
    
    public static List<CishengzaihaiQita> selectAll() {
        return  crdao.selectAll();
    }

    public static boolean insertByJson(List<CishengzaihaiQita> list){
        return crdao.insertForeach(list);
    }

    public static void insertOne(CishengzaihaiQita cr){
    	crdao.Insert(cr);
    }

    public static List<CishengzaihaiQita> selectByType(String type){return crdao.selectByType(type);}
    
    public static List<CishengzaihaiQita> selectByKey(String key) {return crdao.selectByKey(key);}

    public static List<CishengzaihaiQita> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public static void updateByKey(CishengzaihaiQita cr) {
    	crdao.updateByKey(cr);
    }
    
    public static void beifen() {
    	List<CishengzaihaiQita> list = crdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	crdao.beifen(list);
    	crdao.deleteAll();
    }
}
