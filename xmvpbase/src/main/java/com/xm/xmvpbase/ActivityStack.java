package com.xm.xmvpbase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class ActivityStack {

    @Nullable
    private static ActivityStack instance;

    @NonNull
    public static ActivityStack getInstance() {
        //DoubleCheck
        if (instance == null) {
            synchronized (ActivityStack.class) {
                if (instance == null) {
                    instance = new ActivityStack();
                }
            }
        }
        return instance;
    }

    private ActivityStack() {
        activities = new LinkedList<>();
    }

    /**
     * activity堆栈
     */
    private final LinkedList<Activity> activities;

    /**
     * 获取堆栈中的所有Activity
     *
     * @return {@link #activities}
     */
    @NonNull
    public LinkedList<Activity> getAllActivities() {
        return activities;
    }

    /**
     * 获取堆栈顶端的Activity
     *
     * @return activity
     */
    @Nullable
    public Activity getTopActivity() {
        if (activities.isEmpty()) {
            return null;
        }
        return activities.getFirst();
    }

    /**
     * 将一个Activity入栈
     *
     * @param activity 目标Activity
     */
    public void pushActivity(@NonNull Activity activity) {
        if (!activities.contains(activity)) {
            activities.addFirst(activity);
        }
    }

    /**
     * 从堆栈中弹出一个Activity
     *
     * @param activity 目标Activity
     * @param isFinish 出栈的同时是否结束Activity
     * @return 操作结果（若堆栈中不存在该Activity，弹出将会失败返回false）
     */
    public boolean popActivity(@NonNull Activity activity, boolean isFinish) {
        if (activities.isEmpty()) {
            return false;
        }
        if (activities.contains(activity)) {
            if (isFinish) {
                activity.finish();
            }
            return activities.remove(activity);
        }
        return false;
    }

    /**
     * 从堆栈中弹出所有的Activity对象
     *
     * @param isFinish 出栈的同时是否结束Activity
     */
    public void popAllActivities(boolean isFinish) {
        if (activities.isEmpty()) {
            return;
        }
        if (isFinish) {
            Iterator<Activity> iterator = activities.iterator();
            //noinspection WhileLoopReplaceableByForEach
            while (iterator.hasNext()) {
                iterator.next().finish();
            }
        }
        activities.clear();
    }

    /**
     * 从堆栈中弹出Activity直到置顶的位置
     *
     * @param position 目标位置
     * @param isFinish 出栈的同时是否结束Activity
     */
    public void popActivitiesUntil(int position, boolean isFinish) {
        if (activities.isEmpty() || position < 0) {
            return;
        }

        for (int i = 0; i < position; i++) {
            if (isFinish) {
                activities.getFirst().finish();
            }
            activities.removeFirst();
        }
    }


    /**
     * 从堆栈中弹出Activity直到某个指定的Activity为止（不弹出指定的Activity）
     *
     * @param activity 目标Activity
     * @param isFinish 出栈的同时是否结束Activity
     */
    public void popActivitiesUntil(@NonNull Activity activity, boolean isFinish) {
        if (activities.isEmpty() || !activities.contains(activity)) {
            return;
        }
        int position = activities.indexOf(activity) - 1;
        popActivitiesUntil(position, isFinish);
    }

    /**
     * 弹出top以下的所有activity
     *
     * @param isFinish 是否finish其他界面
     */
    public void pop2TopActivity(boolean isFinish) {
        final int position = activities.size() - 1;
        for (int i = 0; i < position; i++) {
            if (isFinish) {
                activities.getLast().finish();
            }
            activities.removeLast();
        }
    }

    /**
     * 从堆栈中弹出Activity直到某个指定类型的Activity为止（不弹出指定类型的Activity）
     *
     * @param cls      目标Activity类型
     * @param isFinish 出栈的同时是否结束Activity
     */

    public <T extends Activity> void popActivitiesUntil(@NonNull Class<T> cls, boolean isFinish) {
        if (activities.isEmpty()) {
            return;
        }
        int position = -1;
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getClass().equals(cls)) {
                position = i;
                break;
            }
        }
        popActivitiesUntil(position, isFinish);
    }

    /**
     * 完全退出
     */
    public void exitApp() {
        popAllActivities(true);
    }

    /**
     * 根据class name获取activity
     * <p/>
     * Activity名称
     *
     * @return 获得的对象
     */
    @Nullable
    public Activity getActivityByClassName(@NonNull String activityName) {
        if (activities.isEmpty()) {
            return null;
        }
        for (Activity ac : activities) {
            if (ac.getClass().getName().equals(activityName)) {
                return ac;
            }
        }
        return null;
    }

    /**
     * 根据Activity类名获取Activity对象
     *
     * @param cs Activity的class对象
     * @return 获得的对象
     */
    @Nullable
    public Activity getActivityByClass(Class<? extends Activity> cs) {
        if (activities.isEmpty()) {
            return null;
        }
        for (Activity ac : activities) {
            if (ac.getClass().equals(cs)) {
                return ac;
            }
        }
        return null;
    }
}

