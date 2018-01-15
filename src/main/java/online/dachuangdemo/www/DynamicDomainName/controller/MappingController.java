package online.dachuangdemo.www.DynamicDomainName.controller;

import online.dachuangdemo.www.DynamicDomainName.configuration.ResponseWrapper;
import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;
import online.dachuangdemo.www.DynamicDomainName.domain.submit.MappingSubmit;
import online.dachuangdemo.www.DynamicDomainName.service.MappingService;
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
@RequestMapping("/api/mapping")
@ResponseBody
public class MappingController {

    @Resource
    private MappingService mappingService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseWrapper<List<MappingVO>> getAllMappings() {
        return mappingService.getAllMappings();
    }

    @RequestMapping(value = "/activation/{mappingId}", method = RequestMethod.POST)
    public ResponseWrapper<Boolean> activeMapping(@PathVariable Integer mappingId) {
        return new ResponseWrapper();
    }

    @RequestMapping(value = "/inactivation/{mappingId}", method = RequestMethod.POST)
    public ResponseWrapper<Boolean> inactiveMapping(@PathVariable Integer mappingId) {
        return new ResponseWrapper();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseWrapper<MappingVO> addNewMapping(@RequestBody MappingSubmit mappingSubmit) {
        return new ResponseWrapper();
    }

    @RequestMapping(value = "/delete/{mappingId}", method = RequestMethod.DELETE)
    public ResponseWrapper<Boolean> removeMapping(@PathVariable Integer mappingId) {
        return new ResponseWrapper();
    }


}
