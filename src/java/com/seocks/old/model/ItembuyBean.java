package com.seocks.old.model;

import java.sql.Date;

public class ItembuyBean {
	
	private int itembuyno;
	private String pno;
	private String pname;
	private int pprice;
	private String pmainimg;
	private int pcate;
	private String psize;
	private int qty;
	private int totalprice;
	private Date reg_date;
	private String temp;
	
	public int getItembuyno() {
		return itembuyno;
	}
	public void setItembuyno(int itembuyno) {
		this.itembuyno = itembuyno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPmainimg() {
		return pmainimg;
	}
	public void setPmainimg(String pmainimg) {
		this.pmainimg = pmainimg;
	}
	public int getPcate() {
		return pcate;
	}
	public void setPcate(int pcate) {
		this.pcate = pcate;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
}
