package com.android4dev.navigationview.Fragments;

/**
 * Created by ihebs on 14/04/2016.*/
 import android.app.Dialog;
 import android.app.ProgressDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.graphics.Typeface;
 import android.os.AsyncTask;
 import android.os.Bundle;

 import com.android4dev.navigationview.Actions;
 import com.android4dev.navigationview.Adapters.SwipeRecyclerViewAdapter;
 import com.android4dev.navigationview.Datamanagers.Action ;

 import android.support.annotation.Nullable;
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

 import com.android4dev.navigationview.Datamanagers.Dashboard_webservice;
 import com.android4dev.navigationview.Datamanagers.Results;
 import com.android4dev.navigationview.DividerItemDecoration;
 import com.android4dev.navigationview.R;
 import com.android4dev.navigationview.Result_Action;
 import com.daimajia.swipe.util.Attributes;
 import com.github.mikephil.charting.charts.LineChart;
 import com.mikhaellopez.circularprogressbar.CircularProgressBar;

 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;

 import retrofit.RestAdapter;

 import static com.android4dev.navigationview.R.*;

public class FragmentTwo extends Fragment{
 List<Result_Action> liste = new ArrayList<Result_Action>();

 private LineChart[] mCharts = new LineChart[4];
 private Arrays mMonths;
 private Typeface mTf;
 TextView txt1 ,txt2,txt3,txt4 ,txt5 ;
 private final String TAG = ListReposTask.class.getSimpleName();

 private LineChart mChart;
 private SeekBar mSeekBarX, mSeekBarY;
 private TextView tvX, tvY;
// RecyclerView mRecyclerView;
 private ArrayList<Action> mDataSet ;

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

  Results.GithubService githubService = new RestAdapter.Builder()
          .setEndpoint(Results.GithubService.ENDPOINT)
          .setLogLevel(RestAdapter.LogLevel.FULL)
          .build()
          .create(Results.GithubService.class);

  new ListReposTask().execute("120268","2016-05-16");
  return root ;

 }
 @Override
 public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
  super.onViewCreated(view, savedInstanceState);


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


  final FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

  fab.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
    comfirm();
   }
  });


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



  ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

  mRecyclerView.setAdapter(mAdapter);

  // Scroll Listeners
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

   mDataSet.add(new Action("Action " , "Date" ));


  for(Result_Action ac :  liste ){
   //mDataSet.add(new Action( ac.getEquipementID().toString(),ac.getDate().toString() ));
   Log.d(TAG,"message: "+ac.getEquipementID().toString());
   mDataSet.add(new Action(ac.getEquipementID().toString()+" Etat: "+ac.getValue().toString(),ac.getDate().toString()));
   Log.d(TAG,ac.getDate().toString());
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








 class ListReposTask extends AsyncTask<String,Void,Actions> {
  final ProgressDialog mProgressDialog = ProgressDialog.show(getActivity(), "Chargement","Long operation starts...", true);
  private final String TAG = ListReposTask.class.getSimpleName();
  Thread th;
  @Override
  protected Actions doInBackground(String...params) {

   Results.GithubService githubService = new RestAdapter.Builder()
           .setEndpoint(Results.GithubService.ENDPOINT)
           .build()
           .create(Results.GithubService.class);

   Actions result_action = githubService.GetEquipmentAction(params[0],params[1]);
    liste =result_action.getResults();
  // for(Result_Action ac :  liste ){Log.d(TAG,ac.getDate());}
   Log.d(TAG,"Tabka Tabka");
  return result_action;
 }
  @Override
  protected  void onPreExecute(){

   th =new Thread((new Runnable() {
    @Override
    public void run() {
     //mProgressDialog.setMessage("Veuillez Patientez");

    }
   }));
   th.start();
  }
  @Override
  protected void onPostExecute(Actions actions) {
   super.onPostExecute(actions);
   mProgressDialog.dismiss();
   th.interrupt();

   Log.d(TAG,"Tabka Tabka");
   for(Result_Action ac :  liste ){
    //mDataSet.add(new Action( ac.getEquipementID().toString(),ac.getDate().toString() ));
    Log.d(TAG,"message: "+ac.getEquipementID().toString());
    mDataSet.add(new Action(ac.getEquipementID().toString(),ac.getDate().toString()));
    Log.d(TAG,ac.getDate().toString());
   }
   /// ici insertion des données!!



 }

 }
}







