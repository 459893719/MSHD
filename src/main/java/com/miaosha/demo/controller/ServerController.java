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
    
    
    // 展示请求页
    @RequestMapping(value = "/adminShowQuest")
    public String showQuest(Model model){
    	List<DisasterRequest> drlist;
    	drlist = DisasterRequestService.selectNotSend();
        model.addAttribute("quests",drlist);
        return "Server_showQuest";
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
            case ("1"):
            case ("11"):
            case ("12"):
            case ("13"):
                List<DeathStatistics> deathStatistics = DeathStatisticsService.selectAll();
                try {
                    op.export_deathStatistics(deathStatistics, url + "/death_statistics.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str= JSON.toJSONString(deathStatistics);
                break;
            case ("2"):
            case ("21"):
            case ("22"):
            case ("23"):
            case ("24"):
            case ("25"):
                List<CivilStructure> civilStructures = CivilStructureService.selectAll();
                try {
                    op.export_civilStructure(civilStructures, url + "/civil_structure.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str= JSON.toJSONString(civilStructures);
                break;
            case ("3"):
            case ("31"):
            case ("32"):
            case ("33"):
            case ("34"):
            case ("35"):
            case ("36"):
            case ("37"):
                List<Disaster> disasters  = disasterService.selectAll();
                try {
                    op.export_disaster(disasters, url + "/comm_disaster.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str= JSON.toJSONString(disasters);
                break;
            case ("4"):
            case ("41"):
            case ("42"):
            case ("43"):
            case ("44"):
            case ("45"):
            case ("46"):
            case ("47"):
                List<CollapseRecord> collapseRecords = CollapseRecordService.selectAll();
                try {
                    op.export_collapseRecord(collapseRecords, url + "/collapse_record.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str= JSON.toJSONString(collapseRecords);
                break;
            case ("5"):
            case ("51"):
            case ("52"):
                List<DisasterPrediction> disasterPredictions = DisasterPredictionService.selectAll();
                try {
                    op.export_disasterPrediction(disasterPredictions, url + "/disaster_prediction.json");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str= JSON.toJSONString(disasterPredictions);
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
