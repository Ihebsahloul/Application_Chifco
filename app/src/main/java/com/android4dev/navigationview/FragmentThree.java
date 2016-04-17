package com.android4dev.navigationview;

/**
 * Created by ihebs on 14/04/2016.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class FragmentThree extends Fragment {


    CircularProgressBar cpb1 ;

    public static Fragment newInstance(Context context) {
        FragmentThree f = new FragmentThree();

        return f;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_three, null);



        CircularProgressBar circularProgressBar = (CircularProgressBar)root.findViewById(R.id.cpb1);


        int animationDuration = 2500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(65, animationDuration); // Default duration = 1500ms
        return root;
    }

}