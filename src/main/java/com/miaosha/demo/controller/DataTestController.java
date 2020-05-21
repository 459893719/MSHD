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

import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.service.DisasterService;

@Controller
public class DataTestController {
	
	@Autowired
    DisasterService disasterService;
    List<Disaster> disaster = null;
	
	//显示CommDisaster所有的数据
    @RequestMapping(value = "/CommDisaster/showall")
    public String dataShow(Model model){
        disaster = disasterService.selectAll();
        model.addAttribute("disaster",disaster);
        return "showinfor/CommDisaster";
    }
	
	//CommDisaster query
    @RequestMapping(value = "/CommDisaster/query", method = RequestMethod.POST)
    @ResponseBody
    public Disaster commdisasterquery(@RequestParam("id") String id) {
    	Disaster disaster = new Disaster("1",id, "20200520", "北京", "1", "2", "123",
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
    	DeathStatistics ds = new DeathStatistics("1",id, "北京", "20200520", "114514", "202");
    	return ds;
    }
}
