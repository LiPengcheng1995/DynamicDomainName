package online.dachuangdemo.www.DynamicDomainName.util;

import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * creat_user: lipengcheng
 * creat_date: 2018/1/15 T 17:16
 **/
public class HostFileOperation {
    private static final String HOST_PATH = "C:\\Windows\\System32\\drivers\\etc\\hosts";
    private static final String DESCRIPTION = "# 动态域名设置demo,本程序仅作学习使用，不得用于其他用途";
    private static final List<MappingVO> mappingVOs = new ArrayList<>();

    private static Boolean writeToFile() throws IOException {
        File file = new File(HOST_PATH);
        FileWriter writer = new FileWriter(file);
        writer.write(DESCRIPTION);
        for (int i = 0; i < mappingVOs.size(); i++) {
            writer.write(mappingVOs.get(i).toString());
        }
        writer.flush();
        writer.close();
        return true;
    }

    public static Boolean addToFile(MappingVO mappingVO) throws IOException {
        mappingVO.setIfActive(true);
        if (mappingVOs.indexOf(mappingVO) != -1) {
            return false;
        }
        mappingVOs.add(mappingVO);
        writeToFile();
        return false;
    }

    public static Boolean iniHostFile(List<MappingVO> tempMappingVOs) throws IOException {
        mappingVOs.addAll(tempMappingVOs);
        writeToFile();
        return false;
    }

    public static Boolean removeFromFile(MappingVO mappingVO) throws IOException {
        if (mappingVOs.indexOf(mappingVO) == -1) {
            return false;
        }
        mappingVOs.remove(mappingVO);
        return writeToFile();
    }


}
