package online.dachuangdemo.www.DynamicDomainName.service.impl;

import online.dachuangdemo.www.DynamicDomainName.configuration.ResponseWrapper;
import online.dachuangdemo.www.DynamicDomainName.dao.MappingDao;
import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;
import online.dachuangdemo.www.DynamicDomainName.enumeration.ResponseIteam;
import online.dachuangdemo.www.DynamicDomainName.service.MappingService;
import online.dachuangdemo.www.DynamicDomainName.util.HostFileOperation;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
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
    public ResponseWrapper<Boolean> activeMapping(Integer id) {
        ResponseWrapper<Boolean> responseWrapper = new ResponseWrapper<>();
        if (id == null){
            return responseWrapper;
        }
        try {
            MappingVO mappingVO = mappingDao.getMapping(id);
            if (mappingVO == null){
                responseWrapper.setData(false);
                responseWrapper.setCode(ResponseIteam.MAPPING_NOT_EXIST.getCode());
                responseWrapper.setMessage(ResponseIteam.MAPPING_NOT_EXIST.getMessage());
                return responseWrapper;
            }
            HostFileOperation.writeToFile(mappingVO);
            mappingDao.activeMapping(id);
        } catch (IOException e) {
            e.printStackTrace();
            responseWrapper.setData(true);
            responseWrapper.setCode(ResponseIteam.WRIT_TO_HOST_OR_SQLITE_ERROR.getCode());
            responseWrapper.setMessage(ResponseIteam.WRIT_TO_HOST_OR_SQLITE_ERROR.getMessage());
            return responseWrapper;
        }
        responseWrapper.setData(true);
        responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
        responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<MappingVO> getMapping(Integer id) {
        ResponseWrapper<MappingVO> responseWrapper = new ResponseWrapper<>();
        MappingVO mappingVO = mappingDao.getMapping(id);
        if (mappingVO == null){
            responseWrapper.setData(null);
            responseWrapper.setCode(ResponseIteam.MAPPING_NOT_EXIST.getCode());
            responseWrapper.setMessage(ResponseIteam.MAPPING_NOT_EXIST.getMessage());
        }else{
            responseWrapper.setData(mappingVO);
            responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
            responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        }
        return responseWrapper;
    }
}
