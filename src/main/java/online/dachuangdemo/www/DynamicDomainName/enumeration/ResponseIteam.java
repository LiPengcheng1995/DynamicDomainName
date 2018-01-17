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
    WRITE_TO_HOST_OR_SQLITE_ERROR(202,"本地文件写入错误"),
    MAPPING_ALREADY_ON(203,"此映射已经处于激活状态"),
    MAPPING_ALREADY_OFF(204,"此映射已经处于关闭状态"),
    CAN_NOT_REMOVE_ACTIVE_MAPPING(205,"您不能删除激活状态下的映射"),
    CAN_NOT_MODIFY_ACTIVE_MAPPING(206,"您不能修改激活状态下的映射"),
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
