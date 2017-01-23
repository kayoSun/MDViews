package com.kayo.mdviews.base;


import android.content.Intent;
import android.view.View;

import com.kayo.mdviews.R;
import com.kayo.mdviews.activity.BackTopActivity;
import com.kayo.mdviews.activity.BottomSheetBehaviorActivity;
import com.kayo.mdviews.activity.SwipeDismissBehaviorActivity;
import com.kayo.mdviews.activity.ZhihuActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    public int contentView() {
        return R.layout.activity_main;
    }

    @Override
    public void findViews() {
        findViewById(R.id.btn_back_top).setOnClickListener(this);
        findViewById(R.id.btn_zhihu).setOnClickListener(this);
        findViewById(R.id.btn_bottom_sheet).setOnClickListener(this);
        findViewById(R.id.btn_swipe_dismiss).setOnClickListener(this);
    }

    @Override
    public void initData(Intent intent) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back_top) {// 回到顶部按钮动画。
            startActivity(new Intent(this, BackTopActivity.class));
        } else if (v.getId() == R.id.btn_zhihu) {// 仿知乎首页隐藏按钮动画。
            startActivity(new Intent(this, ZhihuActivity.class));
        } else if (v.getId() == R.id.btn_bottom_sheet) {// 底部覆盖。
            startActivity(new Intent(this, BottomSheetBehaviorActivity.class));
        } else if (v.getId() == R.id.btn_swipe_dismiss) {// 滑动删除。
            startActivity(new Intent(this, SwipeDismissBehaviorActivity.class));
        }
    }
}
