package com.xm.xmvp.application;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class ComponentApplication extends Application {

    private final Map<String, Object> components = new HashMap<>();

    /**
     * 向Application中注册一个全局组件（保存在Application中）
     *
     * @param componentName 组件名称
     * @param component     组件对象
     */
    public void registComponent(@NonNull String componentName, @Nullable Object component) {
        components.put(componentName, component);
    }

    /**
     * 注销一个全局（在Application中保存的）组件
     *
     * @param componentName 组件名称
     */
    public void unRegistComponent(@NonNull String componentName) {
        if (components.containsKey(componentName)) {
            components.remove(componentName);
        }
    }

    /**
     * 根据组件名称从Application中获取组件对象
     *
     * @param componentName 组件名称
     * @return 组件对象
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public <T> T getComponent(@NonNull String componentName) {
        if (!this.components.isEmpty() && this.components.containsKey(componentName)) {
            return ((T) this.components.get(componentName));
        }
        return null;
    }

    @Nullable
    public static <T> T getComponent(@NonNull Context context, @NonNull String compName) {
        ComponentApplication componentApplication = (ComponentApplication) context.getApplicationContext();
        if (componentApplication != null) {
            return componentApplication.getComponent(compName);
        }
        return null;
    }
}

