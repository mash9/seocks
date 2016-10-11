package com.seocks.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by com on 2016-10-12.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

    private String payId;
    private String pno;
    private String psize;
    private int qty;
    private int price;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
