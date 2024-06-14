package com.xm.xmvpbase.basemvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xm.xmvpbase.presenter.Presenter;
import com.xm.xmvpbase.vu.Vu;

/**
 *
 * @param <V>
 * @param <P>
 */
public abstract class BaseMvpFragment<V extends Vu.FragmentVu, P extends Presenter> extends Fragment implements Presenter {

    private V view = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        preMvpBinding(savedInstanceState);
        //初始化组件
        Presenter presenter = getPresenter();
        Vu.FragmentVu view = getFragmentVu();
        //绑定view
        if (presenter != null) {
            presenter.bindVu(view);
        }
        if (view != null) {
            view.bindPresenter(presenter);
            view.bindFragment(this);
            View targetView = view.initView(inflater, container, savedInstanceState);
            this.view.bindBfView(this, targetView);
            afterMvpBinding(savedInstanceState);
            return targetView;
        }
        return null;
    }

    @Override
    public void onDestroyView() {
        view.releaseView();
        view.unBindBfView(getFragment());
        view = null;
        super.onDestroyView();
    }

    private V getFragmentVu() {
        return provideVu();
    }

    private P getPresenter() {
        return providePresenter();
    }

    @Override
    public void bindVu(@Nullable Vu vu) {
        this.view = (V) vu;
    }

    public V getVu() {
        return view;
    }

    public BaseMvpFragment getFragment() {
        return this;
    }

    public BaseMvpActivity getHostActivity() {
        return (BaseMvpActivity) getActivity();
    }

    @Nullable
    public abstract V provideVu();

    @Nullable
    public abstract P providePresenter();

    public abstract void preMvpBinding(Bundle savedInstanceState);

    public abstract void afterMvpBinding(Bundle savedInstanceState);
}

