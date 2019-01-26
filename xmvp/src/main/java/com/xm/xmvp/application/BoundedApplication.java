package com.xm.xmvp.application;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */

import android.app.Application;
import android.content.res.Configuration;

public interface BoundedApplication {
    /**
     * 原则上该方法会在系统Application执行onCreate生命周期时执行
     * <P>注意：由于该方法中的具体业务逻辑会有一些前置依赖，如：在此方法中调用安全卡操作，那么前置条件为该安全卡已初始化。</P>
     * <p>这些前置条件应该由各子模块与主模块进行协商沟通，主模块应该保证在各前置条件满足后再调用该方法。</p>
     *
     * @param application 有效的Application
     */
    void onCreate(Application application);

    /**
     * {@link Application#onTerminate()}
     */
    void onTerminate();

    /**
     * {@link Application#onConfigurationChanged(Configuration newConfig)}
     */
    void onConfigurationChanged(Configuration newConfig);

    /**
     * {@link Application#onLowMemory()}
     */
    void onLowMemory();

    /**
     * {@link Application#onTrimMemory(int level)}
     */
    void onTrimMemory(int level);

    /**
     * 自定义Application被移除释放
     */
    void onDestroy();
}
