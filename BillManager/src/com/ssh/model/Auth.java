package com.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Auth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth", catalog = "fapiaoguanli")
public class Auth implements java.io.Serializable {

	// Fields

	private Integer authId;
	private String authName;
	private String auth;
	private String remark;

	// Constructors

	/** default constructor */
	public Auth() {
	}

	/** full constructor */
	public Auth(String authName, String auth, String remark) {
		this.authName = authName;
		this.auth = auth;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "authId", unique = true, nullable = false)
	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	@Column(name = "authName", nullable = false, length = 50)
	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	@Column(name = "auth", nullable = false)
	public String getAuth() {
		return this.auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Column(name = "remark", nullable = false, length = 30)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}