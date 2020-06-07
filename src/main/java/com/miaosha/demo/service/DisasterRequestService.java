package com.miaosha.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DisasterPredictionDao;
import com.miaosha.demo.dao.DisasterRequestDao;
import com.miaosha.demo.domain.DisasterRequest;

@Service
public class DisasterRequestService {
	
	static
	DisasterRequestDao drdao;

	@Autowired
	DisasterRequestDao ddd;
	
    @PostConstruct
    public void init() {
    	drdao = ddd;
    }
    
	public static List<DisasterRequest> selectAll(){return drdao.selectAll();}
	
    public static void insertOne(DisasterRequest dp){
    	drdao.Insert(dp);
    }
    
    public static List<DisasterRequest> selectByKey(String key) {return drdao.selectByKey(key);}
    
    public static List<DisasterRequest> selectNotSend(){return drdao.selectNotSend();}
    
    public static List<DisasterRequest> selectSended(){return drdao.selectSended();}
    
    public static void updateByKey(DisasterRequest dr) {
    	drdao.updateByKey(dr);
    }
    
    public static void deleteByKey(String key) {
    	drdao.deleteByKey(key);
    }
    
    public static void send(DisasterRequest dr) {
    	drdao.send(dr);
    }
}
