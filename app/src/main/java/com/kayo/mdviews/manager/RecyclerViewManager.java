package com.kayo.mdviews.manager;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shilei on 17/1/23.
 * <pre>
 *      RecyclerView管理工具类
 * </pre>
 */

public class RecyclerViewManager {

    private static RecyclerViewManager instance;
    private RecyclerView recyclerview;

    private RecyclerViewManager() {
    }

    public static RecyclerViewManager getManager() {
        if (instance == null) {
            synchronized (RecyclerViewManager.class) {
                if (instance == null) {
                    instance = new RecyclerViewManager();
                }
            }
        }
        return instance;
    }

    public void bindRecyclerView(RecyclerView recyclerview){
        this.recyclerview = recyclerview;
    }

    public void bindDefaultDatas(int count){

        List<String> datas = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            datas.add("测试条目 = "+i);
        }
        DefaultAdapter adapter = new DefaultAdapter();
        recyclerview.setAdapter(adapter);
        adapter.setDatas(datas);
    }

    public static class DefaultHolder extends RecyclerView.ViewHolder{

        public DefaultHolder(View itemView) {
            super(itemView);
        }

        public void bindData(String data){
            ((TextView)itemView).setText(data);
        }
    }

    public static class DefaultAdapter extends RecyclerView.Adapter<DefaultHolder>{

        List<String> datas;

        public void setDatas(List<String> datas) {
            this.datas = datas;
            if (datas != null){
                notifyDataSetChanged();
            }
        }

        @Override
        public DefaultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dp2px(parent.getContext(),100));
            TextView view = new TextView(parent.getContext());
            view.setGravity(Gravity.CENTER);
            view.setTextColor(Color.RED);
            view.setLayoutParams(params);
            return new DefaultHolder(view);
        }

        @Override
        public void onBindViewHolder(DefaultHolder holder, int position) {
            holder.bindData(datas.get(position));

        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }

    public static int dp2px(Context context, int dp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

}
