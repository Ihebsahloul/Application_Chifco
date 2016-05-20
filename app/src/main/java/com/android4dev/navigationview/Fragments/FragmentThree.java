package com.android4dev.navigationview.Fragments;

/**
 * Created by ihebs on 14/04/2016.
 */


import android.app.Dialog;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android4dev.navigationview.CustomDatePicker;
import com.android4dev.navigationview.R;
import com.android4dev.navigationview.Helpers.SQLiteHelper;
import com.dacer.androidcharts.LineView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.view.LineChartView;

public class FragmentThree extends Fragment {

    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    CircularProgressBar cpb1 ;
    LineView lineView ;
    TextView tv ;
    ArrayList<ArrayList<String>> dataLists;
    Spinner spinner1 ,spinner2 ;

    ArrayList<String> dataList,strList;
    LineChartView  chart ;
    ChartData data1;
    ColumnChartData clm1 ;
    CustomDatePicker date ;
    Line l1 ;
    ArrayList X ,Y ;

    Button bouton;
    public static Fragment newInstance(Context context) {
        FragmentThree f = new FragmentThree();

        return f;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_three, null);

        X = getXAxisValues() ;
        Y = getDataSet() ;

        LineChart chart = (LineChart) root.findViewById(R.id.chart);
        LineData data = new LineData(X,Y);
        chart.setData(data);
        chart.setDescription("Test");
        chart.animateX(2000,Easing.EasingOption.Linear);
        chart.invalidate();
        chart.setHardwareAccelerationEnabled(true) ;
         bouton = (Button) root.findViewById(R.id.button);
        return root;
    }
    public void CommentsDataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Dialog dial =new Dialog(getActivity());
        dial.getCurrentFocus();

        Typeface typeFace=Typeface.createFromAsset(getActivity().getAssets(),"Fonts/museosans-500.otf");
        Typeface tf3 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Roboto-Bold.ttf") ;


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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, List_spinner1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(adapter);
        //select de sqlite avec jointure
        List List_spinner2 = new ArrayList();
        List_spinner2.add("Temperature");
        List_spinner2.add("Consomation");
        List_spinner2.add("luminosité");
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

    /*LineChartView  chart = (LineChartView) root.findViewById(R.id.chart);
       // chart.setClickablePointRadius(5)


        //LineView lv1 = new LineView(getView().getContext()) ;
        LineView lineView = (LineView)root.findViewById(R.id.line_view);
        lineView.setDrawDotLine(false); //optional
        lineView.setShowPopup(LineView.SHOW_POPUPS_MAXMIN_ONLY); //optional
        lineView.setBottomTextList(strList);
      // lineView.setDataList(dataLists);



        chart.setInteractive(true);

        //Chart.setZoomType();
        //Chart.setContainerScrollEnabled(true, ContainerScrollType type);

        List<PointValue> values = new ArrayList<PointValue>();
        values.add(new PointValue(0, 2));
        values.add(new PointValue(1, 4));
        values.add(new PointValue(2, 3));
        values.add(new PointValue(3, 6));

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(values).setColor(Color.BLUE).setCubic(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        LineChartData data = new LineChartData();



        //data1.setAxisXBottom();
        //clm1.setStacked(true);
        //l1.setStrokeWidth(5);



        data.setLines(lines);


        chart.setLineChartData(data);*/



    private ArrayList<LineDataSet> getDataSet() {
        ArrayList<LineDataSet> dataSets = null;

        ArrayList<Entry> valueSet1 = new ArrayList<>();
        Entry v1e1 = new Entry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        Entry v1e2 = new Entry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        Entry v1e3 = new Entry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        Entry v1e4 = new Entry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        Entry v1e5 = new Entry(90.000f, 4); // May
        valueSet1.add(v1e5);
        Entry v1e6 = new Entry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<Entry> valueSet2 = new ArrayList<>();
        Entry v2e1 = new Entry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        Entry v2e2 = new Entry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        Entry v2e3 = new Entry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        Entry v2e4 = new Entry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        Entry v2e5 = new Entry(20.000f, 4); // May
        valueSet2.add(v2e5);
        Entry v2e6 = new Entry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        LineDataSet barDataSet1 = new LineDataSet(valueSet1, "Brand 1");

        LineDataSet barDataSet2 = new LineDataSet(valueSet2, "Brand 2");

        barDataSet1.setDrawFilled(true);
        barDataSet2.setDrawFilled(true);
        barDataSet1.setDrawCircles(true);
        barDataSet2.setDrawCircles(true);
        barDataSet1.setLineWidth(2.5f);
        barDataSet1.setCircleRadius(4.5f);
        barDataSet1.setHighLightColor(Color.rgb(244, 117, 117));
        barDataSet1.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        barDataSet1.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);

        barDataSet2.setLineWidth(2.5f);
        barDataSet2.setCircleRadius(4.5f);
        barDataSet2.setHighLightColor(Color.rgb(244, 117, 117));
        barDataSet2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        barDataSet2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }


    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;

    }





}