package online.dachuangdemo.www.DynamicDomainName.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.dachuangdemo.www.DynamicDomainName.configuration.ResponseWrapper;
import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;
import online.dachuangdemo.www.DynamicDomainName.domain.submit.MappingSubmit;
import online.dachuangdemo.www.DynamicDomainName.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 19:35
 * description:
 **/
@Controller
@Api(value = "/api/Local/mapping", description = "本地映射管理", tags = "Local Mapping")
@RequestMapping("/api/Local/mapping")
@ResponseBody
public class MappingController {

    @Resource
    private MappingService mappingService;

    @ApiOperation("获得所有可用映射的列表")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseWrapper<List<MappingVO>> getAllMappings() {
        return mappingService.getAllMappings();
    }

    @ApiOperation("获得指定映射的信息")
    @RequestMapping(value = "/{mappingId}", method = RequestMethod.GET)
    public ResponseWrapper<MappingVO> getMapping(@PathVariable Integer mappingId) {
        return mappingService.getMapping(mappingId);
    }

    @ApiOperation("激活对应映射")
    @RequestMapping(value = "/activation/{mappingId}", method = RequestMethod.POST)
    public ResponseWrapper<Boolean> activeMapping(@PathVariable Integer mappingId) {
        return mappingService.activeMapping(mappingId);
    }

    @ApiOperation("关闭对应映射")
    @RequestMapping(value = "/inactivation/{mappingId}", method = RequestMethod.POST)
    public ResponseWrapper<Boolean> inactiveMapping(@PathVariable Integer mappingId) {
        return mappingService.inactiveMapping(mappingId);
    }

    @ApiOperation("添加新映射")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseWrapper<MappingVO> addNewMapping(@RequestBody MappingSubmit mappingSubmit) {
        return mappingService.addMapping(mappingSubmit);
    }

    @ApiOperation("删除对应映射")
    @RequestMapping(value = "/delete/{mappingId}", method = RequestMethod.DELETE)
    public ResponseWrapper<Boolean> removeMapping(@PathVariable Integer mappingId) {
        return mappingService.removeMapping(mappingId);
    }

    @ApiOperation("修改映射")
    @RequestMapping(value = "/{mappingId}", method = RequestMethod.PUT)
    public ResponseWrapper<Boolean> modifyMapping(@PathVariable Integer mappingId,@RequestBody MappingSubmit mappingSubmit) {
        return mappingService.modifyMapping(mappingId,mappingSubmit);
    }


}
