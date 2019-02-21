package com.xm.testmvp.domain;

import android.util.Log;

import com.xm.testmvp.data.repository.ImplMainRepository;
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
    public GetStringUseCase(ImplMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        Log.e("test", repository.getString());
    }
}
