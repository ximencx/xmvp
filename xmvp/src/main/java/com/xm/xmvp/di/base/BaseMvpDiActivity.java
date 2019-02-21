package com.xm.xmvp.di.base;

import com.xm.xmvp.application.AndroidApplication;
import com.xm.xmvp.di.components.ActivityComponent;
import com.xm.xmvpbase.basemvp.BaseMvpActivity;
import com.xm.xmvpbase.vu.Vu;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:支持dagger2
 */
public abstract class BaseMvpDiActivity<V extends Vu.ActivityVu> extends BaseMvpActivity<V> {

    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (this.activityComponent == null) {
            //初始化注入控制器
            this.activityComponent = ((AndroidApplication) getApplication()).createActivityComponent(this);
        }
        return this.activityComponent;
    }

    @Override
    protected void onDestroy() {
        this.activityComponent = null;
        super.onDestroy();
    }
}

