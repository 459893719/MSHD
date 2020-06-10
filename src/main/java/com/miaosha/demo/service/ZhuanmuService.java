package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.ZhuanhunDao;
import com.miaosha.demo.dao.ZhuanmuDao;
import com.miaosha.demo.domain.Zhuanmu;

@Service
public class ZhuanmuService {
	
	static
	ZhuanmuDao csdao;
	
	@Autowired
	ZhuanmuDao ddd;
	
    @PostConstruct
    public void init() {
    	csdao = ddd;
    }
    
    public static List<Zhuanmu> selectAll() {
        return  csdao.selectAll();
    }

    public static boolean insertByJson(List<Zhuanmu> list){
        return csdao.insertForeach(list);
    }

    public static void insertOne(Zhuanmu cs){
        csdao.Insert(cs);
    }
    
    public static void deleteByKey(String key) {
    	csdao.deleteByKey(key);
    }
    
    public static void updateByKey(Zhuanmu cs) {
    	csdao.updateByKey(cs);
    }
    
    public static List<Zhuanmu> selectByKey(String key) {return csdao.selectByKey(key);}

    public static List<Zhuanmu> selectByUnit(String reporting_unit){return csdao.selectByUnit(reporting_unit);}
    
    public static void beifen() {
    	List<Zhuanmu> list = csdao.selectAll();
    	if(list==null) {return;}
    	if(list.isEmpty()) return;
    	csdao.beifen(list);
    	csdao.deleteAll();
    }

}
