package com.example.smartfarming;

public class Oder {
    String nic,landName ,seedType, totalSeedAmount, totalSeedCost, fertilizerType, totalFertilizerAmount, totalFertilizerCost, waterTimePeriod, waterTotalCost, landID, landCost, overallCost, newStatus, cultivationTimePeriod, yourIncome;

    public Oder(String nic, String landName, String seedType, String totalSeedAmount, String totalSeedCost, String fertilizerType, String totalFertilizerAmount, String totalFertilizerCost, String waterTimePeriod, String waterTotalCost, String landID, String landCost, String overallCost, String newStatus, String cultivationTimePeriod, String yourIncome) {
        this.nic = nic;
        this.seedType = seedType;
        this.totalSeedAmount = totalSeedAmount;
        this.totalSeedCost = totalSeedCost;
        this.fertilizerType = fertilizerType;
        this.totalFertilizerAmount = totalFertilizerAmount;
        this.totalFertilizerCost = totalFertilizerCost;
        this.waterTimePeriod = waterTimePeriod;
        this.waterTotalCost = waterTotalCost;
        this.landID = landID;
        this.landCost = landCost;
        this.overallCost = overallCost;
        this.newStatus = newStatus;
        this.landName = landName;
        this.cultivationTimePeriod = cultivationTimePeriod;
        this.yourIncome = yourIncome;
    }

    public String getStatus() {
        return newStatus;
    }

    public String getLandName() {
        return landName;
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

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public void setStatus(String status) {
        this.newStatus = status;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getSeedType() {
        return seedType;
    }

    public void setSeedType(String seedType) {
        this.seedType = seedType;
    }

    public String getTotalSeedAmount() {
        return totalSeedAmount;
    }

    public void setTotalSeedAmount(String totalSeedAmount) {
        this.totalSeedAmount = totalSeedAmount;
    }

    public String getTotalSeedCost() {
        return totalSeedCost;
    }

    public void setTotalSeedCost(String totalSeedCost) {
        this.totalSeedCost = totalSeedCost;
    }

    public String getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(String fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public String getTotalFertilizerAmount() {
        return totalFertilizerAmount;
    }

    public void setTotalFertilizerAmount(String totalFertilizerAmount) {
        this.totalFertilizerAmount = totalFertilizerAmount;
    }

    public String getTotalFertilizerCost() {
        return totalFertilizerCost;
    }

    public void setTotalFertilizerCost(String totalFertilizerCost) {
        this.totalFertilizerCost = totalFertilizerCost;
    }

    public String getWaterTimePeriod() {
        return waterTimePeriod;
    }

    public void setWaterTimePeriod(String waterTimePeriod) {
        this.waterTimePeriod = waterTimePeriod;
    }

    public String getWaterTotalCost() {
        return waterTotalCost;
    }

    public void setWaterTotalCost(String waterTotalCost) {
        this.waterTotalCost = waterTotalCost;
    }

    public String getLandID() {
        return landID;
    }

    public void setLandID(String landID) {
        this.landID = landID;
    }

    public String getLandCost() {
        return landCost;
    }

    public void setLandCost(String landCost) {
        this.landCost = landCost;
    }

    public String getOverallCost() {
        return overallCost;
    }

    public void setOverallCost(String overallCost) {
        this.overallCost = overallCost;
    }
}
