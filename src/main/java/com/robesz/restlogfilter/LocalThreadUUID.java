package com.robesz.restlogfilter;

public class LocalThreadUUID {

    private static final ThreadLocal<String> UUID = new ThreadLocal<>();

    public static void setUuid(String uuid){
        UUID.set(uuid);
    }

    public static String getUuid(){
        return UUID.get();
    }

    public static void cleanUp(){
        UUID.remove();
    }

}
