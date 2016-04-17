package com.android4dev.navigationview;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.txusballesteros.widgets.FitChart;
import com.txusballesteros.widgets.FitChartValue;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by Admin on 04-06-2015.
 */
public class ContentFragment extends Fragment {


    ProgressBar myprogressBar;
    TextView textView11 ;
    ProgressBar myprogressBar1 ;
    TextView progressingTextView, progressingTextView1;
    Handler progressHandler = new Handler();
    int i = 0;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {





        RelativeLayout viewroot  = ( RelativeLayout) inflater.inflate(R.layout.content_fragment, container, false);


        progressingTextView = (TextView) viewroot.findViewById(R.id.progress_circle_text);
        progressingTextView1 = (TextView) viewroot.findViewById(R.id.progress_circle_text1);
        CircularProgressBar circularProgressBar = (CircularProgressBar)viewroot.findViewById(R.id.cpb1);


        int animationDuration = 2500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(80, animationDuration);




        return viewroot;

    }


    }











   

