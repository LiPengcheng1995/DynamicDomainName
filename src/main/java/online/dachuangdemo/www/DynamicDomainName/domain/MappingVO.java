package online.dachuangdemo.www.DynamicDomainName.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 21:10
 * description:
 **/
public class MappingVO {
    @ApiModelProperty("映射id【对映射操作时用】")
    private Integer id;

    @ApiModelProperty("映射到的ip")
    private String ip;

    @ApiModelProperty("映射的域名")
    private String domainName;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("是否处在激活状态")
    private Boolean ifActive;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIfActive() {
        return ifActive;
    }

    public void setIfActive(Boolean ifActive) {
        this.ifActive = ifActive;
    }

    public MappingVO() {
    }

    public MappingVO(Integer id, String ip, String domainName, String description, Boolean ifActive) {
        this.id = id;
        this.ip = ip;
        this.domainName = domainName;
        this.description = description;
        this.ifActive = ifActive;
    }

    @Override
    public String toString() {
        String result = new String();
        result += "\r\n#  id="+id;
        result += "\r\n#  "+description+"\r\n";
        result += ip + "\t";
        result += domainName + "\r\n";

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MappingVO){
            MappingVO temp = (MappingVO)obj;
            if (this.id == temp.id){
                return true;
            }
        }
        return false;
    }
}
