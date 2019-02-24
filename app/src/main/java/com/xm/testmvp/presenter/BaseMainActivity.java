package com.xm.testmvp.presenter;

import com.xm.testmvp.MyForkApp;
import com.xm.testmvp.di.MainActivityComponent;
import com.xm.xmvp.di.base.BaseMvpDiActivity;
import com.xm.xmvpbase.presenter.Presenter;
import com.xm.xmvpbase.vu.Vu;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * created on 2019/1/27.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public abstract class BaseMainActivity<V extends Vu.ActivityVu, P extends Presenter> extends BaseMvpDiActivity<V, P> {
    private MainActivityComponent activityComponent;
    private CompositeSubscription compositeSubscription;

    public MainActivityComponent getMainActivityComponent() {
        if (this.activityComponent == null) {
            this.activityComponent = MyForkApp.getMainActivityComponent(this);
        }
        return this.activityComponent;
    }

    public void autoDestroy(Subscription subscription) {
        if (compositeSubscription == null || compositeSubscription.isUnsubscribed()) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    @Override
    public void onDestroy() {
        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed()) {
            compositeSubscription.unsubscribe();
        }
        compositeSubscription = null;
        activityComponent = null;
        super.onDestroy();
    }
}
