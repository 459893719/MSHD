package com.miaosha.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.*;
import com.miaosha.demo.service.*;

@Controller
public class DatashowController {
	
      
 // 人员伤亡及失踪 ——————————————————————————————————————————————————————————————————————
    // death_statistics表 
    @RequestMapping(value = "/DeathStatistics", method = RequestMethod.GET)
    public String dsShow(Model model){
    	List<DeathStatistics> dslist = null;
    	dslist = DeathStatisticsService.selectAll();
        model.addAttribute("deathlist",dslist);
        return "showinfor/DeathStatistics";
    }
    
    @RequestMapping(value = "/DeathStatistics", method = RequestMethod.POST)
    @ResponseBody
    public DeathStatistics dsquery(@RequestParam("id") String id) {
    	return DeathStatisticsService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/DeathStatistics", method = RequestMethod.DELETE)
    public String dsdelete(@RequestParam("id") String key){
        DeathStatisticsService.deleteByKey(key);
        return "showinfor/DeathStatistics";
    }
    
    @RequestMapping(value = "/DeathStatistics", method = RequestMethod.PUT)
    @ResponseBody
    public String dsquery(@RequestBody JSONObject json){
    	DeathStatistics ds = JSONObject.toJavaObject(json, DeathStatistics.class);
    	DeathStatisticsService.updateByKey(ds);
        return "success";
    }
    
    // Shoushang表
    @RequestMapping(value = "/Shoushang", method = RequestMethod.GET)
    public String ShoushangShow(Model model){
    	List<Shoushang> dslist = null;
    	dslist = ShoushangService.selectAll();
        model.addAttribute("deathlist",dslist);
        return "showinfor/Shoushang";
    }
    
    @RequestMapping(value = "/Shoushang", method = RequestMethod.POST)
    @ResponseBody
    public Shoushang Shoushangquery(@RequestParam("id") String id) {
    	
    	return ShoushangService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Shoushang", method = RequestMethod.DELETE)
    public String Shoushangdelete(@RequestParam("id") String key){
    	ShoushangService.deleteByKey(key);
        return "showinfor/Shoushang";
    }
    
    @RequestMapping(value = "/Shoushang", method = RequestMethod.PUT)
    @ResponseBody
    public String Shoushangquery(@RequestBody JSONObject json){
    	Shoushang ds = JSONObject.toJavaObject(json, Shoushang.class);
    	ShoushangService.updateByKey(ds);
        return "success";
    }
    
    // Shizong表
    @RequestMapping(value = "/Shizong", method = RequestMethod.GET)
    public String ShizongShow(Model model){
    	List<Shizong> dslist = null;
    	dslist = ShizongService.selectAll();
        model.addAttribute("deathlist",dslist);
        return "showinfor/Shizong";
    }
    
    @RequestMapping(value = "/Shizong", method = RequestMethod.POST)
    @ResponseBody
    public Shizong Shizongquery(@RequestParam("id") String id) {
    	
    	return ShizongService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Shizong", method = RequestMethod.DELETE)
    public String Shizongdelete(@RequestParam("id") String key){
    	ShizongService.deleteByKey(key);
        return "showinfor/Shizong";
    }
    
    @RequestMapping(value = "/Shizong", method = RequestMethod.PUT)
    @ResponseBody
    public String Shizongquery(@RequestBody JSONObject json){
    	Shizong ds = JSONObject.toJavaObject(json, Shizong.class);
    	ShizongService.updateByKey(ds);
        return "success";
    }
 // 人员伤亡及失踪 ——————————————————————————————————————————————————————————————————————    
    
    
 // 房屋破坏 ——————————————————————————————————————————————————————————————————————
    // civil_structure表    
    @RequestMapping(value = "/CivilStructure", method = RequestMethod.GET)
    public String csShow(Model model){
        List<CivilStructure> cslist = null;
    	cslist = CivilStructureService.selectAll();
        model.addAttribute("cslist",cslist);
        return "showinfor/CivilStructure";
    }
    
    @RequestMapping(value = "/CivilStructure", method = RequestMethod.POST)
    @ResponseBody
    public CivilStructure csquery(@RequestParam("id") String id) {
    	return CivilStructureService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/CivilStructure", method = RequestMethod.DELETE)
    public String csdelete(@RequestParam("id") String key){
        CivilStructureService.deleteByKey(key);
        return "showinfor/CivilStructure";
    }
    
    @RequestMapping(value = "/CivilStructure", method = RequestMethod.PUT)
    @ResponseBody
    public String csupdate(@RequestBody JSONObject json){
    	CivilStructure cs = JSONObject.toJavaObject(json, CivilStructure.class);
    	CivilStructureService.updateByKey(cs);
        return "success";
    }
    
    // Zhuanmu表    
    @RequestMapping(value = "/Zhuanmu", method = RequestMethod.GET)
    public String ZhuanmuShow(Model model){
        List<Zhuanmu> cslist = null;
    	cslist = ZhuanmuService.selectAll();
        model.addAttribute("cslist",cslist);
        return "showinfor/Zhuanmu";
    }
    
    @RequestMapping(value = "/Zhuanmu", method = RequestMethod.POST)
    @ResponseBody
    public Zhuanmu Zhuanmuquery(@RequestParam("id") String id) {
    	return ZhuanmuService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Zhuanmu", method = RequestMethod.DELETE)
    public String Zhuanmudelete(@RequestParam("id") String key){
    	ZhuanmuService.deleteByKey(key);
        return "showinfor/Zhuanmu";
    }
    
    @RequestMapping(value = "/Zhuanmu", method = RequestMethod.PUT)
    @ResponseBody
    public String Zhuanmuupdate(@RequestBody JSONObject json){
    	Zhuanmu cs = JSONObject.toJavaObject(json, Zhuanmu.class);
    	ZhuanmuService.updateByKey(cs);
        return "success";
    }
    
    // Zhuanhun表    
    @RequestMapping(value = "/Zhuanhun", method = RequestMethod.GET)
    public String ZhuanhunShow(Model model){
        List<Zhuanhun> cslist = null;
    	cslist = ZhuanhunService.selectAll();
        model.addAttribute("cslist",cslist);
        return "showinfor/Zhuanhun";
    }
    
    @RequestMapping(value = "/Zhuanhun", method = RequestMethod.POST)
    @ResponseBody
    public Zhuanhun Zhuanhunquery(@RequestParam("id") String id) {
    	return ZhuanhunService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Zhuanhun", method = RequestMethod.DELETE)
    public String Zhuanhundelete(@RequestParam("id") String key){
    	ZhuanhunService.deleteByKey(key);
        return "showinfor/Zhuanhun";
    }
    
    @RequestMapping(value = "/Zhuanhun", method = RequestMethod.PUT)
    @ResponseBody
    public String Zhuanhunupdate(@RequestBody JSONObject json){
    	Zhuanhun cs = JSONObject.toJavaObject(json, Zhuanhun.class);
    	ZhuanhunService.updateByKey(cs);
        return "success";
    }
    
    // Kuangjia表    
    @RequestMapping(value = "/Kuangjia", method = RequestMethod.GET)
    public String KuangjiaShow(Model model){
        List<Kuangjia> cslist = null;
    	cslist = KuangjiaService.selectAll();
        model.addAttribute("cslist",cslist);
        return "showinfor/Kuangjia";
    }
    
    @RequestMapping(value = "/Kuangjia", method = RequestMethod.POST)
    @ResponseBody
    public Kuangjia Kuangjiaquery(@RequestParam("id") String id) {
    	return KuangjiaService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Kuangjia", method = RequestMethod.DELETE)
    public String Kuangjiadelete(@RequestParam("id") String key){
    	KuangjiaService.deleteByKey(key);
        return "showinfor/Kuangjia";
    }
    
    @RequestMapping(value = "/Kuangjia", method = RequestMethod.PUT)
    @ResponseBody
    public String Kuangjiaupdate(@RequestBody JSONObject json){
    	Kuangjia cs = JSONObject.toJavaObject(json, Kuangjia.class);
    	KuangjiaService.updateByKey(cs);
        return "success";
    }
    
    // FangwuQita表    
    @RequestMapping(value = "/FangwuQita", method = RequestMethod.GET)
    public String FangwuQitaShow(Model model){
        List<FangwuQita> cslist = null;
    	cslist = FangwuQitaService.selectAll();
        model.addAttribute("cslist",cslist);
        return "showinfor/FangwuQita";
    }
    
    @RequestMapping(value = "/FangwuQita", method = RequestMethod.POST)
    @ResponseBody
    public FangwuQita FangwuQitaquery(@RequestParam("id") String id) {
    	return FangwuQitaService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/FangwuQita", method = RequestMethod.DELETE)
    public String FangwuQitadelete(@RequestParam("id") String key){
    	FangwuQitaService.deleteByKey(key);
        return "showinfor/FangwuQita";
    }
    
    @RequestMapping(value = "/FangwuQita", method = RequestMethod.PUT)
    @ResponseBody
    public String FangwuQitaupdate(@RequestBody JSONObject json){
    	FangwuQita cs = JSONObject.toJavaObject(json, FangwuQita.class);
    	FangwuQitaService.updateByKey(cs);
        return "success";
    }
    
 // 房屋破坏 ——————————————————————————————————————————————————————————————————————
    
    
 // 生命线工程灾情 ——————————————————————————————————————————————————————————————————————
    // Jiaotong 表
    @RequestMapping(value = "/Jiaotong", method = RequestMethod.GET)
    public String JiaotongShow(Model model){
    	List<Jiaotong> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = JiaotongService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/Jiaotong";
    }
	
    @RequestMapping(value = "/Jiaotong", method = RequestMethod.POST)
    @ResponseBody
    public Jiaotong Jiaotongquery(@RequestParam("id") String id) {
    	return JiaotongService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/Jiaotong", method = RequestMethod.DELETE)
    public String Jiaotongdelete(@RequestParam("id") String key){
    	JiaotongService.deleteByKey(key);
        return "showinfor/Jiaotong";
    }
    
    @RequestMapping(value = "/Jiaotong", method = RequestMethod.PUT)
    @ResponseBody
    public String Jiaotongquery(@RequestBody JSONObject json){
    	Jiaotong disaster = (Jiaotong) JSONObject.toJavaObject(json, Jiaotong.class);
    	JiaotongService.updateByKey(disaster);
        return "success";
    }
    
    // Gongshui 表
    @RequestMapping(value = "/Gongshui", method = RequestMethod.GET)
    public String GongshuiShow(Model model){
    	List<Gongshui> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = GongshuiService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/Gongshui";
    }
	
    @RequestMapping(value = "/Gongshui", method = RequestMethod.POST)
    @ResponseBody
    public Gongshui Gongshuiquery(@RequestParam("id") String id) {
    	return GongshuiService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/Gongshui", method = RequestMethod.DELETE)
    public String Gongshuidelete(@RequestParam("id") String key){
    	GongshuiService.deleteByKey(key);
        return "showinfor/Gongshui";
    }
    
    @RequestMapping(value = "/Gongshui", method = RequestMethod.PUT)
    @ResponseBody
    public String Gongshuiquery(@RequestBody JSONObject json){
    	Gongshui disaster = (Gongshui) JSONObject.toJavaObject(json, Gongshui.class);
    	GongshuiService.updateByKey(disaster);
        return "success";
    }
    
    // Shuyou 表
    @RequestMapping(value = "/Shuyou", method = RequestMethod.GET)
    public String ShuyouShow(Model model){
    	List<Shuyou> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = ShuyouService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/Shuyou";
    }
	
    @RequestMapping(value = "/Shuyou", method = RequestMethod.POST)
    @ResponseBody
    public Shuyou Shuyouquery(@RequestParam("id") String id) {
    	return ShuyouService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/Shuyou", method = RequestMethod.DELETE)
    public String Shuyoudelete(@RequestParam("id") String key){
    	ShuyouService.deleteByKey(key);
        return "showinfor/Shuyou";
    }
    
    @RequestMapping(value = "/Shuyou", method = RequestMethod.PUT)
    @ResponseBody
    public String Shuyouquery(@RequestBody JSONObject json){
    	Shuyou disaster = (Shuyou) JSONObject.toJavaObject(json, Shuyou.class);
    	ShuyouService.updateByKey(disaster);
        return "success";
    }
    
    // Ranqi 表
    @RequestMapping(value = "/Ranqi", method = RequestMethod.GET)
    public String RanqiShow(Model model){
    	List<Ranqi> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = RanqiService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/Ranqi";
    }
	
    @RequestMapping(value = "/Ranqi", method = RequestMethod.POST)
    @ResponseBody
    public Ranqi Ranqiquery(@RequestParam("id") String id) {
    	return RanqiService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/Ranqi", method = RequestMethod.DELETE)
    public String Ranqidelete(@RequestParam("id") String key){
    	RanqiService.deleteByKey(key);
        return "showinfor/Ranqi";
    }
    
    @RequestMapping(value = "/Ranqi", method = RequestMethod.PUT)
    @ResponseBody
    public String Ranqiquery(@RequestBody JSONObject json){
    	Ranqi disaster = (Ranqi) JSONObject.toJavaObject(json, Ranqi.class);
    	RanqiService.updateByKey(disaster);
        return "success";
    }
    
    // Dianli 表
    @RequestMapping(value = "/Dianli", method = RequestMethod.GET)
    public String DianliShow(Model model){
    	List<Dianli> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = DianliService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/Dianli";
    }
	
    @RequestMapping(value = "/Dianli", method = RequestMethod.POST)
    @ResponseBody
    public Dianli Dianliquery(@RequestParam("id") String id) {
    	return DianliService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/Dianli", method = RequestMethod.DELETE)
    public String Dianlidelete(@RequestParam("id") String key){
    	DianliService.deleteByKey(key);
        return "showinfor/Dianli";
    }
    
    @RequestMapping(value = "/Dianli", method = RequestMethod.PUT)
    @ResponseBody
    public String Dianliquery(@RequestBody JSONObject json){
    	Dianli disaster = (Dianli) JSONObject.toJavaObject(json, Dianli.class);
    	DianliService.updateByKey(disaster);
        return "success";
    }
    
    /*
    // comm_disaster 表
    @RequestMapping(value = "/CommDisaster/showall")
    public String dataShow(Model model){
    	List<Disaster> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = DisasterService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/CommDisaster";
    }
    */
    
    @RequestMapping(value = "/CommDisaster", method = RequestMethod.GET)
    public String datahow(Model model){
    	List<Disaster> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = DisasterService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/CommDisaster";
    }
	
    @RequestMapping(value = "/CommDisaster", method = RequestMethod.POST)
    @ResponseBody
    public Disaster commdisasterquery(@RequestParam("id") String id) {
    	return DisasterService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/CommDisaster", method = RequestMethod.DELETE)
    public String cddelete(@RequestParam("id") String key){
        DisasterService.deleteByKey(key);
        return "showinfor/CommDisaster";
    }
    
    @RequestMapping(value = "/CommDisaster", method = RequestMethod.PUT)
    @ResponseBody
    public String cdquery(@RequestBody JSONObject json){
    	Disaster disaster = (Disaster) JSONObject.toJavaObject(json, Disaster.class);
    	DisasterService.updateByKey(disaster);
        return "success";
    }
    
    // Shuili 表
    @RequestMapping(value = "/Shuili", method = RequestMethod.GET)
    public String ShuiliShow(Model model){
    	List<Shuili> disasterlist = null;
    	//disasterService.beifen();
        disasterlist = ShuiliService.selectAll();
        model.addAttribute("disaster",disasterlist);
        return "showinfor/Shuili";
    }
	
    @RequestMapping(value = "/Shuili", method = RequestMethod.POST)
    @ResponseBody
    public Shuili Shuiliquery(@RequestParam("id") String id) {
    	return ShuiliService.selectByKey(id).get(0);
    }    
    
    @RequestMapping(value = "/Shuili", method = RequestMethod.DELETE)
    public String Shuilidelete(@RequestParam("id") String key){
    	ShuiliService.deleteByKey(key);
        return "showinfor/Shuili";
    }
    
    @RequestMapping(value = "/Shuili", method = RequestMethod.PUT)
    @ResponseBody
    public String Shuiliquery(@RequestBody JSONObject json){
    	Shuili disaster = (Shuili) JSONObject.toJavaObject(json, Shuili.class);
    	ShuiliService.updateByKey(disaster);
        return "success";
    }

    
 // 生命线工程灾情 ——————————————————————————————————————————————————————————————————————
    
    
 // 次生灾害 ——————————————————————————————————————————————————————————————————————
    // CollapseRecord
    
    @RequestMapping(value = "/CollapseRecord", method = RequestMethod.GET)
    public String crShow(Model model){
    	List<CollapseRecord> crlist = null;
    	crlist = CollapseRecordService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/CollapseRecord";
    }
    
    @RequestMapping(value = "/CollapseRecord", method = RequestMethod.POST)
    @ResponseBody
    public CollapseRecord crquery(@RequestParam("id") String id) {
    	return CollapseRecordService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/CollapseRecord", method = RequestMethod.DELETE)
    public String crdelete(@RequestParam("id") String key){
        CollapseRecordService.deleteByKey(key);
        return "showinfor/CivilStructure";
    }
    
    @RequestMapping(value = "/CollapseRecord", method = RequestMethod.PUT)
    @ResponseBody
    public String crupdate(@RequestBody JSONObject json){
    	CollapseRecord cr = json.toJavaObject(CollapseRecord.class);
    	CollapseRecordService.updateByKey(cr);
        return "success";
    }
    
    // Huapo
    
    @RequestMapping(value = "/Huapo", method = RequestMethod.GET)
    public String HuapoShow(Model model){
    	List<Huapo> crlist = null;
    	crlist = HuapoService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/Huapo";
    }
    
    @RequestMapping(value = "/Huapo", method = RequestMethod.POST)
    @ResponseBody
    public Huapo Huapoquery(@RequestParam("id") String id) {
    	return HuapoService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Huapo", method = RequestMethod.DELETE)
    public String Huapodelete(@RequestParam("id") String key){
    	HuapoService.deleteByKey(key);
        return "showinfor/Huapo";
    }
    
    @RequestMapping(value = "/Huapo", method = RequestMethod.PUT)
    @ResponseBody
    public String Huapoupdate(@RequestBody JSONObject json){
    	Huapo cr = json.toJavaObject(Huapo.class);
    	HuapoService.updateByKey(cr);
        return "success";
    }
    
    // Nishiliu
    
    @RequestMapping(value = "/Nishiliu", method = RequestMethod.GET)
    public String NishiliuShow(Model model){
    	List<Nishiliu> crlist = null;
    	crlist = NishiliuService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/Nishiliu";
    }
    
    @RequestMapping(value = "/Nishiliu", method = RequestMethod.POST)
    @ResponseBody
    public Nishiliu Nishiliuquery(@RequestParam("id") String id) {
    	return NishiliuService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Nishiliu", method = RequestMethod.DELETE)
    public String Nishiliudelete(@RequestParam("id") String key){
    	NishiliuService.deleteByKey(key);
        return "showinfor/Nishiliu";
    }
    
    @RequestMapping(value = "/Nishiliu", method = RequestMethod.PUT)
    @ResponseBody
    public String Nishiliuupdate(@RequestBody JSONObject json){
    	Nishiliu cr = json.toJavaObject(Nishiliu.class);
    	NishiliuService.updateByKey(cr);
        return "success";
    }
    
    // Yanrongtanta
    
    @RequestMapping(value = "/Yanrongtanta", method = RequestMethod.GET)
    public String YanrongtantaShow(Model model){
    	List<Yanrongtanta> crlist = null;
    	crlist = YanrongtantaService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/Yanrongtanta";
    }
    
    @RequestMapping(value = "/Yanrongtanta", method = RequestMethod.POST)
    @ResponseBody
    public Yanrongtanta Yanrongtantaquery(@RequestParam("id") String id) {
    	return YanrongtantaService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Yanrongtanta", method = RequestMethod.DELETE)
    public String Yanrongtantadelete(@RequestParam("id") String key){
    	YanrongtantaService.deleteByKey(key);
        return "showinfor/Yanrongtanta";
    }
    
    @RequestMapping(value = "/Yanrongtanta", method = RequestMethod.PUT)
    @ResponseBody
    public String Yanrongtantaupdate(@RequestBody JSONObject json){
    	Yanrongtanta cr = json.toJavaObject(Yanrongtanta.class);
    	YanrongtantaService.updateByKey(cr);
        return "success";
    }
    
    // Diliefeng
    
    @RequestMapping(value = "/Diliefeng", method = RequestMethod.GET)
    public String DiliefengShow(Model model){
    	List<Diliefeng> crlist = null;
    	crlist = DiliefengService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/Diliefeng";
    }
    
    @RequestMapping(value = "/Diliefeng", method = RequestMethod.POST)
    @ResponseBody
    public Diliefeng Diliefengquery(@RequestParam("id") String id) {
    	return DiliefengService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Diliefeng", method = RequestMethod.DELETE)
    public String Diliefengdelete(@RequestParam("id") String key){
    	DiliefengService.deleteByKey(key);
        return "showinfor/Diliefeng";
    }
    
    @RequestMapping(value = "/Diliefeng", method = RequestMethod.PUT)
    @ResponseBody
    public String Diliefengupdate(@RequestBody JSONObject json){
    	Diliefeng cr = json.toJavaObject(Diliefeng.class);
    	DiliefengService.updateByKey(cr);
        return "success";
    }
    
    // Dimianchenjiang
    
    @RequestMapping(value = "/Dimianchenjiang", method = RequestMethod.GET)
    public String DimianchenjiangShow(Model model){
    	List<Dimianchenjiang> crlist = null;
    	crlist = DimianchenjiangService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/Dimianchenjiang";
    }
    
    @RequestMapping(value = "/Dimianchenjiang", method = RequestMethod.POST)
    @ResponseBody
    public Dimianchenjiang Dimianchenjiangquery(@RequestParam("id") String id) {
    	return DimianchenjiangService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/Dimianchenjiang", method = RequestMethod.DELETE)
    public String Dimianchenjiangdelete(@RequestParam("id") String key){
    	DimianchenjiangService.deleteByKey(key);
        return "showinfor/Dimianchenjiang";
    }
    
    @RequestMapping(value = "/Dimianchenjiang", method = RequestMethod.PUT)
    @ResponseBody
    public String Dimianchenjiangupdate(@RequestBody JSONObject json){
    	Dimianchenjiang cr = json.toJavaObject(Dimianchenjiang.class);
    	DimianchenjiangService.updateByKey(cr);
        return "success";
    }
    
    // CishengzaihaiQita
    
    @RequestMapping(value = "/CishengzaihaiQita", method = RequestMethod.GET)
    public String CishengzaihaiQitaShow(Model model){
    	List<CishengzaihaiQita> crlist = null;
    	crlist = CishengzaihaiQitaService.selectAll();
    	model.addAttribute("crlist",crlist);
    	return "showinfor/CishengzaihaiQita";
    }
    
    @RequestMapping(value = "/CishengzaihaiQita", method = RequestMethod.POST)
    @ResponseBody
    public CishengzaihaiQita CishengzaihaiQitaquery(@RequestParam("id") String id) {
    	return CishengzaihaiQitaService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/CishengzaihaiQita", method = RequestMethod.DELETE)
    public String CishengzaihaiQitadelete(@RequestParam("id") String key){
    	CishengzaihaiQitaService.deleteByKey(key);
        return "showinfor/CishengzaihaiQita";
    }
    
    @RequestMapping(value = "/CishengzaihaiQita", method = RequestMethod.PUT)
    @ResponseBody
    public String CishengzaihaiQitaupdate(@RequestBody JSONObject json){
    	CishengzaihaiQita cr = json.toJavaObject(CishengzaihaiQita.class);
    	CishengzaihaiQitaService.updateByKey(cr);
        return "success";
    }
 // 次生灾害 ——————————————————————————————————————————————————————————————————————
    
    
 // 震情 ——————————————————————————————————————————————————————————————————————
    // ZhenqingJiben
    
    @RequestMapping(value = "/ZhenqingJiben", method = RequestMethod.GET)
    public String ZhenqingJibenShow(Model model){
        List<ZhenqingJiben> dplist = null;
    	dplist = ZhenqingJibenService.selectAll();
    	model.addAttribute("dplist",dplist);
    	return "showinfor/ZhenqingJiben";
    }
    
    @RequestMapping(value = "/ZhenqingJiben", method = RequestMethod.POST)
    @ResponseBody
    public ZhenqingJiben ZhenqingJibenquery(@RequestParam("id") String id) {
    	return ZhenqingJibenService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/ZhenqingJiben", method = RequestMethod.DELETE)
    public String ZhenqingJibendelete(@RequestParam("id") String key){
    	ZhenqingJibenService.deleteByKey(key);
        return "showinfor/ZhenqingJiben";
    }
    
    @RequestMapping(value = "/ZhenqingJiben", method = RequestMethod.PUT)
    @ResponseBody
    public String ZhenqingJibenupdate(@RequestBody JSONObject json){
    	ZhenqingJiben dp = json.toJavaObject(ZhenqingJiben.class);
    	ZhenqingJibenService.updateByKey(dp);
        return "success";
    }
    
    // DisasterPrediction
    
    @RequestMapping(value = "/DisasterPrediction", method = RequestMethod.GET)
    public String dpShow(Model model){
        List<DisasterPrediction> dplist = null;
    	dplist = DisasterPredictionService.selectAll();
    	model.addAttribute("dplist",dplist);
    	return "showinfor/DisasterPrediction";
    }
    
    @RequestMapping(value = "/DisasterPrediction", method = RequestMethod.POST)
    @ResponseBody
    public DisasterPrediction dpquery(@RequestParam("id") String id) {
    	return DisasterPredictionService.selectByKey(id).get(0);
    }
    
    @RequestMapping(value = "/DisasterPrediction", method = RequestMethod.DELETE)
    public String dpdelete(@RequestParam("id") String key){
        DisasterPredictionService.deleteByKey(key);
        return "showinfor/DisasterPrediction";
    }
    
    @RequestMapping(value = "/DisasterPrediction", method = RequestMethod.PUT)
    @ResponseBody
    public String dpupdate(@RequestBody JSONObject json){
    	DisasterPrediction dp = json.toJavaObject(DisasterPrediction.class);
    	DisasterPredictionService.updateByKey(dp);
        return "success";
    }
 // 震情 ——————————————————————————————————————————————————————————————————————
}
