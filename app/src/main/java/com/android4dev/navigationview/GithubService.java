package com.android4dev.navigationview;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by TABKA on 02/05/2016.
 */
public interface GithubService {

    public static final String ENDPOINT = "https://smartlife.chifco.com/api";
    @GET("/consumption/GetTotalConsumption/")
    Dashboard_webservice setdmainpage(
            @Query("userId") String userid,
            @Query("period") String month,
            @Query("checksum") String checksum);
}
//, Callback<Dashboard_webservice> Dashboard