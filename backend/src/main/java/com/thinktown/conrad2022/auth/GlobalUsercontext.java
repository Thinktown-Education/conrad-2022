package com.thinktown.conrad2022.auth;

public class GlobalUsercontext {
    private static int userId;

    public static void setUserId(int id) {
        userId = id;
    }

    public static int getUserId() {
        return userId;
    }
}
