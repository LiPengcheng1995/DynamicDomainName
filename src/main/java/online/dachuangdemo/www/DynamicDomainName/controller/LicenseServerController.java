package online.dachuangdemo.www.DynamicDomainName.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.dachuangdemo.www.DynamicDomainName.configuration.ResponseWrapper;
import online.dachuangdemo.www.DynamicDomainName.domain.LicenseServerVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 19:35
 * description:
 **/
@Controller
@Api(value = "/api/licenseServer", description = "注册服务器管理", tags = "License Server")
@RequestMapping("/api/licenseServer")
@ResponseBody
public class LicenseServerController {
    @ApiOperation("获得可用的注册服务器信息列表")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseWrapper<List<LicenseServerVO>> getAllLicenseServer() {
        return new ResponseWrapper();
    }

    @ApiOperation("激活指定的注册服务器")
    @RequestMapping(value = "/{ServerId}/activation", method = RequestMethod.POST)
    public ResponseWrapper<Boolean> activeLicenseServer(@PathVariable Integer serverId) {
        return new ResponseWrapper();
    }

    @ApiOperation("关闭指定的注册服务器")
    @RequestMapping(value = "/{ServerId}/inactivation", method = RequestMethod.POST)
    public ResponseWrapper<Boolean> inactiveLicenseServer(@PathVariable Integer serverId) {
        return new ResponseWrapper();
    }
}
