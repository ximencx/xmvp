package com.xm.testmvp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.xm.testmvp.R;
import com.xm.xmvpbase.vu.ActivityView;

/**
 * created on 2019/2/21.
 * author:wangkezhi
 * email:45436660@qq.com
 * summary:
 */
public class ViewActivityMain extends ActivityView<PresenterMain> implements VuActivityMain {

    private Button btn1;

    @Override
    protected int provideLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        btn1 = (Button) findViewById(R.id.btn1);
        initListener();
    }

    private void initListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onClickBtn1();
            }
        });
    }


    @Override
    public void showBtn(String st) {
        btn1.setText(st);
    }
}
