package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DiliefengDao;
import com.miaosha.demo.dao.DimianchenjiangDao;
import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.Dimianchenjiang;

@Service
public class DimianchenjiangService {
	
	static
	DimianchenjiangDao crdao;
	
	@Autowired
	DimianchenjiangDao ddd;
	
    @PostConstruct
    public void init() {
    	crdao = ddd;
    }
    
    public static List<Dimianchenjiang> selectAll() {
        return  crdao.selectAll();
    }

    public static boolean insertByJson(List<Dimianchenjiang> list){
        return crdao.insertForeach(list);
    }

    public static void insertOne(Dimianchenjiang cr){
    	crdao.Insert(cr);
    }

    public static List<Dimianchenjiang> selectByType(String type){return crdao.selectByType(type);}
    
    public static List<Dimianchenjiang> selectByKey(String key) {return crdao.selectByKey(key);}

    public static List<Dimianchenjiang> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public static void updateByKey(Dimianchenjiang cr) {
    	crdao.updateByKey(cr);
    }
    
    public static void beifen() {
    	List<Dimianchenjiang> list = crdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	crdao.beifen(list);
    	crdao.deleteAll();
    }
}
