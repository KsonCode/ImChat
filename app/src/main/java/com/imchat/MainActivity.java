package com.imchat;

import android.widget.TextView;

import com.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity {

    @BindView(R.id.text_test)
    TextView mTestView;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;

    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTestView.setText("test hello");
    }
}
