package com.example.geek.model.query;

import java.util.Date;

/**
 * @author xiaowc
 */
public class BaseQuery extends QueryPageBean {
    /**
     * 模糊查询条件
     */
    private String q;

    /**
     * 状态（1：正常，0：停用）
     */
    private Integer state;

    private String diagnosticName;

    private Integer orgId;

    private Date modifyTime;

    private Integer icdType;

    public Integer getIcdType() {
        return icdType;
    }

    public void setIcdType(Integer icdType) {
        this.icdType = icdType;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getDiagnosticName() {
        return diagnosticName;
    }

    public void setDiagnosticName(String diagnosticName) {
        this.diagnosticName = diagnosticName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

}

