package com.miaosha.demo.service;

import com.miaosha.demo.dao.DisasterDao;
import com.miaosha.demo.domain.Disaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisasterService {
    @Autowired
    DisasterDao disasterDao;
    public List<Disaster> selectAll() {
        return  disasterDao.selectAll();
    }

    public boolean insertByJson(List<Disaster> list){
        return disasterDao.insertForeach(list);
    }

    public void insertOne(Disaster disaster){
        disasterDao.Insert(disaster);
    }

    public List<Disaster> selectByType(String type){return disasterDao.selectByType(type);}

    public List<Disaster> selectByUnit(String reporting_unit){return disasterDao.selectByUnit(reporting_unit);}

    public boolean isDatasourceInput(String s) {
        if(s.equals("")) return false;
        else return true;
    }
}
