package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.KuangjiaDao;
import com.miaosha.demo.dao.NishiliuDao;
import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.Nishiliu;

@Service
public class NishiliuService {
	
	static
	NishiliuDao crdao;
	
	@Autowired
	NishiliuDao ddd;
	
    @PostConstruct
    public void init() {
    	crdao = ddd;
    }
    
    public static List<Nishiliu> selectAll() {
        return  crdao.selectAll();
    }

    public static boolean insertByJson(List<Nishiliu> list){
        return crdao.insertForeach(list);
    }

    public static void insertOne(Nishiliu cr){
    	crdao.Insert(cr);
    }

    public static List<Nishiliu> selectByType(String type){return crdao.selectByType(type);}
    
    public static List<Nishiliu> selectByKey(String key) {return crdao.selectByKey(key);}

    public static List<Nishiliu> selectByUnit(String reporting_unit){return crdao.selectByUnit(reporting_unit);}
    
    public static void deleteByKey(String key) {
    	crdao.deleteByKey(key);
    }
    
    public static void updateByKey(Nishiliu cr) {
    	crdao.updateByKey(cr);
    }
    
    public static void beifen() {
    	List<Nishiliu> list = crdao.selectAll();
    	crdao.beifen(list);
    	crdao.deleteAll();
    }
}
