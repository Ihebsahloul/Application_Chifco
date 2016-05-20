package com.android4dev.navigationview.Datamanagers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TABKA on 02/05/2016.
 */
public class Dashboard_webservice {

    private Boolean Success;
    private List<Object> Errors = new ArrayList<Object>();
    private Results_Dash Results;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     *
     * @return
     * The Results
     */
    public Results_Dash getResults() {
        return Results;
    }

    /**
     *
     * @param Results
     * The Results
     */
    public void setResults(Results_Dash Results) {
        this.Results = Results;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

