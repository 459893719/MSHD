package com.miaosha.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.CivilStructure;
import com.miaosha.demo.domain.CollapseRecord;
import com.miaosha.demo.domain.DeathStatistics;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.domain.DisasterPrediction;
import com.miaosha.demo.service.CivilStructureService;
import com.miaosha.demo.service.CollapseRecordService;
import com.miaosha.demo.service.DeathStatisticsService;
import com.miaosha.demo.service.DisasterPredictionService;
import com.miaosha.demo.service.DisasterService;

@Controller
public class DatashowController {
	
	// comm_disaster 表
    @Autowired
    DisasterService disasterService;
    List<Disaster> disasterlist = null;
	//显示CommDisaster所有的数据
    @RequestMapping(value = "/CommDisaster/showall")
    public String dataShow(Model model){
        disasterlist = disasterService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/CommDisaster";
    }
	
	//CommDisaster query
    @RequestMapping(value = "/CommDisaster/query", method = RequestMethod.POST)
    @ResponseBody
    public Disaster commdisasterquery(@RequestParam("id") String id) {
    	return disasterService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/CommDisaster/delete", method = RequestMethod.DELETE)
    public String cddelete(@RequestParam("id") String key){
        disasterService.deleteByKey(key);
        return "showinfor/CommDisaster";
    }
    
    @RequestMapping(value = "/CommDisaster/update", method = RequestMethod.POST)
    @ResponseBody
    public String cdquery(@RequestBody JSONObject json){
    	Disaster disaster = (Disaster) JSONObject.toJavaObject(json, Disaster.class);
    	disasterService.updateByKey(disaster);
        return "success";
    }
    
    

    // death_statistics表
    @Autowired
    DeathStatisticsService dsService;
    List<DeathStatistics> dslist = null;
    
    @RequestMapping(value = "/DeathStatistics/showall")
    public String dsShow(Model model){
    	dslist = dsService.selectAll();
        model.addAttribute("deathlist",dslist);
        return "showinfor/DeathStatistics";
    }
    
    @RequestMapping(value = "/DeathStatistics/query", method = RequestMethod.POST)
    @ResponseBody
    public DeathStatistics dsquery(@RequestParam("id") String id) {
    	
    	return dsService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/DeathStatistics/delete", method = RequestMethod.DELETE)
    public String dsdelete(@RequestParam("id") String key){
        dsService.deleteByKey(key);
        return "showinfor/DeathStatistics";
    }
    
    @RequestMapping(value = "/DeathStatistics/update", method = RequestMethod.POST)
    @ResponseBody
    public String dsquery(@RequestBody JSONObject json){
    	DeathStatistics ds = JSONObject.toJavaObject(json, DeathStatistics.class);
    	dsService.updateByKey(ds);
        return "success";
    }
    
    // civil_structure表
    @Autowired
    CivilStructureService csService;
    List<CivilStructure> cslist = null;
    
    @RequestMapping(value = "/CivilStructure/showall")
    public String csShow(Model model){
    	cslist = csService.selectAll();
        model.addAttribute("cslist",cslist);
        return "showinfor/CivilStructure";
    }
    
    @RequestMapping(value = "/CivilStructure/query", method = RequestMethod.POST)
    @ResponseBody
    public CivilStructure csquery(@RequestParam("id") String id) {
    	return csService.selectByKey(id).get(0);
    }
    
    
    /**
     * CollapseRecord
     */
    @Autowired
    CollapseRecordService crService;
    List<CollapseRecord> crlist = null;
    
    @RequestMapping(value = "/CollapseRecord/showall")
    public String crShow(Model model){
    	crlist = crService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/CollapseRecord";
    }
    
    @RequestMapping(value = "/CollapseRecord/query", method = RequestMethod.POST)
    @ResponseBody
    public CollapseRecord crquery(@RequestParam("id") String id) {
    	return crService.selectByKey(id).get(0);
    }
    
    /**
     * DisasterPrediction
     */
    @Autowired
    DisasterPredictionService dpService;
    List<DisasterPrediction> dplist = null;
    
    @RequestMapping(value = "/DisasterPrediction/showall")
    public String dpShow(Model model){
    	dplist = dpService.selectAll();
    	model.addAttribute("dplist",dplist);
    	return "showinfor/DisasterPrediction";
    }
    
    @RequestMapping(value = "/DisasterPrediction/query", method = RequestMethod.POST)
    @ResponseBody
    public DisasterPrediction dpquery(@RequestParam("id") String id) {
    	return dpService.selectByKey(id).get(0);
    }
}
