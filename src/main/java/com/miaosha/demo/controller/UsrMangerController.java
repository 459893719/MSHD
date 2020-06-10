package com.miaosha.demo.controller;

import com.miaosha.demo.domain.User;
import com.miaosha.demo.service.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UsrMangerController {

    @RequestMapping(value = "/adminUserManage/addUser",method = RequestMethod.POST)
    public String addUser(@RequestParam("userid") String idstr,@RequestParam("username") String name, @RequestParam("userpwd") String pwd){
    	if(idstr==""||name==""||pwd=="") {
    		return "redirect:/adminUserManage";
    	}
    	int id= Integer.parseInt(idstr);
    	User user = new User(id,name,pwd);
    	UserService.insertUser(user);
        return "redirect:/adminUserManage";
    }
  
    @RequestMapping(value = "/adminUserManage/search",method = RequestMethod.GET)
    public String searchUser(@RequestParam("searchUser") String idstr,Model model){
    List<User>  usrList=null;
    	if(idstr=="") {
    		usrList=UserService.selectAll();
    		model.addAttribute("User", usrList);
    		return "redirect:/adminUserManage";
    	}
     	
    	int id= Integer.parseInt(idstr);
    	usrList=UserService.getById(id);
    	
		model.addAttribute("User", usrList);
		return "redirect:/adminUserManage";
    }
    @RequestMapping(value = "/adminUserManage/modify")
    @ResponseBody
    public String usrModify(@RequestParam("userid") String idstr,@RequestParam("username") String name, @RequestParam("userpwd") String pwd){
//    	System.out.println(idstr);
    	if(idstr==""||name==""||pwd=="") {
    		return "success";
    	}
    	int id= Integer.parseInt(idstr);
    	User user = new User(id,name,pwd);
    	UserService.modifyById(id, user);
    	return "success";
    }
    
    @RequestMapping(value = "/adminUserManage/delete")
    @ResponseBody
    public String usrDelete(Model model, HttpServletRequest request){
    	String idstr= request.getParameter("userID");
    	int id= Integer.parseInt(idstr);
 //   	System.out.println(id);
    	UserService.deleteById(id);
    	return "success";
    }

}
