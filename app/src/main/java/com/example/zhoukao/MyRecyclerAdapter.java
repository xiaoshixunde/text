package com.example.zhoukao;

/**
 * Created by Administrator on 2017/9/15 0015.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyHolder> {

    List<MyInFo.StudentsBean> card;
    Context context;

    public MyRecyclerAdapter(List<MyInFo.StudentsBean> card, Context context) {
        this.card = card;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        MyHolder holder=new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        ViewGroup.LayoutParams layoutParams = holder.linearLayout.getLayoutParams();
        layoutParams.height=new Random().nextInt(300)+100;
        holder.linearLayout.setLayoutParams(layoutParams);

//        holder.key.setText(card.get(position).getKey());
//        holder.value.setText(card.get(position).getValue().get(0));
//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, card.get(position).getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return card.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final TextView key;
        private final TextView value;
        private final LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.Linear);
            key = (TextView) itemView.findViewById(R.id.key_Item);
            value = (TextView) itemView.findViewById(R.id.value_Item);

        }
    }
}