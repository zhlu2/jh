package com.aco.model;

import java.util.Date;

public class PoliceBasicInfo {
    private String id;

    private String policenum;

    private String policename;

    private String policesex;

    private String politicaloutlook;

    private Date worktime;

    private Date createtime;

    private String certificatenum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPolicenum() {
        return policenum;
    }

    public void setPolicenum(String policenum) {
        this.policenum = policenum == null ? null : policenum.trim();
    }

    public String getPolicename() {
        return policename;
    }

    public void setPolicename(String policename) {
        this.policename = policename == null ? null : policename.trim();
    }

    public String getPolicesex() {
        return policesex;
    }

    public void setPolicesex(String policesex) {
        this.policesex = policesex == null ? null : policesex.trim();
    }

    public String getPoliticaloutlook() {
        return politicaloutlook;
    }

    public void setPoliticaloutlook(String politicaloutlook) {
        this.politicaloutlook = politicaloutlook == null ? null : politicaloutlook.trim();
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCertificatenum() {
        return certificatenum;
    }

    public void setCertificatenum(String certificatenum) {
        this.certificatenum = certificatenum == null ? null : certificatenum.trim();
    }
}