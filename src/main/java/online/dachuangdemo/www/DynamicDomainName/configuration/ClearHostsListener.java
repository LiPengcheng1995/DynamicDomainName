package online.dachuangdemo.www.DynamicDomainName.configuration;

import online.dachuangdemo.www.DynamicDomainName.dao.MappingDao;
import online.dachuangdemo.www.DynamicDomainName.util.HostFileOperation;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * creat_user: lipengcheng
 * creat_date: 2018/1/16 T 18:34
 **/
@Service
public class ClearHostsListener implements DisposableBean, ExitCodeGenerator {

    @Resource
    private MappingDao mappingDao;

    @Override
    public void destroy() throws Exception {
        System.out.println("\n\n\n\n\n______________\n\n\n将数据库所有映射状态设置为不可用\n\n_________\n\n");
        mappingDao.inactiveAllMappings();
        System.out.println("\n\n\n\n\n______________\n\n\n将hosts文件清空\n\n_________\n\n");
        HostFileOperation.clearHostFile();
        System.out.println("\n\n\n\n\n______________\n\n\n清理完成\n\n_________\n\n");
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
