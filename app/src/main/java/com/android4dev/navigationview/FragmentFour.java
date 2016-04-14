package com.android4dev.navigationview;

/**
 * Created by ihebs on 14/04/2016.
 */



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentFour extends Fragment {

    public static Fragment newInstance(Context context) {
        FragmentThree f = new FragmentThree();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_four, null);
        return root;
    }

}