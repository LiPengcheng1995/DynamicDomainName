package online.dachuangdemo.www.DynamicDomainName.dao;

import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/14 15:46
 * description:
 **/
@Repository
public interface MappingDao {
    List<MappingVO> getAllMappings();
    List<MappingVO> getAllActiveMappings();
    Integer activeMapping(Integer id);
    MappingVO getMapping(Integer id);
    Integer inactiveMapping(Integer id);
    void inactiveAllMappings();
    Integer addMapping(MappingVO mappingVO);
    Integer getLargestId();
    Integer removeMapping(Integer id);
    Integer modifyMapping(MappingVO mappingVO);


}
