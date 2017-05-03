package com.aco.model;

import java.util.Date;

public class RiskAssessment {
    private String id;

    private String personId;
    
    private String fullname;

    public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	private Date createtime;

    private String caseStatus;

    private String PerStatusInPrison;

    private String remark;

    private String directorApprovalMark;

    private String departmentApprovalMark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

 
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getPerStatusInPrison() {
		return PerStatusInPrison;
	}

	public void setPerStatusInPrison(String perStatusInPrison) {
		PerStatusInPrison = perStatusInPrison;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDirectorApprovalMark() {
		return directorApprovalMark;
	}

	public void setDirectorApprovalMark(String directorApprovalMark) {
		this.directorApprovalMark = directorApprovalMark;
	}

	public String getDepartmentApprovalMark() {
		return departmentApprovalMark;
	}

	public void setDepartmentApprovalMark(String departmentApprovalMark) {
		this.departmentApprovalMark = departmentApprovalMark;
	}

 
}