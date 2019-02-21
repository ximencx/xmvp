package com.xm.xmvp.di.base;

import android.app.Activity;

import com.xm.xmvp.application.AndroidApplication;
import com.xm.xmvp.di.components.ActivityComponent;
import com.xm.xmvp.di.components.FragmentComponent;
import com.xm.xmvpbase.basemvp.BaseMvpFragment;
import com.xm.xmvpbase.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:支持dagger2
 */
public abstract class BaseMvpDiFragment<V extends Vu.FragmentVu> extends BaseMvpFragment<V> {

    private FragmentComponent fragmentComponent;

    public FragmentComponent getFragmentComponent() {
        if (this.fragmentComponent == null) {
            this.fragmentComponent = ((AndroidApplication) getActivity()
                    .getApplication())
                    .createFragmentComponent(this, getActivityComponent());
        }
        return this.fragmentComponent;
    }

    public ActivityComponent getActivityComponent() {
        Activity activity = getActivity();
        if (activity instanceof BaseMvpDiActivity) {
            return ((BaseMvpDiActivity) activity).getActivityComponent();
        } else {
            throw new IllegalStateException("the fragment's host activity is not a instance of BaseMvpDiActivity");
        }
    }

    @Override
    public void onDestroyView() {
        this.fragmentComponent = null;
        super.onDestroyView();
    }

}

