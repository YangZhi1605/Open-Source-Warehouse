package com.test.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RcyAdapter extends RecyclerView.Adapter<RcyAdapter.MyHolder> {

    public Context context;
    private List<Msg> msgList;

    public RcyAdapter(Context context, List<Msg> msgList){
        this.context = context;
        this.msgList = msgList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.item_msg,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv_name.setText(msgList.get(position).name);
        holder.tv_content.setText(msgList.get(position).msg);
        holder.iv_img.setImageResource(msgList.get(position).img);
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView tv_name,tv_content;
        ImageView iv_img;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_content = itemView.findViewById(R.id.tv_content);
            iv_img = itemView.findViewById(R.id.iv_img);
        }
    }
}
