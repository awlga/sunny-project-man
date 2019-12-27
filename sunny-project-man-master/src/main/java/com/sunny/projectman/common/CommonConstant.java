package com.sunny.projectman.common;

public interface CommonConstant {
    /** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;

    public static final Integer SC_OK_200 = 200;

    /**访问权限认证未通过 510*/
    public static final Integer SC_JEECG_NO_AUTHZ=510;

    /**字典翻译文本后缀*/
    public static final String DICT_TEXT_SUFFIX = "_dictText";

}
