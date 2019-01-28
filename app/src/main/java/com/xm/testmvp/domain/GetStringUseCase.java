package com.xm.testmvp.domain;

import android.support.annotation.NonNull;
import android.util.Log;

import com.xm.testmvp.data.repository.ImplMainRepository;
import com.xm.xmvp.di.module.impl.PostExecutionThread;
import com.xm.xmvp.di.module.impl.ThreadExecutor;
import com.xm.xmvp.usecase.BaseUseCase;

import javax.inject.Inject;


/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class GetStringUseCase implements BaseUseCase {

    private final ImplMainRepository repository;

    @Inject
    public GetStringUseCase(@NonNull ThreadExecutor threadExecutor,
                            @NonNull PostExecutionThread postExecutionThread,
                            ImplMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        Log.e("test", repository.getString());
    }
}
