package com.miaosha.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.*;
import com.miaosha.demo.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class ServerController {

    @Autowired
    private HttpServletResponse myHttpResponse;

    //有五个Service
    @Autowired
    DisasterService disasterService;

    //管理员主页
    @RequestMapping("/admin")
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

    //查看灾情信息
    @RequestMapping("/adminViewData")
    public String viewData(Model model){
        return "Client_showInfor";
    }

    //用户管理
    @RequestMapping("/adminUserManage")
    public String userManage(){
        return "Server_UsrManage";
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
