package com.example.paiban.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class classdata {

    @JSONField(ordinal = 1)
    private int id;
    @JSONField(ordinal = 2)
    private int phaseId;
    @JSONField(ordinal = 3)
    private int departId;
    @JSONField(ordinal = 4)
    private String Today;
    @JSONField(ordinal = 5)
    private int spaceMor;
    @JSONField(ordinal = 6)
    private String userId;
    @JSONField(ordinal = 7)
    private int leftSpaceMor;
    @JSONField(ordinal = 8)
    private String userNameMor;
    @JSONField(ordinal = 9)
    private String phaseMor;
    @JSONField(ordinal = 10)
    private int hourMor;
    @JSONField(ordinal = 11)
    private String phaseAft;
    @JSONField(ordinal = 12)
    private int spaceAft;
    @JSONField(ordinal = 13)
    private int leftSpaceAft;
    @JSONField(ordinal = 14)
    private String userNameAft;
    @JSONField(ordinal = 15)
    private boolean alreadyOrderMor;
    @JSONField(ordinal = 16)
    private boolean alreadyOrderAft;

    @JSONField(ordinal = 17)
    private String phaseMorEnd;

    @JSONField(ordinal = 18)
    private String phaseAftEnd;
    @JSONField(ordinal = 19)
    private int hourAft;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(int phaseId) {
        this.phaseId = phaseId;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public String getToday() {
        return Today;
    }

    public void setToday(String today) {
        Today = today;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public int getSpaceMor() {
        return spaceMor;
    }

    public void setSpaceMor(int spaceMor) {
        this.spaceMor = spaceMor;
    }

    public int getLeftSpaceMor() {
        return leftSpaceMor;
    }

    public void setLeftSpaceMor(int leftSpaceMor) {
        this.leftSpaceMor = leftSpaceMor;
    }

    public String getUserNameMor() {
        return userNameMor;
    }

    public void setUserNameMor(String userNameMor) {
        this.userNameMor = userNameMor;
    }

    public String getPhaseMor() {
        return phaseMor;
    }

    public void setPhaseMor(String phaseMor) {
        this.phaseMor = phaseMor;
    }

    public String getPhaseAft() {
        return phaseAft;
    }

    public void setPhaseAft(String phaseAft) {
        this.phaseAft = phaseAft;
    }

    public int getSpaceAft() {
        return spaceAft;
    }

    public void setSpaceAft(int spaceAft) {
        this.spaceAft = spaceAft;
    }

    public int getLeftSpaceAft() {
        return leftSpaceAft;
    }

    public void setLeftSpaceAft(int leftSpaceAft) {
        this.leftSpaceAft = leftSpaceAft;
    }

    public String getUserNameAft() {
        return userNameAft;
    }

    public void setUserNameAft(String userNameAft) {
        this.userNameAft = userNameAft;
    }

    public boolean isAlreadyOrderAft() {
        return alreadyOrderAft;
    }

    public void setAlreadyOrderAft(boolean alreadyOrderAft) {
        this.alreadyOrderAft = alreadyOrderAft;
    }

    public boolean isAlreadyOrderMor() {
        return alreadyOrderMor;
    }

    public void setAlreadyOrderMor(boolean alreadyOrderMor) {
        this.alreadyOrderMor = alreadyOrderMor;
    }

    public String getPhaseMorEnd() {
        return phaseMorEnd;
    }

    public void setPhaseMorEnd(String phaseMorEnd) {
        this.phaseMorEnd = phaseMorEnd;
    }

    public String getPhaseAftEnd() {
        return phaseAftEnd;
    }

    public void setPhaseAftEnd(String phaseAftEnd) {
        this.phaseAftEnd = phaseAftEnd;
    }

    public int getHourMor() {
        return hourMor;
    }

    public void setHourMor(int hourMor) {
        this.hourMor = hourMor;
    }

    public int getHourAft() {
        return hourAft;
    }

    public void setHourAft(int hourAft) {
        this.hourAft = hourAft;
    }
}
