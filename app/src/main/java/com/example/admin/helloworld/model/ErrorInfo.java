package com.example.admin.helloworld.model;

import com.example.admin.helloworld.AppManager;
import com.google.gson.annotations.Expose;

/**
 * Created by admin on 2018-09-21.
 */

public class ErrorInfo {
    private static final int ERROR_TYPE_HTTP = 1;
    private static final int ERROR_TYPE_URL = 2;
    private static final int ERROR_TYPE_FATAL = 3;

    @Expose //不序列化
    int type;
    @Expose
    int tag;
    @Expose
    String functionName;

    @Expose
    String className;

    @Expose
    Site site;

    @Expose
    String reasion;

    @Expose
    String exceptionString;

    public ErrorInfo(int siteId,int type){
        site = new Site(siteId, AppManager.getmContext());
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getReasion() {
        return reasion;
    }

    public void setReasion(String reasion) {
        this.reasion = reasion;
    }

    public String getExceptionString() {
        return exceptionString;
    }

    public void setExceptionString(String exceptionString) {
        this.exceptionString = exceptionString;
    }
}
