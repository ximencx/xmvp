package com.xm.testmvp.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.xm.testmvp.domain.GetStringUseCase;
import com.xm.testmvp.presenter.BaseMainActivity;

import javax.inject.Inject;

import rx.functions.Action1;

public class MainActivity extends BaseMainActivity<VuActivityMain,PresenterMain> implements PresenterMain {

    @Inject
    GetStringUseCase getStringUseCase;

    @Nullable
    @Override
    public ViewActivityMain provideVu() {
        return new ViewActivityMain();
    }

    @Nullable
    @Override
    public PresenterMain providePresenter() {
        return this;
    }

    @Override
    public void preMvpBinding(Bundle savedInstanceState) {

    }

    @Override
    public void afterMvpBinding(Bundle savedInstanceState) {
        getMainActivityComponent().inject(this);
    }

    @Override
    public void onClickBtn1() {
        autoDestroy(getStringUseCase
                .setParam1("我是参数")
                .builder()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
                    }
                }));
    }

    @Override
    public void onClickBtn2() {
        getVu().showBtn2("哈哈");
    }
}
