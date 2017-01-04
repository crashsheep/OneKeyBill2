package com.ssh.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.NavDAO;
import com.ssh.model.Nav;
@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/")
public class NavAction extends ActionSupport implements ServletResponseAware{

	private static final long serialVersionUID = 8430605431265093517L;
	@Resource
	private NavDAO navDAO;
	private HttpServletResponse resp;
	private String data;
	private int id;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		resp=arg0;
	}
	//@Action(value="nav",results={ @Result(name="success",type="json",params={"root","data"}),})
	@Action(value="nav")
	public String execute() throws IOException, JSONException{
		List<Nav> navlist=navDAO.findAll(id);
		JSONArray jsonMembers = new JSONArray();
		for(Nav nav:navlist){
			JSONObject json = new JSONObject();
			json.put("id", nav.getId().toString());
			json.put("text", nav.getText().toString());
			json.put("state", nav.getState().toString());
			json.put("iconCls", nav.getIconCls().toString());
			json.put("url", nav.getUrl().toString());
			jsonMembers.put(json);
		}
		data = jsonMembers.toString();
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(data);
		return null;
	}



}
