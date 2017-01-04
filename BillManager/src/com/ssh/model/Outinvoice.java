package com.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Outinvoice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "outinvoice", catalog = "fapiaoguanli")
public class Outinvoice implements java.io.Serializable {

	// Fields

	private Integer invoiceId;
	private String invoiceNum;
	private String balanceNum;
	private String outName;
	private String inName;
	private Integer taxRate;
	private Integer amount;
	private String remark;

	// Constructors

	/** default constructor */
	public Outinvoice() {
	}

	/** full constructor */
	public Outinvoice(String invoiceNum, String balanceNum, String outName,
			String inName, Integer taxRate, Integer amount, String remark) {
		this.invoiceNum = invoiceNum;
		this.balanceNum = balanceNum;
		this.outName = outName;
		this.inName = inName;
		this.taxRate = taxRate;
		this.amount = amount;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "invoiceId", unique = true, nullable = false)
	public Integer getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Column(name = "invoiceNum", length = 30)
	public String getInvoiceNum() {
		return this.invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	@Column(name = "balanceNum", length = 30)
	public String getBalanceNum() {
		return this.balanceNum;
	}

	public void setBalanceNum(String balanceNum) {
		this.balanceNum = balanceNum;
	}

	@Column(name = "outName")
	public String getOutName() {
		return this.outName;
	}

	public void setOutName(String outName) {
		this.outName = outName;
	}

	@Column(name = "inName")
	public String getInName() {
		return this.inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	@Column(name = "taxRate")
	public Integer getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}