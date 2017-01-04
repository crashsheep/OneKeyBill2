package com.ssh.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")

@ParentPackage("struts-default")
@Namespace("/")

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2266695172069461659L;

@Action(value = "loginAction", results = {
		@Result(name = "loginSuccess", location = "/WEB-INF/Main.jsp"),})
	public String login(){
			return "loginSuccess";
		}
	}
