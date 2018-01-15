package online.dachuangdemo.www.DynamicDomainName.util;

import online.dachuangdemo.www.DynamicDomainName.domain.MappingVO;

import java.io.*;

/**
 * creat_user: lipengcheng
 * creat_date: 2018/1/15 T 17:16
 **/
public class HostFileOperation {
    private static final String  HOST_PATH= "C:\\Windows\\System32\\drivers\\etc\\hosts";

    public static Boolean writeToFile(MappingVO mappingVO) throws IOException {
        File file = new File(HOST_PATH);
        FileWriter writer=new FileWriter(file,true);
        writer.write(mappingVO.toString());
        writer.flush();
        writer.close();
        return true;
    }
    public static Boolean writeToFile1(String mappingVO) throws IOException {
        File file = new File(HOST_PATH);
        FileWriter writer=new FileWriter(file,true);
        writer.write(mappingVO);
        writer.flush();
        writer.close();
        return true;
    }
    public static void main(String args[]){
        try {
            HostFileOperation.writeToFile1("heheh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
