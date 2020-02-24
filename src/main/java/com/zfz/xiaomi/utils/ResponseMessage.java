package com.zfz.xiaomi.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage {
    private  String errorCode;
    private  String errMsg;
    private Map<String,Object> objectMap = new HashMap<>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }

    public ResponseMessage addObject(String key, Object value){
        this.objectMap.put(key, value);
        return this;
    }

    //处理成功相应的方法
    public static ResponseMessage success(){
        ResponseMessage rm = new ResponseMessage();
        rm.setErrorCode("100");
        rm.setErrMsg("处理成功");
        return rm;
    }
    public static ResponseMessage error(){
        ResponseMessage rm = new ResponseMessage();
        rm.setErrorCode("200");
        rm.setErrMsg("处理失败");
        return rm;
    }

}
