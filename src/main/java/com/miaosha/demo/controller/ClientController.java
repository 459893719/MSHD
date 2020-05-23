package com.miaosha.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.*;
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
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    DisasterService disasterService;

    //客户端主页
    @RequestMapping("/")
    public String home(){
        return "Client_index";
    }

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(){
        return "Client_Login";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String isLogin(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model){
        if(password.equals("1") && username.equals("test")){
            return "Client_index";
        }
        else
            return "error";
    }
    /*
    主页导航按钮
     */

    //注销
    @RequestMapping("/logout")
    public String logout(){
        return "Client_Login";
    }

    @RequestMapping("/dataindex")
    public String dataindex(){
        return "Client_InforIndex";
    }
    
    //导出数据
    @RequestMapping("/dataexport")
    public String exportData(){
        return "Client_Export";
    }


    //下载文件
    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> testResponseEntity(@RequestParam("disasterOptions") String disasterOptions, HttpSession session) throws IOException {
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
        InputStream in = new ByteArrayInputStream(str.getBytes());
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=data.txt");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

}
