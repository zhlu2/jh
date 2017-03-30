package com.aco.model;

import java.util.Date;

public class DedrugBasicInfo {
    private String id;

    private String fullname;

    private String sex;

    private String certificatenum;

    private String personid;

    private String drugabuse;

    private String drugtype;

    private String casehandleperson;

    private String abandonlimit;

    private String abandonmethod;

    private String personsign;

    private String processstate;

    private Date abandonstartdate;

    private String entryreason;

    private Date createtime;

    private Date expectedtime;

    private String outcause;

    private String managepolice;

    private String publishtype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCertificatenum() {
        return certificatenum;
    }

    public void setCertificatenum(String certificatenum) {
        this.certificatenum = certificatenum == null ? null : certificatenum.trim();
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid == null ? null : personid.trim();
    }

    public String getDrugabuse() {
        return drugabuse;
    }

    public void setDrugabuse(String drugabuse) {
        this.drugabuse = drugabuse == null ? null : drugabuse.trim();
    }

    public String getDrugtype() {
        return drugtype;
    }

    public void setDrugtype(String drugtype) {
        this.drugtype = drugtype == null ? null : drugtype.trim();
    }

    public String getCasehandleperson() {
        return casehandleperson;
    }

    public void setCasehandleperson(String casehandleperson) {
        this.casehandleperson = casehandleperson == null ? null : casehandleperson.trim();
    }

    public String getAbandonlimit() {
        return abandonlimit;
    }

    public void setAbandonlimit(String abandonlimit) {
        this.abandonlimit = abandonlimit == null ? null : abandonlimit.trim();
    }

    public String getAbandonmethod() {
        return abandonmethod;
    }

    public void setAbandonmethod(String abandonmethod) {
        this.abandonmethod = abandonmethod == null ? null : abandonmethod.trim();
    }

    public String getPersonsign() {
        return personsign;
    }

    public void setPersonsign(String personsign) {
        this.personsign = personsign == null ? null : personsign.trim();
    }

    public String getProcessstate() {
        return processstate;
    }

    public void setProcessstate(String processstate) {
        this.processstate = processstate == null ? null : processstate.trim();
    }

    public Date getAbandonstartdate() {
        return abandonstartdate;
    }

    public void setAbandonstartdate(Date abandonstartdate) {
        this.abandonstartdate = abandonstartdate;
    }

    public String getEntryreason() {
        return entryreason;
    }

    public void setEntryreason(String entryreason) {
        this.entryreason = entryreason == null ? null : entryreason.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getExpectedtime() {
        return expectedtime;
    }

    public void setExpectedtime(Date expectedtime) {
        this.expectedtime = expectedtime;
    }

    public String getOutcause() {
        return outcause;
    }

    public void setOutcause(String outcause) {
        this.outcause = outcause == null ? null : outcause.trim();
    }

    public String getManagepolice() {
        return managepolice;
    }

    public void setManagepolice(String managepolice) {
        this.managepolice = managepolice == null ? null : managepolice.trim();
    }

    public String getPublishtype() {
        return publishtype;
    }

    public void setPublishtype(String publishtype) {
        this.publishtype = publishtype == null ? null : publishtype.trim();
    }
}