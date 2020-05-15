package com.miaosha.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.result.Result;
import com.miaosha.demo.service.DisasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
public class DemoController {

	@Autowired
	private HttpServletResponse myHttpResponse;
	
    @Autowired
    DisasterService disasterService;
    List<Disaster> disaster = null;

    @RequestMapping("/dbtest")
    @ResponseBody
    public Result<Disaster> dbGet(){
        List<Disaster> disaster = disasterService.selectByType("2");
        disaster.get(0).setId("123456400000012004");
        disasterService.insertOne(disaster.get(0));
        return Result.success(disaster.get(0));
    }

    //显示所有的数据
    @RequestMapping(value = "/datashow")
    public String dataShow(Model model){
        disaster = disasterService.selectAll();
        model.addAttribute("disaster",disaster);
        return "Client_showInfor";
    }

    @RequestMapping("/")
    public String home(){
        return "Client_index";
    }

    //选择数据显示的方式
    @RequestMapping("/homepage")
    public String dataShowSelect(){
        return "homepage";
    }

    //按照reporting_unit显示数据
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public String selectByUnit(@RequestParam("reporting_unit")String reporting_unit, Model model){
        disaster = disasterService.selectByUnit(reporting_unit);
        model.addAttribute("disaster",disaster);
        if(disaster != null){
            return "datashow";
        }else{
            return "error";
        }
    }

    //下载文件
    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte [] body = null;
        String str= JSON.toJSONString(disaster);;//要弄成json格式的字符串
        InputStream in = new ByteArrayInputStream(str.getBytes());
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=data.txt");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    //上传文件
    @RequestMapping(value = "/upload")
    //@ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
    	try {
    		PrintWriter out = myHttpResponse.getWriter();
    		myHttpResponse.setContentType("text/html; charset=UTF-8"); //转码
            if(file.isEmpty()) {                
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
            String str = sb.toString();
            disaster = JSONObject.parseArray(str, Disaster.class);
            disasterService.insertByJson(disaster);
            out.flush();
            out.println("<script>");
            out.println("alert('Import success！');");
            out.println("history.back();");
            out.println("</script>");
            //return "数据：" + str + "\n" + "导入成功";
        }catch(IllegalStateException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return "upload failure";
    }
    
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(Model model){
        return "login";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model){
        if(password.equals("1") && username.equals("test")){
            return "success";
        }
        else
            return "error";
    }
}
