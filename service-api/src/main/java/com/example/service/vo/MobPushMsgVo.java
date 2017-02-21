package com.example.service.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by guiqiang on 2016/7/26.
 */
public class MobPushMsgVo implements Serializable{

    private static final long serialVersionUID = -5326916862628088659L;

    private Integer statDate;
    private Integer pushId;
    private String pushName;
    private String sspName;
    private String industryType;
    private Long impressNum;
    private Long clickNum;
    private BigDecimal fuyiCost;

    public Integer getStatDate() {
        return statDate;
    }

    public void setStatDate(Integer statDate) {
        this.statDate = statDate;
    }

    public String getPushName() {
        return pushName;
    }

    public void setPushName(String pushName) {
        this.pushName = pushName;
    }

    public Integer getPushId() {
        return pushId;
    }

    public void setPushId(Integer pushId) {
        this.pushId = pushId;
    }

    public String getSspName() {
        return sspName;
    }

    public void setSspName(String sspName) {
        this.sspName = sspName;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public Long getImpressNum() {
        return impressNum;
    }

    public void setImpressNum(Long impressNum) {
        this.impressNum = impressNum;
    }

    public Long getClickNum() {
        return clickNum;
    }

    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    public BigDecimal getFuyiCost() {
        return fuyiCost;
    }

    public void setFuyiCost(BigDecimal fuyiCost) {
        this.fuyiCost = fuyiCost;
    }
}
