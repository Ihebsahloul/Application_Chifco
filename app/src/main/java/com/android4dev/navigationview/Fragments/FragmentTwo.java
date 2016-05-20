package com.android4dev.navigationview.Fragments;

/**
 * Created by ihebs on 14/04/2016.*/
 import android.app.Dialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.graphics.Typeface;
 import android.os.Bundle;

 import com.android4dev.navigationview.Adapters.SwipeRecyclerViewAdapter;
 import com.android4dev.navigationview.Datamanagers.Action ;
 import android.support.design.widget.CoordinatorLayout;
 import android.support.design.widget.FloatingActionButton;
 import android.support.v4.app.Fragment;
 import android.support.v4.view.ViewCompat;
 import android.support.v7.app.AlertDialog;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.support.v7.widget.Toolbar;
 import android.util.Log;
 import android.view.LayoutInflater;
 import android.view.Menu;
 import android.view.MenuItem;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.SeekBar;
 import android.widget.TextView;
 import android.widget.Toast;

 import com.android4dev.navigationview.DividerItemDecoration;
 import com.android4dev.navigationview.R;
 import com.daimajia.swipe.util.Attributes;
 import com.github.mikephil.charting.charts.LineChart;

 import java.util.ArrayList;
 import java.util.Arrays;

 import static com.android4dev.navigationview.R.*;

public class FragmentTwo extends Fragment{


 private LineChart[] mCharts = new LineChart[4];
 private Arrays mMonths;
 private Typeface mTf;
 TextView txt1 ,txt2,txt3,txt4 ,txt5 ;


 private LineChart mChart;
 private SeekBar mSeekBarX, mSeekBarY;
 private TextView tvX, tvY;
// RecyclerView mRecyclerView;
 private ArrayList<Action> mDataSet;

 private Toolbar toolbar;

 private TextView tvEmptyView;
 private RecyclerView mRecyclerView;

 public static Fragment newInstance(Context context) {
  FragmentTwo f = new FragmentTwo();

  return f;
 }


 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  ViewGroup root = (ViewGroup) inflater.inflate(layout.fragment_two, null);

 /* mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
  final  LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
  //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
  mRecyclerView.setLayoutManager(layoutManager);
  setUpRecyclerView();*/


  //setContentView(layout.swipe);



  return root ;

 }

 @Override
 public void onActivityCreated(Bundle savedInstanceState) {
  // TODO Auto-generated method stub
  super.onActivityCreated(savedInstanceState);

  final Dialog dial =new Dialog(getActivity());
  dial.getCurrentFocus();

  Typeface tf3 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Roboto-Bold.ttf") ;

  toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
  tvEmptyView = (TextView) getActivity().findViewById(R.id.empty_view);
  mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);

  tvEmptyView.setTypeface(tf3);

  // Layout Managers:
  mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

  // Item Decorator:
  mRecyclerView.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider)));
  // mRecyclerView.setItemAnimator(new FadeInLeftAnimator());


  final FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

 // FloatingActionButton myFab = (FloatingActionButton) myView.findViewById(R.id.myFAB);
  fab.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
   comfirm();
   }
  });
  //fab.AttachtoRecyclerView(mRecyclerView);


 // final  FloatingActionButton button = (FloatingActionButton) getActivity().findViewById(R.id.setter);



  mDataSet = new ArrayList<Action>();





  loadData();

  if (mDataSet.isEmpty()) {
   mRecyclerView.setVisibility(View.GONE);
   tvEmptyView.setVisibility(View.VISIBLE);

  } else {
   mRecyclerView.setVisibility(View.VISIBLE);
   tvEmptyView.setVisibility(View.GONE);
  }


  // Creating Adapter object
  SwipeRecyclerViewAdapter mAdapter = new SwipeRecyclerViewAdapter(getActivity(), mDataSet);


  // Setting Mode to Single to reveal bottom View for one item in List
  // Setting Mode to Mutliple to reveal bottom Views for multile items in List
  ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

  mRecyclerView.setAdapter(mAdapter);

        /* Scroll Listeners */
  mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
   @Override
   public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
    super.onScrollStateChanged(recyclerView, newState);
    Log.e("RecyclerView", "onScrollStateChanged");
   }

   @Override
   public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);
   }
  });
 }


 // load initial data
 public void loadData() {

  for (int i = 0; i <= 20; i++) {
   mDataSet.add(new Action("Action " + i, "Date" + i ));

  }


 }


public void comfirm()
{
 new AlertDialog.Builder(getActivity())
         .setTitle("Cofirmation")
         .setMessage("Voulez vous confirmer la liste automatique des tâches ?")
         .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

          public void onClick(DialogInterface dialog, int whichButton) {
           Toast.makeText(getActivity(), "Liste validée", Toast.LENGTH_SHORT).show();
          }})
         .setNegativeButton(android.R.string.no, null).show();
}




 /**
  * We're gonna setup another ItemDecorator that will draw the red background in the empty space while the items are animating to thier new positions
  * after an item is removed.
  */


    // only if animation is in progress


     // some items might be animating down and some items might be animating up to close the gap left by the removed item
     // this is not exclusive, both movement can be happening at the same time
     // to reproduce this leave just enough items so the first one and the last one would be just a little off screen
     // then remove one from the middle

     // find first child with translationY > 0
     // and last one with translationY < 0
     // we're after a rect that is not covered in recycler-view views at this point in time



 /**
  * RecyclerView adapter enabling undo on a swiped away item.
  *///@Override
 public boolean onCreateOptionsMenu(Menu menu) {
  getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
  return true;
 }

 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
  int id = item.getItemId();



  return super.onOptionsItemSelected(item);
 }


 public class FABScrollBehavior extends FloatingActionButton.Behavior {
  @Override
  public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
   super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
   if(dyConsumed > 0 && child.getVisibility() == View.VISIBLE){
    child.hide();
   } else if(dyConsumed < 0 && child.getVisibility() == View.GONE){
    child.show();
   }
  }

  @Override
  public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
   return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
  }
 }


 }







