package com.aco.model;

import java.util.Date;

public class ConversationRecord {
    private String id;

    private String personid;

    private Date talkstarttime;

    private String talkpolice;

    private String talktype;

    private String talkplace;

    private String ask;

    private String answer;

    private String talkcontent;

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

    public Date getTalkstarttime() {
        return talkstarttime;
    }

    public void setTalkstarttime(Date talkstarttime) {
        this.talkstarttime = talkstarttime;
    }

    public String getTalkpolice() {
        return talkpolice;
    }

    public void setTalkpolice(String talkpolice) {
        this.talkpolice = talkpolice == null ? null : talkpolice.trim();
    }

    public String getTalktype() {
        return talktype;
    }

    public void setTalktype(String talktype) {
        this.talktype = talktype == null ? null : talktype.trim();
    }

    public String getTalkplace() {
        return talkplace;
    }

    public void setTalkplace(String talkplace) {
        this.talkplace = talkplace == null ? null : talkplace.trim();
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask == null ? null : ask.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getTalkcontent() {
        return talkcontent;
    }

    public void setTalkcontent(String talkcontent) {
        this.talkcontent = talkcontent == null ? null : talkcontent.trim();
    }
}