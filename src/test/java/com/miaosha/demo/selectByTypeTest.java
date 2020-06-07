package com.miaosha.demo;

import static org.junit.Assert.*;

import com.miaosha.demo.dao.DisasterDao;
import com.miaosha.demo.dao.DisasterRequestDao;
import com.miaosha.demo.dao.UserDao;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.service.DisasterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

public class selectByTypeTest {

    DisasterService disasterService;
    @Test
    public void test() {
        //按类型查询，返回一个disaster的List
        List<Disaster> disaster;
        String type=new String("1");
        disaster = disasterService.selectByType(type);

        //创建一个 List用来存放正确的待检查数据
        List<Disaster> data = new ArrayList<>();
        Disaster a1 = new Disaster(null,"123456400000012001","2020-02-01 00:00:00","1",
                "1","1",null,"1","5");
        data.add(a1);

        System.out.println(disaster.get(0).toString());
        //检查查询到的结果与正确结果是否相同
//        for(int i=0;i<disaster.size();i++) {
//            assertTrue(disaster.get(i).toString().equals(data.get(i).toString()));
//        }

    }
    
    DisasterDao dd;
    DisasterRequestDao dr;
    UserDao d;
    @Test
    public void t() {
    	//d.selectByUsername("2017211960");
    }
    
    

}
