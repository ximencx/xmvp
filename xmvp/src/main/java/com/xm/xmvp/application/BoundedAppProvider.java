package com.xm.xmvp.application;

import java.util.List;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public interface BoundedAppProvider {

    /**
     * @return 该业务模块需要托管到Application的模拟生命周期实现对象
     */
    List<BoundedApplicationConfig> provideBoundedApplications();
}
