package com.ssh.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.service.UserService;
@Controller
@Scope("prototype")

@ParentPackage("json-default")
@Namespace("/")

public class LoginValidate extends ActionSupport {

	private static final long serialVersionUID = 3500794226195739702L;

	@Resource
	private UserService userService;
	
    private String flag;
	private String username;
	private String password;

	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
@Action(value = "loginValidate", results = { @Result(name = "success", type = "json", params = {
			"root", "flag" }) })

   public String vali(){	
		if(userService.loginValidate(username, password)){			
			flag="1";
			ActionContext ac=ActionContext.getContext();
			Map<String, Object> session=ac.getSession();
			session.put("username", username);
		}
		else{
			flag=null;
		}
		return "success";
		
	}
}
