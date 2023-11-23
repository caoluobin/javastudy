package org.clb.util.enuma;

public enum  ErrorCode {
    WrongFactory("1001","选用工厂错误"),cd("","");
     private String code;
     private String msg;

    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
