package com.xm.xmvp.vu;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xm.xmvp.presenter.Presenter;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public interface Vu {

    /**
     * 设置与view绑定的Presenter接口实现
     *
     * @param presenter 与view绑定的Presenter接口实现
     */
    void bindPresenter(@Nullable Presenter presenter);

    /**
     * MVP框架模式中，用Activity做Presenter时，View层接口定义推荐继承该接口
     */
    interface ActivityVu extends Vu {
        /**
         * 在Activity的onCreate()方法中初始化View
         *
         * @param savedInstanceState {@link Activity#onCreate(Bundle)}
         */
        void initView(@Nullable Bundle savedInstanceState);


        /**
         * 用于绑定butterKnife用
         *
         * @param object
         * @param view
         */
        void bindBfView(Object object, View view);


        /**
         * 用于解绑butterKnife用
         *
         * @param object
         */
        void unBindBfView(Object object);

        /**
         * 释放View相关资源
         */
        void releaseView();

        /**
         * 绑定与View相关的Activity
         *
         * @param activity 与View绑定的Activity
         */
        void bindActivity(@NonNull Activity activity);
    }

    /**
     * MVP框架模式中，用Fragment做Presenter时，View层接口定义推荐继承该接口
     */
    interface FragmentVu extends Vu {
        /**
         * 初始化View
         */

        View initView(
                @NonNull LayoutInflater inflater,
                @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

        /**
         * 用于绑定butterKnife用
         *
         * @param object
         * @param view
         */
        void bindBfView(Object object, View view);


        /**
         * 用于解绑butterKnife用
         *
         * @param object
         */
        void unBindBfView(Object object);

        /**
         * 释放View相关资源
         */

        void releaseView();

        /**
         * 设置和view绑定的Fragment
         *
         * @param fragment 目标Fragment
         */
        void bindFragment(@NonNull Fragment fragment);
    }
}
