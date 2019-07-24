package com.example.paiban.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class phase {
    @JSONField(ordinal = 1)
    private int Id;
    @JSONField(ordinal = 2)
    private String phase;
    @JSONField(ordinal = 3)
    private int departId;
    @JSONField(ordinal = 4)
    private int hour;
    @JSONField(ordinal = 5)
    private String createDate;
    @JSONField(ordinal = 6)
    private String initDate;
    @JSONField(ordinal = 7)
    private int phaseId;

    // 前端渲染需要用到的
    @JSONField(ordinal = 8)
    public String value = "phase";
    @JSONField(ordinal = 9)
    private String phaseEnd;

    @JSONField(ordinal = 10,name = "text")
    private String text;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    public String getPhaseEnd() {
        return phaseEnd;
    }

    public void setPhaseEnd(String phaseEnd) {
        this.phaseEnd = phaseEnd;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
