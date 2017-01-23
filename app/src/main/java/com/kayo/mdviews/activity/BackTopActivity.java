package com.kayo.mdviews.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kayo.mdviews.R;
import com.kayo.mdviews.base.BaseActivity;
import com.kayo.mdviews.manager.RecyclerViewManager;

import static android.support.design.R.styleable.ActionBarLayout;

/**
 * Created by shilei on 17/1/23.
 * <pre>
 *
 * </pre>
 */

public class BackTopActivity extends BaseActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    FloatingActionButton goTop;

    @Override
    public int contentView() {
        return R.layout.activity_back_top;
    }

    @Override
    public void findViews() {
        goTop = (FloatingActionButton) findViewById(R.id.go_top);
        goTop.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    @Override
    public void configToolBar(Toolbar toolbar) {
        super.configToolBar(toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("回顶主页");
    }

    @Override
    public void initData(Intent intent) {

        RecyclerViewManager manager = RecyclerViewManager.getManager();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        manager.bindRecyclerView(recyclerView);
        manager.bindDefaultDatas(30);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_top:
                recyclerView.smoothScrollToPosition(0);
                AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
                appBarLayout.setVerticalScrollbarPosition(0);
                break;
        }
    }
}
