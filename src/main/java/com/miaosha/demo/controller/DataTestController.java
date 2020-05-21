package com.miaosha.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.service.DisasterService;

@Controller
public class DataTestController {
	
	//显示CommDisaster所有的数据
    @RequestMapping(value = "/CommDisaster/showall")
    public String dataShow(Model model){
        Disaster disaster = new Disaster("1","12345", "20200520", "北京", "1", "2", "123",
    			"dsfowajgifdsaf asfddfsa sa", "202");
        List<Disaster> dList = new ArrayList<Disaster>();
        dList.add(disaster);
        model.addAttribute("disaster",disaster);
        return "showinfor/CommDisaster";
    }
	
	//CommDisaster query
    @RequestMapping(value = "/CommDisaster/query", method = RequestMethod.POST)
    @ResponseBody
    public Disaster commdisasterquery(@RequestParam("id") String id) {
    	Disaster disaster = new Disaster(id,"fdafsad", "20200520", "北京", "1", "2", "123",
    			"dsfowajgifdsaf asfddfsa sa", "202");
    	return disaster;
    }
    
    @RequestMapping(value = "/DeathStatistics/showall")
    public String dsShow(Model model){
        DeathStatistics ds = new DeathStatistics("1","12345", "北京", "20200520", "114514", "202");
        List<DeathStatistics> dslist = new ArrayList<DeathStatistics>();
        dslist.add(ds);
        model.addAttribute("deathlist",ds);
        return "showinfor/DeathStatistics";
    }
    
    @RequestMapping(value = "/DeathStatistics/query", method = RequestMethod.POST)
    @ResponseBody
    public DeathStatistics dsquery(@RequestParam("id") String id) {
    	DeathStatistics ds = new DeathStatistics(id,"fdsaf", "北京", "20200520", "114514", "202");
    	return ds;
    }
    
    @RequestMapping(value = "/CivilStructure/showall")
    public String csShow(Model model){
        CivilStructure cs = new CivilStructure("1", "123", "20200520", "beijing", "123m2", "456m2", "789m2",
        		"fdasfsdaffsadfsafsadfasdfsadfdsafadsfsaff", "202");
        List<CivilStructure> csList = new ArrayList<CivilStructure>();
        csList.add(cs);
        model.addAttribute("cslist",csList);
        return "showinfor/CivilStructure";
    }
    
    @RequestMapping(value = "/CivilStructure/query", method = RequestMethod.POST)
    @ResponseBody
    public CivilStructure csquery(@RequestParam("id") String id) {
    	CivilStructure cs = new CivilStructure("1", "123", "20200520", "beijing", "123m2", "456m2", "789m2",
        		"fdasfsdaffsadfsafsadfasdfsadfdsafadsfsaff", "202");
    	return cs;
    }
}
