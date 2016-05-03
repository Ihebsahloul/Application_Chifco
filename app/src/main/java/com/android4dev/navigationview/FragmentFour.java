package com.android4dev.navigationview;

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

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.w3c.dom.Text;

import java.util.ArrayList;
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
    private List<String> mAppList =  new ArrayList<String>();
    private AppAdapter mAdapter;
    private SwipeMenuListView mListView;
    private View rootView = null;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = (View) inflater.inflate(R.layout.fragment_four, null);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Regular.otf");
        Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Semibold.otf");

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

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Regular.otf");
        Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/museosans-500.otf");


        SwipeMenuListView mListView = (SwipeMenuListView) getActivity().findViewById(R.id.listView);
        TextView title = (TextView) getActivity().findViewById((R.id.title))  ;
        title.setTypeface(tf1) ;


        mAppList =  new ArrayList<String>();
        mAdapter = new AppAdapter();
        mListView.setAdapter(mAdapter);




        mAppList.add("Prise-TV");
        mAppList.add("Prise-PC");
        mAppList.add("Prise-Climatiseur");
       // mAppList.add("Prise-Hotte");
        mAppList.add("Prise-Réfrigérateur");
        mAppList.add("Prise-M.Laver");
        mAppList.add("Prise-Cafétière");
       // mAppList.add("item 8");
        //mAppList.add("item 9");
       // mAppList.add("item 10");





            mAdapter = new AppAdapter();
            mListView.setAdapter(mAdapter);

        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getActivity());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Ouvrir");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getActivity());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.trash);
                // add to menu
                menu.addMenuItem(deleteItem);

            }
        };
        // set creator
        mListView.setMenuCreator(creator);

        // step 2. listener item click event
        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                String item = mAppList.get(position);
                switch (index) {
                    case 0:
                        // open
                        //open(item);
                        break;
                    case 1:
                        // delete
//					delete(item);
                        mAppList.remove(position);
                        mAdapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });

        // set SwipeListener
        mListView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {

            @Override
            public void onSwipeStart(int position) {
                // swipe start
            }

            @Override
            public void onSwipeEnd(int position) {
                // swipe end
            }
        });

        // set MenuStateChangeListener
        mListView.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {
            }

            @Override
            public void onMenuClose(int position) {
            }
        });

        // other setting
//		listView.setCloseInterpolator(new BounceInterpolator());

        // test item long click
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(getActivity(), position + " long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
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

    private void delete(String item) {
        // delete app
        try {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.fromParts("package", item, null));
            startActivity(intent);
        } catch (Exception e) {
        }
    }


    private void open(String item) {
        // open app
        Intent resolveIntent = new Intent(Intent.ACTION_GET_CONTENT, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(item);
        List<ResolveInfo> resolveInfoList = getActivity().getPackageManager()
                .queryIntentActivities(resolveIntent, 0);
        if (resolveInfoList != null && resolveInfoList.size() > 0) {
            ResolveInfo resolveInfo = resolveInfoList.get(0);
            String activityPackageName = resolveInfo.activityInfo.packageName;
            String className = resolveInfo.activityInfo.name;

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            ComponentName componentName = new ComponentName(
                    activityPackageName, className);

            intent.setComponent(componentName);
            startActivity(intent);
        }
    }

    class AppAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mAppList.size();
        }

        @Override
        public String getItem(int position) {
            return mAppList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getActivity(),
                        R.layout.item_list_app, null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            String item = getItem(position);


           // holder.iv_icon1.setImageDrawable(item.loadIcon(getActivity().getPackageManager()));
            //holder.tv_name.setText(item.loadLabel(getActivity().getPackageManager()));

            //holder.iv_icon1.setImageDrawable(item.loadIcon(getPackageManager()));
            holder.tv_name.setText(item);
            holder.iv_icon1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SimpleActivity.this, "iv_icon_click", Toast.LENGTH_SHORT).show();



                }
            });



            holder.tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SimpleActivity.this,"iv_icon_click",Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }

        class ViewHolder {
            ImageView iv_icon1 ,iv_icon2 ,  iv_icon3 ,  iv_icon4 , iv_icon5 ,   iv_icon6  ;
            TextView tv_name;

            public ViewHolder(View view) {



                iv_icon1 = (ImageView) view.findViewById(R.id.iv_icon1);
               /* iv_icon2 = (ImageView) view.findViewById(R.id.iv_icon2);
                iv_icon3 = (ImageView) view.findViewById(R.id.iv_icon3);
                iv_icon4 = (ImageView) view.findViewById(R.id.iv_icon4);
                iv_icon5 = (ImageView) view.findViewById(R.id.iv_icon5);
                iv_icon6 = (ImageView) view.findViewById(R.id.iv_icon6);*/
               // iv_icon = (ImageView) view.findViewById(R.id.iv_icon);


                tv_name = (TextView) view.findViewById(R.id.tv_name);

                Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/MyriadPro-Regular.otf");
                Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/museosans-500.otf");
                tv_name.setTypeface(tf1);
                view.setTag(this);
            }
        }

        // @Override
        public boolean getSwipEnableByPosition(int position) {
            if(position % 2 == 0){
                return false;
            }
            return true;
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_left) {
            mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
            return true;
        }
        if (id == R.id.action_right) {
            mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

