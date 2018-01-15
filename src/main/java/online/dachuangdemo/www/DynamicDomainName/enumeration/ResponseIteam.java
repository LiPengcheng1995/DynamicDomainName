package online.dachuangdemo.www.DynamicDomainName.enumeration;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 20:01
 * description:
 **/
public enum ResponseIteam {
    SUCCESS(200,"Success"),
    MAPPING_NOT_EXIST(201,"MAPPING_NOT_EXIST"),
    WRIT_TO_HOST_OR_SQLITE_ERROR(202,"WRIT_TO_HOST_OR_SQLITE_ERROR"),
    FAIL(204,"Error");

    int code;
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResponseIteam(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
