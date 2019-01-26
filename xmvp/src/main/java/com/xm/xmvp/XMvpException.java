package com.xm.xmvp;

/**
 * created on 2019/1/26.
 * author:wangkezhi
 * email:45436460@qq.com
 * summary:
 */
public class XMvpException extends Exception {

    public static final String FAILED_INIT_VIEW="FAILED_INIT_VIEW";

    public XMvpException() {
    }

    public XMvpException(String message) {
        super(message);
    }
}
