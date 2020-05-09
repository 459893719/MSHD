package com.miaosha.demo.json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.Disaster;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class OperateJsonFile {
    public static void main(String[] args) {
        OperateJsonFile op = new OperateJsonFile();
        try {
            List<Disaster> test = op.read("test.json");
            for(Disaster d : test){
                System.out.println(d.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Disaster> read(String fileName) throws Exception{
        List<Disaster> list = null;
        String path = OperateJsonFile.class.getClassLoader().getResource(fileName).getPath();
       InputStream inputStream = new FileInputStream(path);
       String text = IOUtils.toString(inputStream,"utf8");
       list = JSONObject.parseArray(text, Disaster.class);
       System.out.println(list.get(0).getReporting_unit());
       return list;
    }

    public void write(List<Disaster> list, String path) throws Exception{
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String jsons = JSON.toJSONString(list);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file, true),"UTF-8");
        writer.write(jsons);
        writer.flush();
        writer.close();
    }
}
