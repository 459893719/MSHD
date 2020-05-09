package com.miaosha.demo.controller;

import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.domain.User;
import com.miaosha.demo.json.OperateJsonFile;
import com.miaosha.demo.result.CodeMsg;
import com.miaosha.demo.result.Result;
import com.miaosha.demo.service.DisasterService;
import com.miaosha.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DemoController {

    @Autowired
    DisasterService disasterService;

    @RequestMapping("/dbtest")
    @ResponseBody
    public Result<Disaster> dbGet(){
        List<Disaster> disaster = disasterService.selectByType("2");
        disaster.get(0).setId("123456400000012004");
        disasterService.insertOne(disaster.get(0));
        return Result.success(disaster.get(0));
    }

    @RequestMapping(value = "/datashow")
    public String datashow(Model model){
        List<Disaster> disaster = disasterService.selectAll();
        model.addAttribute("disaster",disaster);
        return "datashow";
    }

    @RequestMapping("/")
    public String home(){
        return "hello";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(Model model){
        return "login";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model){
        if(password.equals("1") && username.equals("test")){
            return datashow(model);
        }
        else
            return "error";
    }



}
