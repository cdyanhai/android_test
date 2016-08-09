package com.example.yanxiaoyong.myapplication.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yanxiaoyong.myapplication.R;

import java.util.List;

/**
 * Created by yanxiaoyong on 2016/8/9.
 */
public  class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>  implements View.OnClickListener
{
    private List<String> mDatas;

    public HomeAdapter(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //define interface
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
        holder.itemView.setTag(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.id_num);
        }
    }

    public  void addItem(String data, int position){
        mDatas.add(position, data);
        notifyItemInserted(position);
    }

    public void delItem(String data){
        int position=mDatas.indexOf(data);
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}
