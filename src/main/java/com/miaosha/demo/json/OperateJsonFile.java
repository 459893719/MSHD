package com.miaosha.demo.json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miaosha.demo.domain.*;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class OperateJsonFile {

    public static void main(String[] args) {
        OperateJsonFile op = new OperateJsonFile();
        try {
            List<Disaster> test = op.read_disasterList("test.json");
            for(Disaster d : test){
                System.out.println(d.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Disaster> read_disasterList(String fileName) throws Exception{
        List<Disaster> list = null;
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        System.out.println(path);
        InputStream inputStream = new FileInputStream(path);
        String text = IOUtils.toString(inputStream,"utf8");
        list = JSONObject.parseArray(text, Disaster.class);
        return list;
    }

    public List<CivilStructure> read_civilStructureList(String fileName) throws Exception{
        List<CivilStructure> list = null;
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        InputStream inputStream = new FileInputStream(path);
        String text = IOUtils.toString(inputStream,"utf8");
        list = JSONObject.parseArray(text, CivilStructure.class);
        return list;
    }

    public List<DisasterPrediction> read_disasterPredictionList(String fileName) throws Exception{
        List<DisasterPrediction> list = null;
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        InputStream inputStream = new FileInputStream(path);
        String text = IOUtils.toString(inputStream,"utf8");
        list = JSONObject.parseArray(text, DisasterPrediction.class);
        return list;
    }

    public List<DisasterRequest> read_disasterRequestList(String fileName) throws Exception{
        List<DisasterRequest> list = null;
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        InputStream inputStream = new FileInputStream(path);
        String text = IOUtils.toString(inputStream,"utf8");
        list = JSONObject.parseArray(text, DisasterRequest.class);
        return list;
    }

    public List<CollapseRecord> read_collapseRecordList(String fileName) throws Exception{
        List<CollapseRecord> list = null;
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        InputStream inputStream = new FileInputStream(path);
        String text = IOUtils.toString(inputStream,"utf8");
        list = JSONObject.parseArray(text, CollapseRecord.class);
        return list;
    }

    public List<DeathStatistics> read_deathStatisticsList(String fileName) throws Exception{
        List<DeathStatistics> list = null;
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        //String path = OperateJsonFile.class.getClassLoader().getResource(fileName).getPath();
        InputStream inputStream = new FileInputStream(path);
        String text = IOUtils.toString(inputStream,"utf8");
        list = JSONObject.parseArray(text, DeathStatistics.class);
        return list;
    }

    public void write_disaster(List<Disaster> list, String fileName) throws Exception{
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String jsons = JSON.toJSONString(list);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.write(jsons);
        writer.flush();
        writer.close();
    }

    public void write_civilStructure(List<CivilStructure> list, String fileName) throws Exception{
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String jsons = JSON.toJSONString(list);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.write(jsons);
        writer.flush();
        writer.close();
    }

    public void write_collapseRecord(List<CollapseRecord> list, String fileName) throws Exception{
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String jsons = JSON.toJSONString(list);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.write(jsons);
        writer.flush();
        writer.close();
    }

    public void write_deathStatistics(List<DeathStatistics> list, String fileName) throws Exception{
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String jsons = JSON.toJSONString(list);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.write(jsons);
        writer.flush();
        writer.close();
    }

    public void write_disasterPrediction(List<DisasterPrediction> list, String fileName) throws Exception{
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String jsons = JSON.toJSONString(list);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.write(jsons);
        writer.flush();
        writer.close();
    }

    public void write_disasterRequest(List<DisasterRequest> list, String fileName) throws Exception{
        String path = "/E:/IDEA_WorkPlace/miaosha/target/classes/" + fileName;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String jsons = JSON.toJSONString(list);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.write(jsons);
        writer.flush();
        writer.close();
    }
}
