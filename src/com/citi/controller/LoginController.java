package com.citi.controller;
//import javax.ws.rs.POST;

//import org.json.JSONObject;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;

import com.citi.delegate.LoginDelegate;
import com.citi.viewBean.LoginBean;

@Controller
@RequestMapping("/")

public class LoginController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:pages/page.html";

	}

	//@POST
	@RequestMapping(value = "/login",method = RequestMethod.POST,headers={"Accept=text/html"},produces="text/html")
	
    public @ResponseBody String checkLogin(@ModelAttribute LoginBean loginBean) throws Exception {
		//LoginBean loginBean=new LoginBean();
		//loginBean.setUsername(username);
		//loginBean.setPassword(password);
		String line;
		LoginDelegate loginDelegate = new LoginDelegate();
		System.out.println("In executeLogin()");
		if(loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword()))
		{
			System.out.println("In login controller if-login successful");
			line="Successful";
			
		}
		else
		{
			System.out.println("In login controller else-login unsuccessful");
			line="Unsuccessful";
			
		}
		//System.out.println(line);
		//JSONObject msg=new JSONObject();
		//msg.put("msg",line);
		//System.out.println(msg.toString());
		return line ;
		

	}

}
