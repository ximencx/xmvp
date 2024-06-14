package com.xm.xmvpbase;

/**
 *
 */
public class XMvpException extends Exception {

    public static final String FAILED_INIT_VIEW = "FAILED_INIT_VIEW";

    public XMvpException() {
    }

    public XMvpException(String message) {
        super(message);
    }
}
