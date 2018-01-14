package online.dachuangdemo.www.DynamicDomainName.configuration;

import org.springframework.stereotype.Component;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 19:37
 * description:
 **/
@Component
public class ResponseWrapper<S extends Object> {
    private int code;
    private String message;
    private S data;

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

    public S getData() {
        return data;
    }

    public void setData(S data) {
        this.data = data;
    }

    public ResponseWrapper() {
    }

    public ResponseWrapper(int code, String message, S data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
