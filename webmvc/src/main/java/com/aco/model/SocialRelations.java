package com.aco.model;

public class SocialRelations {
    private String id;

    private String personid;

    private String relationname;

    private String relationsex;

    private String relationphone;

    private String relationcertificatenum;

    private String address;

    private String relationship;

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

    public String getRelationname() {
        return relationname;
    }

    public void setRelationname(String relationname) {
        this.relationname = relationname == null ? null : relationname.trim();
    }

    public String getRelationsex() {
        return relationsex;
    }

    public void setRelationsex(String relationsex) {
        this.relationsex = relationsex == null ? null : relationsex.trim();
    }

    public String getRelationphone() {
        return relationphone;
    }

    public void setRelationphone(String relationphone) {
        this.relationphone = relationphone == null ? null : relationphone.trim();
    }

    public String getRelationcertificatenum() {
        return relationcertificatenum;
    }

    public void setRelationcertificatenum(String relationcertificatenum) {
        this.relationcertificatenum = relationcertificatenum == null ? null : relationcertificatenum.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }
}