package com.android4dev.navigationview.Datamanagers;

import java.util.HashMap;
import java.util.Map;

public class Results_Dash {

    private Double Energy;
    private Double Bills;
    private String Currency;
    private Double Power;
    private Double CO2;
    private Double Temperature;
    private Integer Notification;
    private Integer Planner;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The Energy
     */
    public Double getEnergy() {
        return Energy;
    }

    /**
     *
     * @param Energy
     * The Energy
     */
    public void setEnergy(Double Energy) {
        this.Energy = Energy;
    }

    /**
     *
     * @return
     * The Bills
     */
    public Double getBills() {
        return Bills;
    }

    /**
     *
     * @param Bills
     * The Bills
     */
    public void setBills(Double Bills) {
        this.Bills = Bills;
    }

    /**
     *
     * @return
     * The Currency
     */
    public String getCurrency() {
        return Currency;
    }

    /**
     *
     * @param Currency
     * The Currency
     */
    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    /**
     *
     * @return
     * The Power
     */
    public Double getPower() {
        return Power;
    }

    /**
     *
     * @param Power
     * The Power
     */
    public void setPower(Double Power) {
        this.Power = Power;
    }

    /**
     *
     * @return
     * The CO2
     */
    public Double getCO2() {
        return CO2;
    }

    /**
     *
     * @param CO2
     * The CO2
     */
    public void setCO2(Double CO2) {
        this.CO2 = CO2;
    }

    /**
     *
     * @return
     * The Temperature
     */
    public Double getTemperature() {
        return Temperature;
    }

    /**
     *
     * @param Temperature
     * The Temperature
     */
    public void setTemperature(Double Temperature) {
        this.Temperature = Temperature;
    }

    /**
     *
     * @return
     * The Notification
     */
    public Integer getNotification() {
        return Notification;
    }

    /**
     *
     * @param Notification
     * The Notification
     */
    public void setNotification(Integer Notification) {
        this.Notification = Notification;
    }

    /**
     *
     * @return
     * The Planner
     */
    public Integer getPlanner() {
        return Planner;
    }

    /**
     *
     * @param Planner
     * The Planner
     */
    public void setPlanner(Integer Planner) {
        this.Planner = Planner;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
