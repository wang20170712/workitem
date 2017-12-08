package com.lin.workitem.common;

public class AjaxResult {
    private int resultCode = 0;
    private String resultMsg = "操作成功";
    private Object data;

    public AjaxResult(){

    }

    public AjaxResult(int resultCode){
        this.resultCode = resultCode;
    }

    public AjaxResult(String resultMsg){
        this.resultMsg = resultMsg;
    }

    public AjaxResult(int resultCode,String resultMsg){
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public AjaxResult(int resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }



    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "resultCode=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
