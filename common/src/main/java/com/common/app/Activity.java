package com.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by qingchen on 2017/6/5.
 */

public abstract class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //在洁面未初始化之前调用的初始化窗口
        initWindows();

        if (initArgs(getIntent().getExtras())) {
            getContentLayoutId();
            initWidget();
            initData();
        } else {
            finish();
        }
    }


    protected void initWindows() {

    }

    /**
     * 初始化相关参数
     *
     * @param bundle 参数bundle
     * @return 如果参数正确返回true，否则返回false
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 得到当前界面的资源文件id
     *
     * @return
     */
    protected abstract int getContentLayoutId();//子类必须复写


    /**
     * 初始化控件
     */
    protected void initWidget() {

    }


    /**
     * 初始化数据
     */
    protected void initData() {

    }


    @Override
    public boolean onSupportNavigateUp() {
        //当点击界面导航返回时，finish掉当前页面
        finish();
        return super.onSupportNavigateUp();
    }


    @SuppressWarnings("RestrictedApi")
    @Override
    public void onBackPressed() {
//得到当前activity下的所有fragment
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        //判空
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                //判断是否我们能够处理的fragment类型
                if (fragment instanceof com.common.app.Fragment) {
                    //判断是否拦截了返回按钮
                    if (((com.common.app.Fragment) fragment).onBackPressed()) {
                        //如果有直接return
                        return;
                    }
                }
            }
        }

        super.onBackPressed();

    }
}
