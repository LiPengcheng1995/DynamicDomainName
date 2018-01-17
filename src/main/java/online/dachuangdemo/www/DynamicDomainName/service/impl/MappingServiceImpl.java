package online.dachuangdemo.www.DynamicDomainName.service.impl;

import online.dachuangdemo.www.DynamicDomainName.configuration.ResponseWrapper;
import online.dachuangdemo.www.DynamicDomainName.dao.MappingDao;
import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;
import online.dachuangdemo.www.DynamicDomainName.domain.submit.MappingSubmit;
import online.dachuangdemo.www.DynamicDomainName.enumeration.ResponseIteam;
import online.dachuangdemo.www.DynamicDomainName.service.MappingService;
import online.dachuangdemo.www.DynamicDomainName.util.HostFileOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
        if (id == null) {
            return responseWrapper;
        }
        try {
            MappingVO mappingVO = mappingDao.getMapping(id);
            if (mappingVO == null) {
                return return_MAPPING_NOT_EXIST_error();
            }
            if (mappingVO.getIfActive()) {
                responseWrapper.setData(false);
                responseWrapper.setCode(ResponseIteam.MAPPING_ALREADY_ON.getCode());
                responseWrapper.setMessage(ResponseIteam.MAPPING_ALREADY_ON.getMessage());
                return responseWrapper;
            }
            HostFileOperation.addToFile(mappingVO);
            Integer updateNumber = mappingDao.activeMapping(id);
            if (updateNumber != 1) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return return_WRITE_TO_HOST_OR_SQLITE_ERROR_error();
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
        if (mappingVO == null) {
            responseWrapper.setData(null);
            responseWrapper.setCode(ResponseIteam.MAPPING_NOT_EXIST.getCode());
            responseWrapper.setMessage(ResponseIteam.MAPPING_NOT_EXIST.getMessage());
        } else {
            responseWrapper.setData(mappingVO);
            responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
            responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        }
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<Boolean> inactiveMapping(Integer id) {
        ResponseWrapper<Boolean> responseWrapper = new ResponseWrapper<>();
        if (id == null) {
            return responseWrapper;
        }
        try {
            MappingVO mappingVO = mappingDao.getMapping(id);
            if (mappingVO == null) {
                return return_MAPPING_NOT_EXIST_error();
            }
            if (!mappingVO.getIfActive()) {
                responseWrapper.setData(false);
                responseWrapper.setCode(ResponseIteam.MAPPING_ALREADY_OFF.getCode());
                responseWrapper.setMessage(ResponseIteam.MAPPING_ALREADY_OFF.getMessage());
                return responseWrapper;
            }
            //从文件中判断是否有，有则删除
            if (!HostFileOperation.removeFromFile(mappingVO)) {
                return return_MAPPING_NOT_EXIST_error();
            }
            Integer updateNumber = mappingDao.inactiveMapping(id);
            if (updateNumber != 1) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return return_WRITE_TO_HOST_OR_SQLITE_ERROR_error();
        }
        responseWrapper.setData(true);
        responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
        responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<MappingVO> addMapping(MappingSubmit mappingSubmit) {
        ResponseWrapper<MappingVO> responseWrapper = new ResponseWrapper<>();

        MappingVO mappingVO = new MappingVO();
        mappingVO.setIp(mappingSubmit.getIpAddress());
        mappingVO.setDomainName(mappingSubmit.getDemainName());
        mappingVO.setDescription(mappingSubmit.getDescription());
        mappingVO.setIfActive(false);
        try {

            if (mappingDao.addMapping(mappingVO) != 1) {
                throw new IOException();
            }
            //获得编号最大的id，即新插入的数据
            mappingVO.setId(mappingDao.getLargestId());

        } catch (IOException e) {
            e.printStackTrace();
            responseWrapper.setData(null);
            responseWrapper.setCode(ResponseIteam.WRITE_TO_HOST_OR_SQLITE_ERROR.getCode());
            responseWrapper.setMessage(ResponseIteam.WRITE_TO_HOST_OR_SQLITE_ERROR.getMessage());
            return responseWrapper;
        }
        responseWrapper.setData(mappingVO);
        responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
        responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<Boolean> removeMapping(Integer id) {
        ResponseWrapper<Boolean> responseWrapper = new ResponseWrapper<>();
        try {
            if (mappingDao.getMapping(id).getIfActive()) {
                //激活状态不可删
                responseWrapper.setData(false);
                responseWrapper.setCode(ResponseIteam.CAN_NOT_REMOVE_ACTIVE_MAPPING.getCode());
                responseWrapper.setMessage(ResponseIteam.CAN_NOT_REMOVE_ACTIVE_MAPPING.getMessage());
                return responseWrapper;
            }
            if (mappingDao.removeMapping(id) != 1) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return return_WRITE_TO_HOST_OR_SQLITE_ERROR_error();
        }
        responseWrapper.setData(true);
        responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
        responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<Boolean> modifyMapping(Integer mappingId,MappingSubmit mappingSubmit) {
        ResponseWrapper<Boolean> responseWrapper = new ResponseWrapper<>();
        MappingVO mappingVO = new MappingVO();
        mappingVO.setId(mappingId);
        mappingVO.setIp(mappingSubmit.getIpAddress());
        mappingVO.setDomainName(mappingSubmit.getDemainName());
        mappingVO.setDescription(mappingSubmit.getDescription());
        try {
            if (mappingVO.getId() == null){
                return return_MAPPING_NOT_EXIST_error();
            }
            if (mappingDao.getMapping(mappingVO.getId()).getIfActive()) {
                //激活状态不可修改
                responseWrapper.setData(false);
                responseWrapper.setCode(ResponseIteam.CAN_NOT_MODIFY_ACTIVE_MAPPING.getCode());
                responseWrapper.setMessage(ResponseIteam.CAN_NOT_MODIFY_ACTIVE_MAPPING.getMessage());
                return responseWrapper;
            }
            if (mappingDao.modifyMapping(mappingVO) != 1) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return return_WRITE_TO_HOST_OR_SQLITE_ERROR_error();
        }
        responseWrapper.setData(true);
        responseWrapper.setCode(ResponseIteam.SUCCESS.getCode());
        responseWrapper.setMessage(ResponseIteam.SUCCESS.getMessage());
        return responseWrapper;
    }

    private ResponseWrapper<Boolean> return_MAPPING_NOT_EXIST_error() {
        ResponseWrapper<Boolean> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setData(false);
        responseWrapper.setCode(ResponseIteam.MAPPING_NOT_EXIST.getCode());
        responseWrapper.setMessage(ResponseIteam.MAPPING_NOT_EXIST.getMessage());
        return responseWrapper;
    }

    private ResponseWrapper<Boolean> return_WRITE_TO_HOST_OR_SQLITE_ERROR_error() {
        ResponseWrapper<Boolean> responseWrapper = new ResponseWrapper<>();
        responseWrapper.setData(false);
        responseWrapper.setCode(ResponseIteam.WRITE_TO_HOST_OR_SQLITE_ERROR.getCode());
        responseWrapper.setMessage(ResponseIteam.WRITE_TO_HOST_OR_SQLITE_ERROR.getMessage());
        return responseWrapper;
    }

}
