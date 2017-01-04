package com.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company", catalog = "fapiaoguanli")
public class Company implements java.io.Serializable {

	// Fields

	private Integer companyId;
	private String companyName;
	private String companyOwner;
	private String companyState;
	private String corporateNum;
	private String corporateName;
	private String corporatePhone;
	private String remark;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(String companyName, String companyOwner,
			String companyState, String corporateNum, String corporateName,
			String corporatePhone, String remark) {
		this.companyName = companyName;
		this.companyOwner = companyOwner;
		this.companyState = companyState;
		this.corporateNum = corporateNum;
		this.corporateName = corporateName;
		this.corporatePhone = corporatePhone;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "companyId", unique = true, nullable = false)
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "companyName")
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "companyOwner")
	public String getCompanyOwner() {
		return this.companyOwner;
	}

	public void setCompanyOwner(String companyOwner) {
		this.companyOwner = companyOwner;
	}

	@Column(name = "companyState")
	public String getCompanyState() {
		return this.companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	@Column(name = "corporateNum")
	public String getCorporateNum() {
		return this.corporateNum;
	}

	public void setCorporateNum(String corporateNum) {
		this.corporateNum = corporateNum;
	}

	@Column(name = "corporateName")
	public String getCorporateName() {
		return this.corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	@Column(name = "corporatePhone")
	public String getCorporatePhone() {
		return this.corporatePhone;
	}

	public void setCorporatePhone(String corporatePhone) {
		this.corporatePhone = corporatePhone;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}