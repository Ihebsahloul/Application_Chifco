package com.android4dev.navigationview;

import android.content.Context;
import android.support.design.widget.*;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ihebs on 11/05/2016.
 */
public class FABScrollBehavior extends android.support.design.widget.FloatingActionButton.Behavior {

    public FABScrollBehavior(Context context, AttributeSet attributeSet){
        super();
    }
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, android.support.design.widget.FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if(dyConsumed > 0 && child.getVisibility() == View.VISIBLE){
            child.hide();
        } else if(dyConsumed < 0 && child.getVisibility() == View.GONE){
            child.show();
        }
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, android.support.design.widget.FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
}