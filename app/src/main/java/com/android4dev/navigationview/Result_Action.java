
package com.android4dev.navigationview;




public class Result_Action {


    private Integer id;

    private Integer EquipementID;
    private Integer Value;
    private String Date;
    private Integer Verrified;

    /**
     *
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Result_Action withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     *     The EquipementID
     */
    public Integer getEquipementID() {
        return EquipementID;
    }

    /**
     *
     * @param EquipementID
     *     The EquipementID
     */
    public void setEquipementID(Integer EquipementID) {
        this.EquipementID = EquipementID;
    }

    public Result_Action withEquipementID(Integer EquipementID) {
        this.EquipementID = EquipementID;
        return this;
    }

    /**
     *
     * @return
     *     The Value
     */
    public Integer getValue() {
        return Value;
    }

    /**
     *
     * @param Value
     *     The Value
     */
    public void setValue(Integer Value) {
        this.Value = Value;
    }

    public Result_Action withValue(Integer Value) {
        this.Value = Value;
        return this;
    }

    /**
     *
     * @return
     *     The Date
     */
    public String getDate() {
        return Date;
    }

    /**
     *
     * @param Date
     *     The Date
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    public Result_Action withDate(String Date) {
        this.Date = Date;
        return this;
    }

    /**
     *
     * @return
     *     The Verrified
     */
    public Integer getVerrified() {
        return Verrified;
    }

    /**
     *
     * @param Verrified
     *     The Verrified
     */
    public void setVerrified(Integer Verrified) {
        this.Verrified = Verrified;
    }

    public Result_Action withVerrified(Integer Verrified) {
        this.Verrified = Verrified;
        return this;
    }


}
