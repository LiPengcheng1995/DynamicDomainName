package online.dachuangdemo.www.DynamicDomainName.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 21:16
 * description:
 **/
public class LicenseServerVO {

    @ApiModelProperty("证书服务器id")
    private Integer id;

    @ApiModelProperty("证书服务器名称")
    private String name;

    @ApiModelProperty("证书服务器版本")
    private String version;

    @ApiModelProperty("证书适用的软件版本")
    private String adaption;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("是否激活")
    private Boolean ifActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAdaption() {
        return adaption;
    }

    public void setAdaption(String adaption) {
        this.adaption = adaption;
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

    public LicenseServerVO() {
    }

    public LicenseServerVO(Integer id, String name, String version, String adaption, String description, Boolean ifActive) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.adaption = adaption;
        this.description = description;
        this.ifActive = ifActive;
    }
}
