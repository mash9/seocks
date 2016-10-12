package com.seocks.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by com on 2016-10-03.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Jspmember {

    private String id;
    private String pass;
    private String name;
    private String email;
    private String mtemp;
    private String maddress1;
    private String maddress2;
    private String gender;
    private String birthday;
    private String info;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMtemp() {
        return mtemp;
    }

    public void setMtemp(String mtemp) {
        this.mtemp = mtemp;
    }

    public String getMaddress1() {
        return maddress1;
    }

    public void setMaddress1(String maddress1) {
        this.maddress1 = maddress1;
    }

    public String getMaddress2() {
        return maddress2;
    }

    public void setMaddress2(String maddress2) {
        this.maddress2 = maddress2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
