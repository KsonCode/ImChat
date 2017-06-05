package com.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qingchen on 2017/6/5.
 */

public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View mRoot;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //初始化参数
        initArgs(getArguments());//不需要返回bollean


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRoot == null) {

            int layId = getContentLayoutId();
            //初始化当前的跟布局，但是不再创建时就添加到container里边
            View root = inflater.inflate(layId, container, false);

            initWidget(root);

            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                //把当前root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }


        return mRoot;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //当view创建完成后初始化数据
        initData();
    }


    /**
     * 初始化相关参数
     *
     * @param bundle 参数bundle
     * @return 如果参数正确返回true，否则返回false
     */
    protected void initArgs(Bundle bundle) {
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
    protected void initWidget(View root) {

    }


    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     * @return 返回true代表我已经处理返回逻辑，activity不用自己finish
     * 返回fasle，代表我没有处理
     */
    public boolean onBackPressed(){

        return false;

    }
}
