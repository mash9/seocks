package com.seocks.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by com on 2016-10-05.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingItem {

    private String itembuyno;
    private String pno;
    private String pname;
    private int pprice;
    private String pmainimg;
    private String pcate;
    private String psize;
    private int qty;
    private int totalprice;
    private Date regDate;
    private String temp;

    public String getItembuyno() {
        return itembuyno;
    }

    public void setItembuyno(String itembuyno) {
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

    public String getPcate() {
        return pcate;
    }

    public void setPcate(String pcate) {
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
