package com.miaosha.demo.controller;

import com.miaosha.demo.domain.*;
import com.miaosha.demo.json.OperateJsonFile;
import com.miaosha.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class MultithreadScheduleTask {

    @Autowired
    DisasterService disasterService;
    @Autowired
    CivilStructureService civilStructureService;
    @Autowired
    CollapseRecordService collapseRecordService;
    @Autowired
    DeathStatisticsService deathStatisticsService;
    @Autowired
    DisasterPredictionService disasterPredictionService;
    @Autowired
    DisasterRequestService disasterRequestService;

    OperateJsonFile op = new OperateJsonFile();

    @Async
    @Scheduled(fixedDelay = 60000)  //间隔1分钟
    public void first() throws InterruptedException {
        try {
            List<CivilStructure> civilStructureList = op.read_civilStructureList("civil_structure.json");
            if(civilStructureList != null){
                civilStructureService.insertByJson(civilStructureList);
            }

            List<CollapseRecord> collapseRecordList = op.read_collapseRecordList("collapse_record.json");
            if(civilStructureList != null){
                collapseRecordService.insertByJson(collapseRecordList);
            }

            List<DeathStatistics> deathStatisticsList = op.read_deathStatisticsList("death_statistics.json");
            if(deathStatisticsList != null){
                deathStatisticsService.insertByJson(deathStatisticsList);
            }

            List<DisasterPrediction> disasterPredictionList = op.read_disasterPredictionList("disaster_prediction.json");
            if(disasterPredictionList != null){
                deathStatisticsService.insertByJson(deathStatisticsList);
            }

            List<Disaster> disasterList = op.read_disasterList("comm_disaster.json");
            if(disasterList != null){
                disasterService.insertByJson(disasterList);
            }
            System.out.println("更新完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
