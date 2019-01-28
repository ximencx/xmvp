package com.xm.testmvp;

import com.xm.xmvp.application.AndroidApplication;
import com.xm.xmvp.application.BoundedAppProvider;
import com.xm.xmvp.application.BoundedApplicationConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2019/1/27.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class MyApp extends AndroidApplication {

    @Override
    public List<BoundedAppProvider> buildBoundedAppGraph() {
        List<BoundedAppProvider> list = new ArrayList<>();
        BoundedAppProvider provider = new BoundedAppProvider() {
            @Override
            public List<BoundedApplicationConfig> provideBoundedApplications() {
                BoundedApplicationConfig config = new BoundedApplicationConfig();
                config.setBoundedApplication(new MyForkApp());
                config.setTag("myapp");
                //
                List<BoundedApplicationConfig> list = new ArrayList<>();
                list.add(config);
                return list;
            }
        };
        list.add(provider);
        return list;
    }

    @Override
    public void afterForkedApplicationsBounded() {

    }

    @Override
    public void preForkedApplicationsBounded() {

    }
}
