package online.dachuangdemo.www.DynamicDomainName.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * creat_user: lipengcheng
 * creat_date: 2018/1/16 T 19:26
 **/
@Controller
@Api(value = "/api/Application", description = "程序管理接口", tags = "Application Controll")
@RequestMapping("/api/Application")
@ResponseBody
public class ApplicationController {

    @Autowired
    private ApplicationContext applicationContext;

    @ApiOperation("关闭此应用")
    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public void stop() {
        SpringApplication.exit(applicationContext);
    }
}
