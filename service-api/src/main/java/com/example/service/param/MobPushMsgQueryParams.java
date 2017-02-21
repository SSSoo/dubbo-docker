package com.example.service.param;

import java.io.Serializable;
import java.util.Date;

/**
 * Push消息报表查询参数对象
 * Created by guiqiang on 2016/7/26.
 */
public class MobPushMsgQueryParams implements Serializable {
    private static final long serialVersionUID = -4595163519423152205L;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 结束日期
     */
    private Date endDate;
    /**
     * Push ID
     */
    private Integer pushId;
    /**
     * Push 名称
     */
    private String pushName;

    /**
     * 开发者名称
     */
    private String sspName;
    /**
     * 行业类型（一级-二级;一级-二级）
     */
//    private String industryType;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPushId() {
        return pushId;
    }

    public void setPushId(Integer pushId) {
        this.pushId = pushId;
    }

    public String getPushName() {
        return pushName;
    }

    public void setPushName(String pushName) {
        this.pushName = pushName;
    }

    public String getSspName() {
        return sspName;
    }

    public void setSspName(String sspName) {
        this.sspName = sspName;
    }

//    public String getIndustryType() {
//        return industryType;
//    }
//
//    public void setIndustryType(String industryType) {
//        this.industryType = industryType;
//    }
}
