package com.xm.testmvp.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.xm.testmvp.domain.GetStringUseCase;
import com.xm.testmvp.presenter.BaseMainActivity;
import com.xm.xmvpbase.presenter.Presenter;
import com.xm.xmvpbase.vu.Vu;

import javax.inject.Inject;

import rx.functions.Action1;

public class MainActivity extends BaseMainActivity<ViewActivityMain> implements PresenterMain {

    @Inject
    GetStringUseCase getStringUseCase;

    @Nullable
    @Override
    public Vu.ActivityVu provideVu() {
        return new ViewActivityMain();
    }

    @Nullable
    @Override
    public Presenter providePresenter() {
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
        getVu().showBtn("哈哈");
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
}
