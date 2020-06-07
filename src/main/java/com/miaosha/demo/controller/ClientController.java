package com.miaosha.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.*;
import com.miaosha.demo.json.OperateJsonFile;
import com.miaosha.demo.service.DisasterRequestService;
import com.miaosha.demo.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    DisasterService disasterService;
    
    OperateJsonFile op;

    /*
    主页导航按钮
     */

    //导出数据
    @RequestMapping("/dataexport")
    public String exportData(){
        return "Client_Export";
    }
    
    @RequestMapping("/download")
    public String someoneWantDownload(@RequestParam("disasterOptions") String disasterOptions,@RequestParam("url") String url) {
    	DisasterRequest dr = new DisasterRequest();
    	Date date = new Date();
    	dr.setDisaster_type(disasterOptions);
    	dr.setO_url(url);
    	dr.setStatus("0");
    	dr.setRequest_unit("北京邮电大学");
    	dr.setId("1111111111111111111");
    	dr.setDate(date.toLocaleString());
    	System.out.println(dr.toString());
    	DisasterRequestService.insertOne(dr);
    	return "Client_Export";
    }

    /*
    //下载文件
    @RequestMapping("/download")
    @ResponseBody
    //ResponseEntity<byte[]>
    public  void testResponseEntity(@RequestParam("disasterOptions") String disasterOptions,
                                                     @RequestParam("url") String url,
                                                     HttpSession session) throws IOException {
        OperateJsonFile op = new OperateJsonFile();
        byte [] body = null;
        String str = "";
        switch (disasterOptions){
            case ("1"):
            case ("11"):
            case ("12"):
            case ("13"):
                List<DeathStatistics> deathStatistics = null;
                str= JSON.toJSONString(deathStatistics);
                break;
            case ("2"):
            case ("21"):
            case ("22"):
            case ("23"):
            case ("24"):
            case ("25"):
                List<CivilStructure> civilStructures = null;
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
                    op.write_disaster(disasters, url + "/comm_disaster.json");
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
                List<CollapseRecord> collapseRecords = null;
                str= JSON.toJSONString(collapseRecords);
                break;
            case ("5"):
            case ("51"):
            case ("52"):
                List<DisasterPrediction> disasterPredictions = null;
                str= JSON.toJSONString(disasterPredictions);
                break;
            default:
                break;
        }
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
*/
}
