package com.miaosha.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.*;
import com.miaosha.demo.json.OperateJsonFile;
import com.miaosha.demo.service.*;
import com.miaosha.demo.service.DisasterRequestService;
import com.miaosha.demo.service.DisasterService;
import com.miaosha.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;

@Controller
public class ServerController {

    @Autowired
    private HttpServletResponse myHttpResponse;
    
    @Autowired
    UserService usrService;
    
    //有五个Service
    @Autowired
    DisasterService disasterService;
        
    OperateJsonFile op;
    
    
    
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String isLogin(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model){
        if(UserService.checkLogin(username, password)){
            return "Server_index";
        }
        else
            return "Server_Login";
    }
    
    
    //管理员主页
    @RequestMapping("/")
    public String ClientHome(){
        return "Client_Export";
    }

    //管理员主页
    @RequestMapping("/adminindex")
    public String adminHome(){
        return "Server_index";
    }

    
    /*
    主页导航按钮
     */

    //注销
    @RequestMapping("/adminLogout")
    public String logout(){
        return "Server_Login";
    }
    
    //查看灾情信息首页
    @RequestMapping("/admindataindex")
    public String dataindex(){
        return "Server_InforIndex";
    }
    
    //查看灾情信息
    @RequestMapping("/adminViewData")
    public String viewData(Model model){
        return "Server_showInfor";
    }
    List<User>  usrList=null;
    
    //用户管理
    @RequestMapping("/adminUserManage")
    public String userManage(Model model){
    	usrList=UserService.selectAll();
    	model.addAttribute("User", usrList);
        return "Server_UsrManage";
    }
    
    private  static final HashMap<String,String> mapType = new HashMap<>();
    static  
    {  
    	mapType.put("111", "人员伤亡及失踪:死亡");
    	mapType.put("112", "人员伤亡及失踪:受伤");
    	mapType.put("113", "人员伤亡及失踪:失踪");
    	mapType.put("221", "房屋破坏:土木");
    	mapType.put("222", "房屋破坏:砖木");
    	mapType.put("223", "房屋破坏:砖混");
    	mapType.put("224", "房屋破坏:框架");
    	mapType.put("225", "房屋破坏:其他");
    	mapType.put("331", "生命线工程灾情:交通");
    	mapType.put("332", "生命线工程灾情:供水");
    	mapType.put("333", "生命线工程灾情:输油");
    	mapType.put("334", "生命线工程灾情:燃气");
    	mapType.put("335", "生命线工程灾情:电力");
    	mapType.put("336", "生命线工程灾情:通信");
    	mapType.put("337", "生命线工程灾情:水利");
    	mapType.put("441", "次生灾害:崩塌");
    	mapType.put("442", "次生灾害:滑坡");
    	mapType.put("443", "次生灾害:泥石流");
    	mapType.put("444", "次生灾害:岩溶塌陷");
    	mapType.put("445", "次生灾害:地裂缝");
    	mapType.put("446", "次生灾害:地面沉降");
    	mapType.put("447", "次生灾害:其他");
    	mapType.put("551", "震情:基本震情");
    	mapType.put("552", "震情:灾情预测 ");
    	
    }
    
    // 展示请求页
    @RequestMapping(value = "/adminShowQuest")
    public String showQuest(Model model){
    	List<DisasterRequest> drlist;
    	drlist = DisasterRequestService.selectNotSend();
    	for(DisasterRequest d:drlist) {
    		d.setDisaster_type(mapType.get(d.getDisaster_type()));
    	}
        model.addAttribute("quests",drlist);
        return "Server_showQuest";
    }
    
    // 展示已完成请求页
    @RequestMapping(value = "/adminShowFinishedQuest")
    public String showFinishedQuest(Model model){
    	List<DisasterRequest> drlist;
    	drlist = DisasterRequestService.selectSended();
    	for(DisasterRequest d:drlist) {
    		d.setDisaster_type(mapType.get(d.getDisaster_type()));
    	}
        model.addAttribute("sendedquests",drlist);
        return "Server_showFinishedQuest";
    }
    
