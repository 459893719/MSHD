package com.miaosha.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.service.DisasterService;

@Controller
public class ExportController {
    @Autowired
    DisasterService disasterService;
    List<Disaster> disaster = null;
	
	@RequestMapping(value = "/Client_Export")
	public String Client_Export() {
		return "Client_Export";
	}
    @RequestMapping(value ="/export",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session, @RequestParam("disasterOptions")String disasterType) throws IOException {
    	disaster = disasterService.selectByType(disasterType);//还需要改成 根据 disasterType返回不同的数据表，而不是selectByType
    	byte [] body = null;
        String str=JSON.toJSONString(disaster);
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
