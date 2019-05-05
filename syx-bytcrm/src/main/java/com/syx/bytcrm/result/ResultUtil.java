package com.syx.bytcrm.result;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * @author 牛东峰
 */
public class ResultUtil {

    public static final long SUCCESS_CODE = 0;

    public static final long EXCEPTION_CODE = 1;
    public static final long PATAM_EXCEPTION_CODE = 2;
    public static final long PATAM_CODE = 3;

    public static final long NOT_FOUND_CODE = 4;

    public static final String EMPTY = "";
    private static final String SAVE_SUCCESS   = "保存成功";
    private static final String DELETE_SUCCESS = "删除成功";
    private static final String UPDATE_SUCCESS = "修改成功";

    public static final R SAVE_OK   = new R<>().setCode(SUCCESS_CODE).setMsg(SAVE_SUCCESS  ).setMsg(EMPTY);
    public static final R DELETE_OK = new R<>().setCode(SUCCESS_CODE).setMsg(DELETE_SUCCESS).setMsg(EMPTY);
    public static final R UPDATE_OK = new R<>().setCode(SUCCESS_CODE).setMsg(UPDATE_SUCCESS).setMsg(EMPTY);



    public static R getMsgR(long code, String msg) {
        return getR().setCode(code).setMsg(msg).setData(EMPTY);
    }

    public static R getR() {
        return new R<>().setData(EMPTY);
    }

    public static R getR(long code, String msg, Object data) {
        return new R<>().setCode(code).setMsg(msg).setData(data);
    }
}
