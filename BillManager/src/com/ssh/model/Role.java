package com.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "fapiaoguanli")
public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String remark;
	private Integer authId;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleName, Integer authId) {
		this.roleName = roleName;
		this.authId = authId;
	}

	/** full constructor */
	public Role(String roleName, String remark, Integer authId) {
		this.roleName = roleName;
		this.remark = remark;
		this.authId = authId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "roleId", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "roleName", nullable = false, length = 30)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "authId", nullable = false)
	public Integer getAuthId() {
		return this.authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

}