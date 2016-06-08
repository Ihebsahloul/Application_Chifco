package com.android4dev.navigationview.Datamanagers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TABKA on 30/05/2016.
 */
public class Result_plot {
    private Integer id;
    private Integer equipementID;
    private Integer value;
    private String date;
    private Integer propertieName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The equipementID
     */
    public Integer getEquipementID() {
        return equipementID;
    }

    /**
     *
     * @param equipementID
     * The EquipementID
     */
    public void setEquipementID(Integer equipementID) {
        this.equipementID = equipementID;
    }

    /**
     *
     * @return
     * The value
     */
    public Integer getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The Value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The Date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The propertieName
     */
    public Integer getPropertieName() {
        return propertieName;
    }

    /**
     *
     * @param propertieName
     * The PropertieName
     */
    public void setPropertieName(Integer propertieName) {
        this.propertieName = propertieName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}