  //下载文件
    @RequestMapping(value = "/showQuest", method = RequestMethod.PUT)
    @ResponseBody
    //ResponseEntity<byte[]>
    public String sendsolve(@RequestParam("key") String key) throws IOException {
    	List<DisasterRequest> dr = DisasterRequestService.selectByKey(key);
    	String disasterOptions = dr.get(0).getDisaster_type();
    	String url = dr.get(0).getO_url();
    	
        OperateJsonFile op = new OperateJsonFile();
        byte [] body = null;
        String str = "";
        switch (disasterOptions){
            case ("111"):
                List<DeathStatistics> deathStatistics = DeathStatisticsService.selectAll();
                try {
                    op.export_deathStatistics(deathStatistics, url + "/death_statistics.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case ("112"):
                List<Shoushang> shoushangList = ShoushangService.selectAll();
                try {
                    op.export_Shoushang(shoushangList, url + "/Shoushang.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("113"):
                List<Shizong> ShizongList = ShizongService.selectAll();
                try {
                    op.export_Shizong(ShizongList, url + "/Shizong.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case ("221"):
                List<CivilStructure> civilStructures = CivilStructureService.selectAll();
                try {
                    op.export_civilStructure(civilStructures, url + "/civil_structure.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("222"):
                List<Zhuanmu> Zhuanmus = ZhuanmuService.selectAll();
                try {
                    op.export_Zhuanmu(Zhuanmus, url + "/Zhuanmu.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("223"):
                List<Zhuanhun> Zhuanhuns = ZhuanhunService.selectAll();
                try {
                    op.export_Zhuanhun(Zhuanhuns, url + "/Zhuanhun.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("224"):
                List<Kuangjia> Kuangjias = KuangjiaService.selectAll();
                try {
                    op.export_Kuangjia(Kuangjias, url + "/Kuangjia.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("225"):
                List<FangwuQita> FangwuQitas = FangwuQitaService.selectAll();
                try {
                    op.export_FangwuQita(FangwuQitas, url + "/FangwuQita.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case ("331"):
                List<Jiaotong> Jiaotongs = JiaotongService.selectAll();
                try {
                    op.export_Jiaotong(Jiaotongs, url + "/Jiaotong.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("332"):
                List<Gongshui> Gongshuis = GongshuiService.selectAll();
                try {
                    op.export_Gongshui(Gongshuis, url + "/Gongshui.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("333"):
                List<Shuyou> Shuyous = ShuyouService.selectAll();
                try {
                    op.export_Shuyou(Shuyous, url + "/Shuyou.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("334"):
                List<Ranqi> Ranqis = RanqiService.selectAll();
                try {
                    op.export_Ranqi(Ranqis, url + "/Ranqi.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("335"):
                List<Dianli> Dianlis = DianliService.selectAll();
                try {
                    op.export_Dianli(Dianlis, url + "/Dianli.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("336"):
                List<Disaster> disasters  = disasterService.selectAll();
                try {
                    op.export_disaster(disasters, url + "/comm_disaster.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("337"):
                List<Shuili> ShuiliList = ShuiliService.selectAll();
                try {
                    op.export_Shuili(ShuiliList, url + "/Shuili.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


            case ("441"):
                List<CollapseRecord> collapseRecords = CollapseRecordService.selectAll();
                try {
                    op.export_collapseRecord(collapseRecords, url + "/collapse_record.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("442"):
                List<Huapo> HuapoList = HuapoService.selectAll();
                try {
                    op.export_Huapo(HuapoList, url + "/Huapo.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("443"):
                List<Nishiliu> NishiliuList = NishiliuService.selectAll();
                try {
                    op.export_Nishiliu(NishiliuList, url + "/Nishiliu.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("444"):
                List<Yanrongtanta> YanrongtantaList = YanrongtantaService.selectAll();
                try {
                    op.export_Yanrongtanta(YanrongtantaList, url + "/Yanrongtanta.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("445"):
                List<Diliefeng> DiliefengList = DiliefengService.selectAll();
                try {
                    op.export_Diliefeng(DiliefengList, url + "/Diliefeng.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("446"):
                List<Dimianchenjiang> DimianchenjiangList = DimianchenjiangService.selectAll();
                try {
                    op.export_Dimianchenjiang(DimianchenjiangList, url + "/Dimianchenjiang.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("447"):
                List<CishengzaihaiQita> CishengzaihaiQitaList = CishengzaihaiQitaService.selectAll();
                try {
                    op.export_CishengzaihaiQita(CishengzaihaiQitaList, url + "/CishengzaihaiQita.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


            case ("551"):
                List<ZhenqingJiben> ZhenqingJibenList = ZhenqingJibenService.selectAll();
                try {
                    op.export_ZhenqingJiben(ZhenqingJibenList, url + "/ZhenqingJiben.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case ("552"):
                List<DisasterPrediction> disasterPredictions = DisasterPredictionService.selectAll();
                try {
                    op.export_disasterPrediction(disasterPredictions, url + "/disaster_prediction.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        DisasterRequestService.send(dr.get(0));
        return "success";
//        InputStream in = new ByteArrayInputStream(str.getBytes());
//        body = new byte[in.available()];
//        in.read(body);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "attachment;filename=data.txt");
//
//        HttpStatus statusCode = HttpStatus.OK;
//
//        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);

        //导出的后置处理，将记录写入
        //return response;
    }


    
    //导入数据
    @RequestMapping("/adminImportData")
    public String exportData(){
        return "Server_Import";
    }
    
    // 上传文件页
	@RequestMapping(value = "/readfile")
	public String readFile() {
		return "Server_Import";
	}

	/*
    //上传文件
    @RequestMapping(value = "/upload")
    //@ResponseBody
    public String upload(@RequestParam("source") String source,@RequestParam("file") MultipartFile file) {
        PrintWriter out;
        op = new OperateJsonFile();
        try {
            out = myHttpResponse.getWriter();
            try {
                myHttpResponse.setContentType("text/html; charset=UTF-8"); //转码
                if (file.isEmpty()) {
                    out.flush();
                    out.println("<script>");
                    out.println("alert('file is empty!');");
                    out.println("history.back();");
                    out.println("</script>");
                }
//			String filePath=file.getOriginalFilename();
                InputStream inputStream = file.getInputStream();
                StringBuilder sb = new StringBuilder();
                String line;

                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String str = sb.toString();//要解析的文件内容
                /**
                 * id解码确定插入的表并写入文件，为后续定时器读取准备
                 */
	/*
                JSONObject firstElement = JSONArray.parseArray(str).getJSONObject(0);
                String type = firstElement.get("id").toString().substring(12,13);
                switch (type){
                    case ("1"):
                        List<DeathStatistics> deathStatistics = JSONObject.parseArray(str, DeathStatistics.class);
                        for(DeathStatistics data : deathStatistics){
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        try {
                            op.write_deathStatistics(deathStatistics, "death_statistics.json");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case ("2"):
                        List<CivilStructure> civilStructures = JSONObject.parseArray(str, CivilStructure.class);
                        for(CivilStructure data : civilStructures){
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        try {
                            op.write_civilStructure(civilStructures
                                    , "civil_structure.json");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case ("3"):
                        List<Disaster> disasters  = JSONObject.parseArray(str, Disaster.class);
                        for (Disaster data: disasters) {
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        try {
                            op.write_disaster(disasters
                                    , "comm_disaster.json");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case ("4"):
                        List<CollapseRecord> collapseRecords = JSONObject.parseArray(str, CollapseRecord.class);
                        for (CollapseRecord data: collapseRecords) {
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        try {
                            op.write_collapseRecord(collapseRecords
                                    , "collapse_record.json");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case ("5"):
                        List<DisasterPrediction> disasterPredictions = JSONObject.parseArray(str, DisasterPrediction.class);
                        for (DisasterPrediction data: disasterPredictions) {
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        try {
                            op.write_disasterPrediction(disasterPredictions
                                    , "disaster_prediction.json");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case ("6"):
                        List<DisasterRequest> disasterRequests = JSONObject.parseArray(str, DisasterRequest.class);
                        try {
                            op.write_disasterRequest(disasterRequests
                                    , "disaster_request.json");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }


                out.flush();
                out.println("<script>");
                out.println("alert('Import success!');");
                out.println("history.back();");
                out.println("</script>");
                //return "数据：" + str + "\n" + "导入成功";
            } catch (IllegalStateException e) {
                e.printStackTrace();
                out.flush();
                out.println("<script>");
                out.println("alert('Import Failure!');");
                out.println("history.back();");
                out.println("</script>");
            } catch (IOException e) {
                e.printStackTrace();
                out.flush();
                out.println("<script>");
                out.println("alert('Import Failure!');");
                out.println("history.back();");
                out.println("</script>");
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return "error";
    }
	*/
    //上传文件
    @RequestMapping(value = "/upload")
    //@ResponseBody
    public String upload(@RequestParam("source") String source,@RequestParam("file") MultipartFile file) {
        PrintWriter out;
        try {
            out = myHttpResponse.getWriter();
            try {
                myHttpResponse.setContentType("text/html; charset=UTF-8"); //转码
                if (file.isEmpty()) {
                    out.flush();
                    out.println("<script>");
                    out.println("alert('file is empty!');");
                    out.println("history.back();");
                    out.println("</script>");
                }
//			String filePath=file.getOriginalFilename();
                InputStream inputStream = file.getInputStream();
                StringBuilder sb = new StringBuilder();
                String line;

                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                String str = sb.toString();//要解析的文件内容
                /**
                 * id解码确定插入的表并插入
                 */
                JSONObject firstElement = JSONArray.parseArray(str).getJSONObject(0);
                String type = firstElement.get("id").toString().substring(12,13);
                switch (type){
                    case ("1"):
                        List<DeathStatistics> deathStatistics = JSONObject.parseArray(str, DeathStatistics.class);
                        for(DeathStatistics data : deathStatistics){
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        break;
                    case ("2"):
                        List<CivilStructure> civilStructures = JSONObject.parseArray(str, CivilStructure.class);
                        for(CivilStructure data : civilStructures){
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        break;
                    case ("3"):
                        List<Disaster> disasters  = JSONObject.parseArray(str, Disaster.class);
                        for (Disaster data: disasters) {
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        disasterService.insertByJson(disasters);
                        break;
                    case ("4"):
                        List<CollapseRecord> collapseRecords = JSONObject.parseArray(str, CollapseRecord.class);
                        for (CollapseRecord data: collapseRecords) {
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        break;
                    case ("5"):
                        List<DisasterPrediction> disasterPredictions = JSONObject.parseArray(str, DisasterPrediction.class);
                        for (DisasterPrediction data: disasterPredictions) {
                            data.setReporting_unit(source + data.getReporting_unit());
                        }
                        break;
                    default:
                        break;
                }


                out.flush();
                out.println("<script>");
                out.println("alert('Import success!');");
                out.println("history.back();");
                out.println("</script>");
                //return "数据：" + str + "\n" + "导入成功";
            } catch (IllegalStateException e) {
                e.printStackTrace();
                out.flush();
                out.println("<script>");
                out.println("alert('Import Failure!');");
                out.println("history.back();");
                out.println("</script>");
            } catch (IOException e) {
                e.printStackTrace();
                out.flush();
                out.println("<script>");
                out.println("alert('Import Failure!');");
                out.println("history.back();");
                out.println("</script>");
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return "error";
    }
    
}
