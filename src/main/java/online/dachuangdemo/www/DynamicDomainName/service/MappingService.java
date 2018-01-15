package online.dachuangdemo.www.DynamicDomainName.service;

import online.dachuangdemo.www.DynamicDomainName.configuration.ResponseWrapper;
import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;

import java.util.List;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/14 16:02
 * description:
 **/
public interface MappingService {
    ResponseWrapper<List<MappingVO>> getAllMappings();
    ResponseWrapper<Boolean> activeMapping(Integer id);
    ResponseWrapper<MappingVO> getMapping(Integer id);


}
