package com.aco.model;

import java.util.Date;

public class PrsArrgInfo {
    private String id;

    private String personid;

    private Date applydate;

    private String applypolice;

    private String prsfullname;

    private String sex;

    private String age;

    private String prsrelation;

    private String applyreason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid == null ? null : personid.trim();
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getApplypolice() {
        return applypolice;
    }

    public void setApplypolice(String applypolice) {
        this.applypolice = applypolice == null ? null : applypolice.trim();
    }

    public String getPrsfullname() {
        return prsfullname;
    }

    public void setPrsfullname(String prsfullname) {
        this.prsfullname = prsfullname == null ? null : prsfullname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getPrsrelation() {
        return prsrelation;
    }

    public void setPrsrelation(String prsrelation) {
        this.prsrelation = prsrelation == null ? null : prsrelation.trim();
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason == null ? null : applyreason.trim();
    }
}