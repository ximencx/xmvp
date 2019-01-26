package com.xm.xmvp.di.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.xm.xmvp.application.AndroidApplication;
import com.xm.xmvp.di.components.ActivityComponent;
import com.xm.xmvp.di.components.FragmentComponent;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:支持dagger2
 */
public class SmartFragment extends Fragment {

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
        if (activity instanceof SmartActivity) {
            return ((SmartActivity) activity).getActivityComponent();
        } else {
            throw new IllegalStateException("the fragment's host activity is not a instance of SmartActivity");
        }
    }

    @Override
    public void onDestroyView() {
        this.fragmentComponent = null;
        super.onDestroyView();
    }
}

