package com.aco.model;

public class JuryRegis {
    private String id;

    private String personid;

    private String injurysitu;

    private String selfinjuryreason;

    private String medicalhistorysitu;

    private String policestatementreason;

    private String detainedpolice;

    private String scpolice;

    private String remark;

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

    public String getInjurysitu() {
        return injurysitu;
    }

    public void setInjurysitu(String injurysitu) {
        this.injurysitu = injurysitu == null ? null : injurysitu.trim();
    }

    public String getSelfinjuryreason() {
        return selfinjuryreason;
    }

    public void setSelfinjuryreason(String selfinjuryreason) {
        this.selfinjuryreason = selfinjuryreason == null ? null : selfinjuryreason.trim();
    }

    public String getMedicalhistorysitu() {
        return medicalhistorysitu;
    }

    public void setMedicalhistorysitu(String medicalhistorysitu) {
        this.medicalhistorysitu = medicalhistorysitu == null ? null : medicalhistorysitu.trim();
    }

    public String getPolicestatementreason() {
        return policestatementreason;
    }

    public void setPolicestatementreason(String policestatementreason) {
        this.policestatementreason = policestatementreason == null ? null : policestatementreason.trim();
    }

    public String getDetainedpolice() {
        return detainedpolice;
    }

    public void setDetainedpolice(String detainedpolice) {
        this.detainedpolice = detainedpolice == null ? null : detainedpolice.trim();
    }

    public String getScpolice() {
        return scpolice;
    }

    public void setScpolice(String scpolice) {
        this.scpolice = scpolice == null ? null : scpolice.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}