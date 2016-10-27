package com.seocks.shopping.model.chart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by com on 2016-10-28.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChartElement {

    private String buyDate;
    private Integer price;

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
