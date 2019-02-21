package com.xm.testmvp.main;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xm.testmvp.domain.GetStringUseCase;
import com.xm.testmvp.presenter.BaseMainActivity;
import com.xm.xmvpbase.presenter.Presenter;
import com.xm.xmvpbase.vu.Vu;

import javax.inject.Inject;

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
        getStringUseCase.execute();
    }
}
