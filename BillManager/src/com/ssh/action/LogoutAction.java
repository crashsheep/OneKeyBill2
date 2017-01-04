package com.ssh.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")

@ParentPackage("struts-default")
@Namespace("/")

public class LogoutAction extends ActionSupport{
@Action(value="logout",results={@Result(name="success",location="/login.jsp"),})
	public String execute(){
	ActionContext ac=ActionContext.getContext();
	Map session=ac.getSession();
	session.clear();
		return "success";
	}

}
