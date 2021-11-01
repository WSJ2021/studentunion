package com.student.union.util;

public class StringUtil {
    /**
     * 返回"" 不是空
     */
    public static String valueOf(Object obj){return (obj == null) ? "":obj.toString();}
}
