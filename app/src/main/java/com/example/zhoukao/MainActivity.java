package com.example.zhoukao;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb_toolbar;
    private ListView lv_listView;
    private FrameLayout fl_fragment;
    private FragmentTransaction fragmentTransaction;
    private android.support.v4.app.FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
        initSetFragment();
        initSetListView();
        initOnClickView();



    }

    private void initOnClickView() {
        lv_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        FragmentTransaction fragmentTransaction0 = supportFragmentManager.beginTransaction();
                        fragmentTransaction0.replace(R.id.fl_fragment,new AFragment()).commit();
                        break;
                    case 1:
                        FragmentTransaction fragmentTransaction1 = supportFragmentManager.beginTransaction();
                        fragmentTransaction1.replace(R.id.fl_fragment,new BFragment()).commit();
                        break;
                }
            }
        });
    }

    private void initSetFragment() {
        supportFragmentManager = getSupportFragmentManager();
        fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_fragment,new AFragment());
        fragmentTransaction.commit();
    }

    private void initSetListView() {
        ArrayList<String> list=new ArrayList<>();
        list.add("首页");
        list.add("个人");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,list);
        lv_listView.setAdapter(adapter);
    }

    private void initDate() {

        tb_toolbar.setTitle("网页");
       // setSupportActionBar(tb_toolbar);
        registerForContextMenu(tb_toolbar);
//        tb_toolbar.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                PopupWindow popupWindow=new PopupWindow(this);
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initView() {
        tb_toolbar = (Toolbar) findViewById(R.id.tb_toolbar);
        lv_listView = (ListView) findViewById(R.id.lv_listView);
        fl_fragment = (FrameLayout) findViewById(R.id.fl_fragment);
    }
}