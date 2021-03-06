package com.xm.testmvp.presenter;

import com.xm.testmvp.MyForkApp;
import com.xm.testmvp.di.MainActivityComponent;
import com.xm.testmvp.di.MainFragmentComponent;
import com.xm.xmvp.di.base.BaseMvpDiFragment;
import com.xm.xmvpbase.presenter.Presenter;
import com.xm.xmvpbase.vu.Vu;

/**
 * created on 2019/1/27.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class BaseMainFragment<V extends Vu.FragmentVu, P extends Presenter> extends BaseMvpDiFragment<V, P> {

    private MainFragmentComponent fragmentComponent;

    public MainFragmentComponent getMainFragmentComponent() {
        if (fragmentComponent == null) {
            MainActivityComponent activityComponent = null;
            if (getActivity() instanceof BaseMainActivity) {
                activityComponent = ((BaseMainActivity) getActivity()).getMainActivityComponent();
            }
            fragmentComponent = MyForkApp.getMainFragmentComponent(this, activityComponent);
        }
        return fragmentComponent;
    }

    @Override
    public void onDestroyView() {
        if (fragmentComponent != null) {
            fragmentComponent = null;
        }
        super.onDestroyView();
    }
}
