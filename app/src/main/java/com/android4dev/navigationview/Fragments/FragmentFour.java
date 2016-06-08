package com.android4dev.navigationview.Fragments;

/**
 * Created by ihebs on 14/04/2016.
 */



import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android4dev.navigationview.R;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
//import com.daimajia.swipe.util.Attributes;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
//import com.shamanland.fab.FloatingActionButton;
//import com.shamanland.fab.ShowHideOnScroll;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentFour extends Fragment {
/*
    ArrayList X,Y ;

    public static Fragment newInstance(Context context) {
        FragmentThree f = new FragmentThree();

        return f;
    }*/

    public FragmentFour() {
    }


    //private View  root = null;
   // private List<String> mAppList =  new ArrayList<String>();

   // private SwipeMenuListView mListView;
    private View rootView = null;
    private TextView title , desc ;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_four, null);




       // title = (TextView) getActivity().findViewById(R.id.title);
        //desc = (TextView) getActivity().findViewById(R.id.title1);
        /*Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Regular.otf");
        Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Semibold.otf");
        Typeface tf2 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/OpenSans-Regular.ttf");
        Typeface tf3 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/OpenSans-Bold.ttf") ;*/








     /*   BarChart chart = (BarChart) root.findViewById(R.id.chart);

        X = getXAxisValues() ;
        Y = getDataSet() ;

        BarData data = new BarData(X, Y);
        chart.setData(data);
        chart.setDescription("TEST 4");
        chart.animateXY(2000,2000);

        chart.invalidate();
*/

        return rootView ;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        RecyclerView recyclerView ;

       /* Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Regular.otf");
        Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/museosans-500.otf");

        Typeface tf2 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/OpenSans-Regular.ttf");
        Typeface tf3 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/OpenSans-Bold.ttf") ;*/

       // SwipeMenuListView mListView = (SwipeMenuListView) getActivity().findViewById(R.id.listView);
        //TextView title = (TextView) getActivity().findViewById((R.id.item))  ;
        //TextView title1 = (TextView) getActivity().findViewById((R.id.title))  ;
       // /FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
       // fab.attachToListView(mListView);
        //mListView.setOnTouchListener(new ShowHideOnScroll(fab));
        //mListView.setOnTouchListener(new ShowHideOnScroll(fab, R.anim.custom_show, R.anim.custom_hide));
        //title.setTypeface(tf1) ;


       // title1 = (TextView) getActivity().findViewById(R.id.title);
       // desc = (TextView) getActivity().findViewById(R.id.title1);

       // title.setTypeface(tf3);
       // desc.setTypeface(tf2) ;



        // Item Decorator:






        // set SwipeListener


        // set MenuStateChangeListener

        //mListView.bringToFront();

    }

  /*  private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

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
    }*/







    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}

