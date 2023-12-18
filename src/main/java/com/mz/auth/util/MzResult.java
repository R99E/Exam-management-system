package com.mz.auth.util;

import lombok.Data;

import java.util.HashMap;

@Data
public class MzResult extends HashMap {

    //OK  MzResult.ok().put("userid","value")
    public static MzResult error(String msg){
        return new MzResult(msg);
    }
    public static MzResult ok(){
        return new MzResult();
    }
    public MzResult put(String key,Object value){
        super.put(key,value);
        return this;
    }
    //失败的返回
    public MzResult(String message) {
        put("isSuccess",false);
        put("message",message);
    }
    //成功的方法
    public MzResult() {
        put("isSuccess",true);
        put("message","success");
    }
}