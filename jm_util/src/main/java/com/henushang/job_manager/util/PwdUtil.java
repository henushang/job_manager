package com.henushang.job_manager.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PwdUtil {

    private static final String solt = "uiop9ijn)OKM7ygv^TFC";
    
    public static String getPwd(String rawPwd) {
        String pwd = DigestUtils.md5Hex(solt + rawPwd);
        return pwd;
    }
    
    public static void main(String[] args) {
        System.out.println(getPwd("123456"));
    }
}
