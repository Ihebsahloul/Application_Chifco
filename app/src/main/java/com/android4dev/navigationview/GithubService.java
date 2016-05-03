package com.android4dev.navigationview;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by TABKA on 02/05/2016.
 */
public interface GithubService {

    public static final String ENDPOINT = "https://smartlife.chifco.com";
    @GET("/api/consumption/GetTotalConsumption/")
    Dashboard_webservice setdmainpage(
            @Query("userId") String userid,
            @Query("period") String month,
            @Query("checksum") String checksum);




    @GET("/api/contact/logintest")
    public void logintest(
            @Query("email") String user ,
            @Query("password") String pass , Callback<Example> callback);

    @POST("/signup")
    void SignUp(@Field("email") String name, @Field("email") String email,
                @Field("pass") String pass, Callback<Example> pm);
}
//, Callback<Dashboard_webservice> Dashboard