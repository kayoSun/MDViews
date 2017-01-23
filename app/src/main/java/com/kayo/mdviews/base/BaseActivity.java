package com.kayo.mdviews.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.kayo.mdviews.R;

/**
 * Created by shilei on 17/1/23.
 * <pre>
 *
 * </pre>
 */

public abstract class BaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (contentView() != 0 ){
            setContentView(contentView());
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            if (toolbar != null){
                this.toolbar = toolbar;
                setSupportActionBar(toolbar);
                configToolBar(toolbar);
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null){
                configActionBar(supportActionBar);
            }
            findViews();
            initData(getIntent());
        }
    }

    @LayoutRes
    public abstract int contentView();
    public abstract void findViews();
    public abstract void initData(Intent intent);
    public void configToolBar(Toolbar toolbar){}
    public void configActionBar(ActionBar actionBar){}

    public Toolbar getToolbar() {
        return toolbar;
    }
}
