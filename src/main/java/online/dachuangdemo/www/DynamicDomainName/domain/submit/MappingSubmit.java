package online.dachuangdemo.www.DynamicDomainName.domain.submit;

import io.swagger.annotations.ApiModelProperty;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 20:50
 * description:
 **/
public class MappingSubmit {

    @ApiModelProperty("注释")
    private String description;

    @ApiModelProperty("ip")
    private String ipAddress;
    
    @ApiModelProperty("域名")
    private String demainName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDemainName() {
        return demainName;
    }

    public void setDemainName(String demainName) {
        this.demainName = demainName;
    }

    public MappingSubmit() {
    }

    public MappingSubmit(String description, String ipAddress, String demainName) {
        this.description = description;
        this.ipAddress = ipAddress;
        this.demainName = demainName;
    }
}
