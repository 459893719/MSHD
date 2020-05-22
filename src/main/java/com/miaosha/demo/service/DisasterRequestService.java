package com.miaosha.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miaosha.demo.dao.DisasterRequestDao;
import com.miaosha.demo.domain.DisasterRequest;

@Service
public class DisasterRequestService {
	@Autowired
	DisasterRequestDao drdao;

	public List<DisasterRequest> selectAll(){return drdao.selectAll();}
	
    public void insertOne(DisasterRequest dp){
    	drdao.Insert(dp);
    }
    
    public List<DisasterRequest> selectByKey(String key) {return drdao.selectByKey(key);}

}
