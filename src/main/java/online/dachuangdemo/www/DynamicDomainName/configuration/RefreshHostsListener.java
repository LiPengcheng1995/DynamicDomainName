package online.dachuangdemo.www.DynamicDomainName.configuration;

import online.dachuangdemo.www.DynamicDomainName.dao.MappingDao;
import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;
import online.dachuangdemo.www.DynamicDomainName.util.HostFileOperation;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * creat_user: lipengcheng
 * creat_date: 2018/1/16 T 17:26
 * description: 在启动应用时从本地sqlite中读取数据并将激活的映射更新到hosts中
 **/
@Service
public class RefreshHostsListener implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private MappingDao mappingDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null)//root application context 没有parent，他就是老大.
        {
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            System.out.println("\n\n\n\n\n______________\n\n\n从数据库加载激活的映射\n\n_________\n\n");
            List<MappingVO> mappingVOS = mappingDao.getAllMappings();
            for (int i=0;i < mappingVOS.size();i++){
                System.out.println(mappingVOS.get(i).toString());
            }
            System.out.println("\n\n\n\n\n______________\n\n\n将映射写入配置\n\n_________\n\n");
            try {
                HostFileOperation.iniHostFile(mappingVOS);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
