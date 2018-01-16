package online.dachuangdemo.www.DynamicDomainName.enumeration;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 20:01
 * description:
 **/
public enum ResponseIteam {
    SUCCESS(200,"成功"),
    MAPPING_NOT_EXIST(201,"此映射不存在"),
    WRIT_TO_HOST_OR_SQLITE_ERROR(202,"本地文件写入错误"),
    MAPPING_ALREADY_ON(203,"此映射已经处于激活状态"),
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
