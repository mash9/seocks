package com.seocks.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by com on 2016-10-13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bought {
    private String pno;
    private String pname;
    private String pinfo;
    private String pmainimg;
    private String psubimg;
    private String psize;
    private String qty;
    private String price;
    private Date buyDate;

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

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public String getPmainimg() {
        return pmainimg;
    }

    public void setPmainimg(String pmainimg) {
        this.pmainimg = pmainimg;
    }

    public String getPsubimg() {
        return psubimg;
    }

    public void setPsubimg(String psubimg) {
        this.psubimg = psubimg;
    }

    public String getPsize() {
        return psize;
    }

    public void setPsize(String psize) {
        this.psize = psize;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
