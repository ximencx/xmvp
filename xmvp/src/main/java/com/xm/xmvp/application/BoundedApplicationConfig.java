package com.xm.xmvp.application;

import androidx.annotation.NonNull;


/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class BoundedApplicationConfig implements Comparable<BoundedApplicationConfig>{
    /**
     * 优先级
     */
    private int priority;
    /**
     * 模拟的Application
     */
    private BoundedApplication boundedApplication;
    /**
     * 模拟Application标签
     */
    private String tag;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public BoundedApplication getBoundedApplication() {
        return boundedApplication;
    }

    public void setBoundedApplication(BoundedApplication boundedApplication) {
        this.boundedApplication = boundedApplication;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override public int compareTo(@NonNull BoundedApplicationConfig other) {
        int otherPriority = other.getPriority();

        if (priority > otherPriority) {
            return 1;
        } else if (priority == otherPriority) {
            return 0;
        } else {
            return -1;
        }
    }
}

