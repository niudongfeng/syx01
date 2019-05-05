package com.syx.bytcrm.exp;

/**
 * @author 牛东峰
 */
public class ParameterFormatException extends RuntimeException {

    public ParameterFormatException() {
        super();
    }

    public ParameterFormatException(String s) {
        super(s);
    }

    public ParameterFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterFormatException(Throwable cause) {
        super(cause);
    }
}
