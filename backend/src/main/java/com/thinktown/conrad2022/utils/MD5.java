package com.thinktown.conrad2022.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MD5 {
    public static String getString(String strValue) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        return newstr;
    }
}