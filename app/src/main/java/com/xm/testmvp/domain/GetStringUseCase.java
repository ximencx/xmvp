package com.xm.testmvp.domain;

import com.xm.testmvp.data.repository.ImplMainRepository;
import com.xm.xmvp.usecase.BaseUseCase;

import javax.inject.Inject;

import rx.Observable;


/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class GetStringUseCase extends BaseUseCase<String> {

    private final ImplMainRepository repository;

    @Inject
    public GetStringUseCase(ImplMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<String> builder() {
        return Observable.just((String) getParam1() + repository.getString());
    }
}
