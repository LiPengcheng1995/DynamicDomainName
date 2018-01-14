package online.dachuangdemo.www.DynamicDomainName.domain.submit;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 20:50
 * description:
 **/
public class MappingSubmit {
    private String description;
    private String ipAddress;
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
