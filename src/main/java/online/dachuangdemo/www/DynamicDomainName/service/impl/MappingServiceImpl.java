package online.dachuangdemo.www.DynamicDomainName.service.impl;

import online.dachuangdemo.www.DynamicDomainName.configuration.ResponseWrapper;
import online.dachuangdemo.www.DynamicDomainName.dao.MappingDao;
import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;
import online.dachuangdemo.www.DynamicDomainName.enumeration.ResponseIteam;
import online.dachuangdemo.www.DynamicDomainName.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/14 16:02
 * description:
 **/
@Component
public class MappingServiceImpl implements MappingService {
    @Autowired
    private MappingDao mappingDao;

    @Override
    public ResponseWrapper<List<MappingVO>> getAllMappings() {
        ResponseWrapper<List<MappingVO>> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setData(mappingDao.getAllMappings());
        responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
        responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<Boolean> activeMapping() {
        return null;
    }
}
