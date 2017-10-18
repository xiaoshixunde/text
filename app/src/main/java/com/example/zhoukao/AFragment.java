package com.example.zhoukao;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    private RecyclerView rv_RecyclerAFragment;
    private final String URL="http://172.16.45.42:8080/item/data.json";
    private Handler handler=new Handler(){

        private MyInFo.StudentsBean card;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    //解析
                    String obj = (String) msg.obj;
                    Gson gson=new Gson();
                    MyInFo myInFo = gson.fromJson(obj, MyInFo.class);
                    card = myInFo.getStudents();
                    initAdapter();
                    break;
            }
        }
    };
    private List<MyInFo.StudentsBean> card;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initDate();
        return inflate;
    }

    private void initAdapter() {
        //显示瀑布流
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_RecyclerAFragment.setLayoutManager(manager);

        //创建适配器
        MyRecyclerAdapter adapter=new MyRecyclerAdapter(card,getActivity());
        rv_RecyclerAFragment.setAdapter(adapter);
    }

    private void initDate() {
        //开启一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient http=new OkHttpClient();
                Request build = new Request.Builder().url(URL).build();
                try {
                    Response execute = http.newCall(build).execute();
                    String string = execute.body().string();
                    handler.obtainMessage(100,string).sendToTarget();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initView(View inflate) {
        rv_RecyclerAFragment = (RecyclerView) inflate.findViewById(R.id.recyclerview);
    }
}