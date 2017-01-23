package com.kayo.mdviews.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.kayo.mdviews.R;
import com.kayo.mdviews.base.BaseActivity;
import com.kayo.mdviews.manager.RecyclerViewManager;

/**
 * Created by shilei on 17/1/23.
 * <pre>
 *
 * </pre>
 */

public class BottomSheetBehaviorActivity extends BaseActivity implements View.OnClickListener {

    private BottomSheetBehavior<View> bottomSheetBehavior;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    public int contentView() {
        return R.layout.activity_bottom_sheet;
    }

    @Override
    public void findViews() {
        findViewById(R.id.btn_bottom_sheet_control).setOnClickListener(this);
        findViewById(R.id.btn_bottom_dialog_control).setOnClickListener(this);
        View tabViews = findViewById(R.id.tab_layout);
        bottomSheetBehavior = BottomSheetBehavior.from(tabViews);

    }

    @Override
    public void configActionBar(ActionBar actionBar) {
        super.configActionBar(actionBar);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initData(Intent intent) {
        bottomSheetBehavior.setBottomSheetCallback(
                new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                /*
                *  bottomSheet 被操作的View
                *  newState 改变后的新状态
                * */
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                /*
                * bottomSheet 被操作的View
                * slideOffset 状态改变的变化值 范围 0-1
                * */
            }
        });
        createBottomSheetDialog();
    }

    private void createBottomSheetDialog(){
        bottomSheetDialog = new BottomSheetDialog(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutParams(params);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bottomSheetDialog.setContentView(recyclerView);
        RecyclerViewManager.getManager().bindRecyclerView(recyclerView);
        RecyclerViewManager.getManager().bindDefaultDatas(20);
        View viewById = bottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
        final BottomSheetBehavior<View> from = BottomSheetBehavior.from(viewById);
        from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetDialog.dismiss();
                    from.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bottom_sheet_control:
                int state = bottomSheetBehavior.getState();
                if (state == BottomSheetBehavior.STATE_COLLAPSED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                break;
            case R.id.btn_bottom_dialog_control:
                if (bottomSheetDialog.isShowing()){
                    bottomSheetDialog.dismiss();
                }else {
                    bottomSheetDialog.show();
                }

                break;
        }
    }
}
