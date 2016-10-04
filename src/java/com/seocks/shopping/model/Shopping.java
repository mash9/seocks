package com.seocks.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by com on 2016-10-03.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shopping {

    private String pno;
    private String pname;
    private String pprice;
    private String pinfo;
    private String pmainimg;
    private String psubimg;
    private String pocunt;
    private String pcate;
    private String ptemp;

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

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
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

    public String getPocunt() {
        return pocunt;
    }

    public void setPocunt(String pocunt) {
        this.pocunt = pocunt;
    }

    public String getPcate() {
        return pcate;
    }

    public void setPcate(String pcate) {
        this.pcate = pcate;
    }

    public String getPtemp() {
        return ptemp;
    }

    public void setPtemp(String ptemp) {
        this.ptemp = ptemp;
    }
}
