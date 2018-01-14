package online.dachuangdemo.www.DynamicDomainName.controller;

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
@RequestMapping("/api/licenseServer")
@ResponseBody
public class LicenseServerController {
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ResponseWrapper<List<LicenseServerVO>> getAllLicenseServer(){
        return new ResponseWrapper();
    }

    @RequestMapping(value = "/{ServerId}/activation",method = RequestMethod.POST)
    public ResponseWrapper<Boolean> activeLicenseServer(@PathVariable Integer serverId){
        return new ResponseWrapper();
    }

    @RequestMapping(value = "/{ServerId}/inactivation",method = RequestMethod.POST)
    public ResponseWrapper<Boolean> inactiveLicenseServer(@PathVariable Integer serverId){
        return new ResponseWrapper();
    }
}
