package com.android4dev.navigationview;

/**
 * Created by ihebs on 30/05/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Prediction {

    private Boolean Success;
    private List<Object> Errors = new ArrayList<Object>();
    private List<Result_Action> Results = new ArrayList<Result_Action>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in
     *
     */
    public Prediction() {
    }

    /**
     *
     * @param Results
     * @param Errors
     * @param Success
     */
    public Prediction(Boolean Success, List<Object> Errors, List<Result_Action> Results) {
        this.Success = Success;
        this.Errors = Errors;
        this.Results = Results;
    }

    /**
     *
     * @return
     * The Success
     */
    public Boolean getSuccess() {
        return Success;
    }

    /**
     *
     * @param Success
     * The Success
     */
    public void setSuccess(Boolean Success) {
        this.Success = Success;
    }

    public Prediction withSuccess(Boolean Success) {
        this.Success = Success;
        return this;
    }

    /**
     *
     * @return
     * The Errors
     */
    public List<Object> getErrors() {
        return Errors;
    }

    /**
     *
     * @param Errors
     * The Errors
     */
    public void setErrors(List<Object> Errors) {
        this.Errors = Errors;
    }

    public Prediction withErrors(List<Object> Errors) {
        this.Errors = Errors;
        return this;
    }

    /**
     *
     * @return
     * The Results
     */
    public List<Result_Action> getResults() {
        return Results;
    }

    /**
     *
     * @param Results
     * The Results
     */
    public void setResults(List<Result_Action> Results) {
        this.Results = Results;
    }

    public Prediction withResults(List<Result_Action> Results) {
        this.Results = Results;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Prediction withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}