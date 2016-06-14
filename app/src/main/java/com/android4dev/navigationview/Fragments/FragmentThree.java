package com.android4dev.navigationview.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android4dev.navigationview.CustomDatePicker;
//import com.android4dev.navigationview.Datamanagers.Result_plot;
import com.android4dev.navigationview.Datamanagers.Result_plot;
import com.android4dev.navigationview.Datamanagers.Results;
import com.android4dev.navigationview.Prediction;
import com.android4dev.navigationview.R;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.RestAdapter;

import static com.android4dev.navigationview.R.*;

public class FragmentThree extends Fragment implements SeekBar.OnSeekBarChangeListener, OnChartValueSelectedListener {


    private LineChart[] mCharts = new LineChart[4];
    private Arrays mMonths;
    private Typeface mTf;
    TextView txt1 ,txt2,txt3,txt4 ,txt5 ;
    Button bouton ;


    private LineChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;

    public static Fragment newInstance(Context context) {
        FragmentTwo f = new FragmentTwo();



        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(layout.fragment_three, null);


  /*tvX = (TextView) root.findViewById(R.id.tvXMax);
  tvY = (TextView) root.findViewById(R.id.tvYMax);
  mSeekBarX = (SeekBar) root.findViewById(R.id.seekBar1);
  mSeekBarY = (SeekBar) root.findViewById(R.id.seekBar2);*/

  /*mSeekBarX.setProgress(45);
  mSeekBarY.setProgress(100);

  mSeekBarY.setOnSeekBarChangeListener(this);
  mSeekBarX.setOnSeekBarChangeListener(this);*/

       /* mChart = (LineChart) root.findViewById(R.id.chart1);
        // mChart.setOnChartValueSelectedListener(this);

        // no description text
        mChart.setDescription("test");
        mChart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable touch gestures
        mChart.setTouchEnabled(true);

        mChart.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.animateX(2500, Easing.EasingOption.EaseInOutQuart);
        mChart.setHighlightPerDragEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(true);

        // set an alternative background color
        mChart.setBackgroundColor(Color.WHITE);

        // add data
        setData(20, 30);

        mChart.animateX(2500);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Regular.otf");

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        // modify the legend ...
        // l.setPosition(LegendPosition.LEFT_OF_CHART);
        l.setForm(Legend.LegendForm.LINE);
        l.setTypeface(tf);
        l.setTextSize(11f);
        l.setTextColor(Color.WHITE);
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
//        l.setYOffset(11f);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(tf);
        xAxis.setTextSize(12f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setSpaceBetweenLabels(1);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTypeface(tf);
        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
        leftAxis.setAxisMaxValue(200f);
        leftAxis.setAxisMinValue(0f);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setTypeface(tf);
        rightAxis.setTextColor(Color.RED);
        rightAxis.setAxisMaxValue(900);
        rightAxis.setAxisMinValue(-200);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);*/

        bouton = (Button) root.findViewById(R.id.button);

        Results.GithubService githubService = new RestAdapter.Builder()
                .setEndpoint(Results.GithubService.ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(Results.GithubService.class);



        new ListReposTask().execute(String.valueOf(120268),"2016-05-16");

        return root ;
    }


    class ListReposTask extends AsyncTask<String, Void, Prediction> {
        private List<Result_plot> results = new ArrayList<Result_plot>();
        private final String TAG = ListReposTask.class.getSimpleName();
        Thread th;
        @Override
        protected Prediction doInBackground(String... params) {

            Results.GithubService githubService = new RestAdapter.Builder()
                    .setEndpoint(Results.GithubService.ENDPOINT)
                    .build()
                    .create(Results.GithubService.class);

            Prediction predictionplot = githubService.getplot(params[0],params[1]);
            Log.d(TAG,"iheb chifco success");
            Log.d(TAG,"smartlife webservice getplot success");
            // Log.d(TAG,smartcontrol.getErrors().toString());
            //Log.d(TAG, smartcontrol.getresults().toString());

            return predictionplot;
        }
        @Override
        protected  void onPreExecute(){


        }
        @Override
        protected void onPostExecute(Prediction predictionplot) {
            super.onPostExecute(predictionplot);






            //affichage des résultats
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // mChart.setOnChartValueSelectedListener(this);

        // no description text


        bouton = (Button) getView().findViewById(R.id.button);
            // mChart.getCurrentFocus();
        final Dialog dial =new Dialog(getActivity());
        //dial.getCurrentFocus();

        Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(),"Fonts/museosans-500.otf");
        Typeface tf3 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Roboto-Bold.ttf") ;

        bouton.setTypeface(typeFace);
//        int Date =date.getMonth();
        //    int day = date.getDayOfMonth();
        //      int year  = date.getYear();


        dial.requestWindowFeature(Window.FEATURE_NO_TITLE);


        dial.setContentView(R.layout.popup_layout);





        final TextView tv = (TextView) dial.findViewById(R.id.tv);
        final TextView tv1 = (TextView) dial.findViewById(R.id.tv1);
        final TextView tv2 = (TextView) dial.findViewById(R.id.tv3);
        final  Button bt1 = (Button)  dial.findViewById(R.id.button1);
        final  Button bt2 = (Button)  dial.findViewById(R.id.button2);
        Button bt3 = (Button)  getView().findViewById(R.id.button);

        final Spinner spinner1 = (Spinner) dial.findViewById(R.id.planets_spinner1);
        final Spinner spinner2 = (Spinner) dial.findViewById(R.id.planets_spinner2);
        //select de sqlite



        //spinner1.setTypeface(typeFace);
        tv.setTypeface(tf3);
        bt1.setTypeface(tf3);
        bt2.setTypeface(tf3);
        bt3.setTypeface(typeFace);
        tv1.setTypeface(tf3);
        tv2.setTypeface(tf3);

      /* String select_Equipement=" select * from Equipement where condition ";
        Cursor c = database.rawQuery(select_Equipement, null);
        c.moveToFirst();
while(c.moveToNext()){
    String equipement = c.getString(3);

}
c.close();*/
        List List_spinner1 = new ArrayList();
        List_spinner1.add("TV");
        List_spinner1.add("Climatiseur");
        List_spinner1.add("PC");
        List_spinner1.add("M.Laver");
        List_spinner1.add("Capteur.Salon");
        List_spinner1.add("Capteur.Cuisine");
        List_spinner1.add("Capteur.Chambre");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, List_spinner1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(adapter);
        //select de sqlite avec jointure
        List List_spinner2 = new ArrayList();
        List_spinner2.add("Consomation");
        List_spinner2.add("Temperature");
        List_spinner2.add("luminosité");
        List_spinner2.add("Etat On/Off");
        List_spinner2.add("Humidité");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, List_spinner2);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        dial.show();

        Button button_confirmer =(Button) dial.findViewById(R.id.button1);
        Button button_annuler =(Button) dial.findViewById(R.id.button2);
        dial.show();

        button_confirmer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CustomDatePicker date;
                date = (CustomDatePicker) dial.findViewById(R.id.datePicker);



                dial.show();


                String equipement =spinner1.getSelectedItem().toString();
                String PropertiName =spinner2.getSelectedItem().toString();
                // select from DataBase
                //retour vers le main

                mChart = (LineChart) getView().findViewById(R.id.chart);
               // mChart.setOnChartValueSelectedListener(this);
                mChart.setDescription("Prévision");
                mChart.setNoDataTextDescription("You need to provide data for the chart.");


                // enable touch gestures
                mChart.setTouchEnabled(true);

                mChart.setDragDecelerationFrictionCoef(0.9f);



                // enable scaling and dragging
                mChart.setDragEnabled(true);
                mChart.setScaleEnabled(true);
                mChart.setDrawGridBackground(false);
                mChart.animateX(2500, Easing.EasingOption.EaseInOutQuart);
                mChart.setHighlightPerDragEnabled(true);

                // if disabled, scaling can be done on x- and y-axis separately
                mChart.setPinchZoom(true);

                // set an alternative background color
                mChart.setBackgroundColor(Color.WHITE);

                // add data
                setData(24, 30);

                mChart.animateX(2500);

                Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Regular.otf");

                // get the legend (only possible after setting data)
                Legend l = mChart.getLegend();

                // modify the legend ...
                // l.setPosition(LegendPosition.LEFT_OF_CHART);
                l.setForm(Legend.LegendForm.LINE);
                l.setTypeface(tf);
                l.setTextSize(11f);
                l.setTextColor(color.blue);
                l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
//        l.setYOffset(11f);

                XAxis xAxis = mChart.getXAxis();
                xAxis.setTypeface(tf);
                xAxis.setTextSize(12f);
                xAxis.setTextColor(Color.WHITE);
                xAxis.setDrawGridLines(false);
                xAxis.setDrawAxisLine(false);
                xAxis.setSpaceBetweenLabels(1);

                YAxis leftAxis = mChart.getAxisLeft();
                leftAxis.setTypeface(tf);
                leftAxis.setTextColor(ColorTemplate.getHoloBlue());
                leftAxis.setAxisMaxValue(1300f);
                leftAxis.setAxisMinValue(0f);
                leftAxis.setDrawGridLines(true);
                leftAxis.setGranularityEnabled(true);

                YAxis rightAxis = mChart.getAxisRight();
                rightAxis.setTypeface(tf);
                rightAxis.setTextColor(Color.RED);
                rightAxis.setAxisMaxValue(250);
                rightAxis.setAxisMinValue(-200);
                rightAxis.setDrawGridLines(false);
                rightAxis.setDrawZeroLine(false);
                rightAxis.setGranularityEnabled(false);
                mChart.getData().setHighlightEnabled(mChart.getData().isHighlightEnabled());
                dial.dismiss();
            }
        });
        button_annuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //retour vers le main
                dial.cancel();

            }
        });
        bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //retour vers le main
                dial.show();

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.line, menu);
        super.onCreateOptionsMenu(menu,inflater);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionToggleValues: {
                List<ILineDataSet> sets = mChart.getData()
                        .getDataSets();

                for (ILineDataSet iSet : sets) {

                    LineDataSet set = (LineDataSet) iSet;
                    set.setDrawValues(!set.isDrawValuesEnabled());
                }

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleHighlight: {
                if (mChart.getData() != null) {
                    mChart.getData().setHighlightEnabled(!mChart.getData().isHighlightEnabled());
                    mChart.invalidate();
                }
                break;
            }
            case R.id.actionToggleFilled: {

                List<ILineDataSet> sets = mChart.getData()
                        .getDataSets();

                for (ILineDataSet iSet : sets) {

                    LineDataSet set = (LineDataSet) iSet;
                    if (set.isDrawFilledEnabled())
                        set.setDrawFilled(false);
                    else
                        set.setDrawFilled(true);
                }
                mChart.invalidate();
                break;
            }
            case R.id.actionToggleCircles: {
                List<ILineDataSet> sets = mChart.getData()
                        .getDataSets();

                for (ILineDataSet iSet : sets) {

                    LineDataSet set = (LineDataSet) iSet;
                    if (set.isDrawCirclesEnabled())
                        set.setDrawCircles(false);
                    else
                        set.setDrawCircles(true);
                }
                mChart.invalidate();
                break;
            }



            case R.id.actionTogglePinch: {
                if (mChart.isPinchZoomEnabled())
                    mChart.setPinchZoom(false);
                else
                    mChart.setPinchZoom(true);

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleAutoScaleMinMax: {
                mChart.setAutoScaleMinMaxEnabled(!mChart.isAutoScaleMinMaxEnabled());
                mChart.notifyDataSetChanged();
                break;
            }
            case R.id.animateX: {
                mChart.animateX(3000);
                break;
            }
            case R.id.animateY: {
                mChart.animateY(3000);
                break;
            }
            case R.id.animateXY: {
                mChart.animateXY(3000, 3000);
                break;
            }

            case R.id.actionSave: {
                if (mChart.saveToPath("title" + System.currentTimeMillis(), "")) {
                    Toast.makeText(getActivity().getApplicationContext(), "Saving SUCCESSFUL!",
                            Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity().getApplicationContext(), "Saving FAILED!", Toast.LENGTH_SHORT)
                            .show();

                // mChart.saveToGallery("title"+System.currentTimeMillis())
                break;
            }
        }
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        tvX.setText("" + (mSeekBarX.getProgress() + 1));
        tvY.setText("" + (mSeekBarY.getProgress()));

        setData(mSeekBarX.getProgress() + 1, mSeekBarY.getProgress());

        // redraw
        mChart.invalidate();
    }

    private void setData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add((i) + "");
        }

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float mult = range / 2f;
            float val = (float) (Math.random() ) *1200;// + (float)
            // ((mult *
            // 0.1) / 10);
            yVals1.add(new Entry(val, i));
        }

        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float mult = range;
            float val = (float) (Math.random() * mult) + 450;// + (float)
            // ((mult *
            // 0.1) / 10);
            yVals2.add(new Entry(val, i));
        }

        LineDataSet set1, set2;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet)mChart.getData().getDataSetByIndex(0);
            set2 = (LineDataSet)mChart.getData().getDataSetByIndex(1);


            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(yVals1, "Power consumption");

            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            //set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
            //set1.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[2]);
            set1.setLineWidth(2.5f);
            set1.setCircleRadius(4.5f);
            set1.setFillAlpha(65);
            set1.setDrawFilled(true);
            set1.setDrawValues(true);
            //set1.setFillColor(ColorTemplate.VORDIPLOM_COLORS[2]);
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            //set1.setDrawCircleHole(false);
            //set1.setFillFormatter(new MyFillFormatter(0f));
            //set1.setDrawHorizontalHighlightIndicator(false);
            //set1.setVisible(false);
            //set1.setCircleHoleColor(Color.WHITE);

            // create a dataset and give it a type
            //set2 = new LineDataSet(yVals2, "Humidité");
            //set2.setAxisDependency(YAxis.AxisDependency.RIGHT);
            //set2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
           // set2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
           // set2.setLineWidth(2.5f);
           // set2.setCircleRadius(4.5f);
           // set2.setFillAlpha(65);
           // set2.setFillColor(ColorTemplate.VORDIPLOM_COLORS[0]);
            //set2.setDrawCircleHole(false);
           // set2.setDrawFilled(true);
           // set2.setDrawValues(true);
           // set2.setHighLightColor(Color.rgb(244, 117, 117));
            //set2.setFillFormatter(new MyFillFormatter(900f));

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
           // dataSets.add(set2);
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(xVals, dataSets);
            data.setValueTextColor(color.blue);
            data.setValueTextSize(9f);

            // set data
            mChart.setData(data);
            mChart.setOnChartValueSelectedListener(this);
        }
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        Log.i("Entry selected", e.toString());

        mChart.centerViewToAnimated(e.getXIndex(), e.getVal(), mChart.getData().getDataSetByIndex(dataSetIndex).getAxisDependency(), 500);
        mChart.zoomAndCenterAnimated(2.5f, 2.5f, e.getXIndex(), e.getVal(), mChart.getData().getDataSetByIndex(dataSetIndex).getAxisDependency(), 1000);
        mChart.zoomAndCenterAnimated(1.8f, 1.8f, e.getXIndex(), e.getVal(), mChart.getData().getDataSetByIndex(dataSetIndex).getAxisDependency(), 1000);
    }

    @Override
    public void onNothingSelected() {
        Log.i("Nothing selected", "Nothing selected.");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }




}