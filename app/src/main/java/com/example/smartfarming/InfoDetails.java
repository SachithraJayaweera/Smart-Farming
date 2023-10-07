package com.example.smartfarming;

import android.util.Log;

public class InfoDetails {
    private static final String error = "jms";
    String landName, seedType, fertilizerType, waterTimePeriod, cultivationTimePeriod, yourIncome;

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public String getSeedType() {
        return seedType;
    }

    public void setSeedType(String seedType) {
        this.seedType = seedType;
    }

    public String getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(String fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public String getWaterTimePeriod() {
        return waterTimePeriod;
    }

    public void setWaterTimePeriod(String waterTimePeriod) {
        this.waterTimePeriod = waterTimePeriod;
    }

    public String getCultivationTimePeriod() {
        return cultivationTimePeriod;
    }

    public void setCultivationTimePeriod(String cultivationTimePeriod) {
        this.cultivationTimePeriod = cultivationTimePeriod;
    }

    public String getYourIncome() {
        return yourIncome;
    }

    public void setYourIncome(String yourIncome) {
        this.yourIncome = yourIncome;
    }
}
