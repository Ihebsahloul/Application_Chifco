package com.android4dev.navigationview.Fragments;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android4dev.navigationview.Datamanagers.Dashboard_webservice;
import com.android4dev.navigationview.Datamanagers.Results;
import com.android4dev.navigationview.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import retrofit.RestAdapter;


/**
 * Created by Admin on 04-06-2015.
 */
public class ContentFragment extends Fragment {


    ProgressBar myprogressBar;
    TextView textView11 ;
    ProgressBar myprogressBar1 ;
    Handler progressHandler = new Handler();
    int i = 0;
    private final String TAG = ContentFragment.class.getSimpleName();





    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {


        ScrollView viewroot  = ( ScrollView) inflater.inflate(R.layout.content_fragment, container, false);
        //RestAdapter adapter = new RestAdapter.Builder().setEndpoint(GithubService.ENDPOINT).build();
       // final GithubService restInterface = adapter.create(GithubService.class);

        Results.GithubService githubService = new RestAdapter.Builder()
                .setEndpoint(Results.GithubService.ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(Results.GithubService.class);


        new ListReposTask().execute("2311","month","42a594aa09b9d7581a0b74e7ad4940e7");


        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/museosans-500.otf");
        Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Semibold.otf");
        Typeface tf3 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Roboto-Bold.ttf") ;
        TextView txt1 = (TextView)  viewroot.findViewById(R.id.textView2);
        TextView txt2 = (TextView)  viewroot.findViewById(R.id.textView3);
        TextView txt3 = (TextView)  viewroot.findViewById(R.id.textView4);
        TextView txt11 = (TextView)  viewroot.findViewById(R.id.item);

        TextView txt4 = (TextView)  viewroot.findViewById(R.id.textView5);
        TextView txt5 = (TextView)  viewroot.findViewById(R.id.progress_circle_text);
        TextView txt7 = (TextView)  viewroot.findViewById(R.id.progress_circle_text3);

        //TextView txt9 = (TextView)  viewroot.findViewById(R.id.textView32);
        TextView txt10 = (TextView)  viewroot.findViewById(R.id.textView6);
        TextView  progressingTextView1 = (TextView) viewroot.findViewById(R.id.progress_circle_text1);

        txt1.setTypeface(tf);
        txt2.setTypeface(tf);
        txt3.setTypeface(tf);
        txt4.setTypeface(tf);
        txt5.setTypeface(tf1);
        txt7.setTypeface(tf1);
        txt11.setTypeface(tf3);

        progressingTextView1.setTypeface(tf1);

        //txt9.setTypeface(tf1);
        txt10.setTypeface(tf);

        final TextView energy = (TextView)  viewroot.findViewById(R.id.progress_circle_text4);
        final TextView notification = (TextView)  viewroot.findViewById(R.id.progress_circle_text11);
        final TextView power = (TextView)  viewroot.findViewById(R.id.textView);
        final TextView energy2 = (TextView)  viewroot.findViewById(R.id.textView4);
        final TextView CO2 = (TextView)  viewroot.findViewById(R.id.progress_circle_text1);
        final TextView temperature  = (TextView) viewroot.findViewById(R.id.progress_circle_text);

        notification.setTypeface(tf1);
        power.setTypeface(tf1);
        energy.setTypeface(tf1);
        CO2.setTypeface(tf);
        energy.setTypeface(tf1);
        temperature.setTypeface(tf1);
/*
        restInterface.setdmainpage("2311","month","42a594aa09b9d7581a0b74e7ad4940e7", new Callback<Dashboard_webservice>() {
            @Override
            public void success(Dashboard_webservice dashboard, Response response) {
                Log.d(TAG,"Tabka mahemd");
                Log.d(TAG,dashboard.getResults().getCO2().toString());

                notification.append(dashboard.getResults().getNotification().toString());
                power.append(dashboard.getResults().getPower().toString());
                energy.append(dashboard.getResults().getEnergy().toString());
                CO2.append(dashboard.getResults().getCO2().toString());

                temperature.append(dashboard.getResults().getTemperature().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                try {
                    finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });*/






        return viewroot;

    }





    class ListReposTask extends AsyncTask<String,Void,Dashboard_webservice> {
        final ProgressDialog mProgressDialog = ProgressDialog.show(getActivity(), "Chargement","Long operation starts...", true);
       private final String TAG = ListReposTask.class.getSimpleName();
        Thread th;
        @Override
        protected Dashboard_webservice doInBackground(String...params) {

            Results.GithubService githubService = new RestAdapter.Builder()
                    .setEndpoint(Results.GithubService.ENDPOINT)
                    .build()
                    .create(Results.GithubService.class);

            Dashboard_webservice dashboard = githubService.setdmainpage(params[0],params[1],params[2]);
            Log.d(TAG,"Tabka Tabka");
            Log.d(TAG,"Tabka Tabka 2");
            Log.d(TAG,dashboard.getResults().getCO2().toString());
            Log.d(TAG, dashboard.getResults().getEnergy().toString());
            return dashboard;
        }
        @Override
        protected  void onPreExecute(){

             th =new Thread((new Runnable() {
                @Override
                public void run() {
                    mProgressDialog.setMessage("Veuillez Patientez");

                }
            }));
            th.start();
        }
        @Override
        protected void onPostExecute(Dashboard_webservice dashboard) {
            super.onPostExecute(dashboard);
            mProgressDialog.dismiss();
            th.interrupt();

            Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/museosans-500.otf");
            Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Semibold.otf");
            final TextView energy = (TextView)  getView().findViewById(R.id.progress_circle_text4);
            final TextView notification = (TextView)  getView().findViewById(R.id.progress_circle_text11);
            final TextView power = (TextView)  getView().findViewById(R.id.textView);
            final TextView energy2 = (TextView)  getView().findViewById(R.id.textView4);
            final TextView CO2 = (TextView)  getView().findViewById(R.id.progress_circle_text1);
            final TextView temperature  = (TextView) getView().findViewById(R.id.progress_circle_text);

            CO2.setTypeface(tf1);



            notification.append(dashboard.getResults().getNotification().toString());
            power.append(dashboard.getResults().getPower().toString());
            energy.append(dashboard.getResults().getEnergy().toString());
            CO2.append(dashboard.getResults().getCO2().toString());

            temperature.append(dashboard.getResults().getTemperature().toString());
            CircularProgressBar circularProgressBar = (CircularProgressBar)getView().findViewById(R.id.cpb1);


            double energyvalue =  dashboard.getResults().getEnergy() ;

            float energyfloat = (float) energyvalue ;

            int animationDuration = 2500; // 2500ms = 2,5s
            circularProgressBar.setProgressWithAnimation(energyfloat, animationDuration);

            //intent2.putExtra(nom_str, box.getBoxName());


            //affichage des résultats
        }
    }
    }











   

