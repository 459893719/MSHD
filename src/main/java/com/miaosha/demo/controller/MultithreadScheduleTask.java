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

    OperateJsonFile op = new OperateJsonFile();

    String[] prefix = new String[]{"101","102","103",
                                    "104","105","201",
                                    "202","203","204",
                                    "301","302","303",
                                    "304","401"};
    @Async
    @Scheduled(fixedDelay = 1200000)  //间隔20分钟
    public void first() throws InterruptedException {
        try {
            //死亡
            for(String tmp : prefix){
                List<DeathStatistics> deathStatisticsList = op.read_deathStatisticsList(tmp + "/death_statistics.json");
                if(deathStatisticsList != null) {
                	DeathStatisticsService.beifen();
                    DeathStatisticsService.insertByJson(deathStatisticsList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (DeathStatistics c : deathStatisticsList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //受伤
            for(String tmp : prefix){
                List<Shoushang> shoushangList = op.read_ShoushangList(tmp + "/Shoushang.json");
                if(shoushangList != null) {
                	ShoushangService.beifen();
                    ShoushangService.insertByJson(shoushangList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Shoushang c : shoushangList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //失踪
            for(String tmp : prefix){
                List<Shizong> ShizongList = op.read_ShizongList(tmp + "/Shizong.json");
                if(ShizongList != null) {
                	ShizongService.beifen();
                    ShizongService.insertByJson(ShizongList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Shizong c : ShizongList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //土木
            for(String tmp : prefix){
                List<CivilStructure> civilStructureList = op.read_civilStructureList(tmp + "/civil_structure.json");
                if (civilStructureList != null) {
                	CivilStructureService.beifen();
                    CivilStructureService.insertByJson(civilStructureList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (CivilStructure c : civilStructureList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //砖木
            for(String tmp : prefix){
                List<Zhuanmu> ZhuanmuList = op.read_ZhuanmuList(tmp + "/Zhuanmu.json");
                if (ZhuanmuList != null) {
                	ZhuanmuService.beifen();
                    ZhuanmuService.insertByJson(ZhuanmuList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Zhuanmu c : ZhuanmuList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //砖混
            for(String tmp : prefix){
                List<Zhuanhun> ZhuanhunList = op.read_ZhuanhunList(tmp + "/Zhuanhun.json");
                if (ZhuanhunList != null) {
                	ZhuanhunService.beifen();
                    ZhuanhunService.insertByJson(ZhuanhunList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Zhuanhun c : ZhuanhunList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //框架
            for(String tmp : prefix){
                List<Kuangjia> KuangjiaList = op.read_KuangjiaList(tmp + "/Kuangjia.json");
                if (KuangjiaList != null) {
                	KuangjiaService.beifen();
                    KuangjiaService.insertByJson(KuangjiaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Kuangjia c : KuangjiaList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //其他
            for(String tmp : prefix){
                List<FangwuQita> FangwuQitaList = op.read_FangwuQitaList(tmp + "/FangwuQita.json");
                if (FangwuQitaList != null) {
                	FangwuQitaService.beifen();
                    FangwuQitaService.insertByJson(FangwuQitaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (FangwuQita c : FangwuQitaList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //交通
            for(String tmp : prefix){
                List<Jiaotong> JiaotongList = op.read_JiaotongList(tmp + "/Jiaotong.json");
                if (JiaotongList != null) {
                	JiaotongService.beifen();
                    JiaotongService.insertByJson(JiaotongList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Jiaotong c : JiaotongList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //供水
            for(String tmp : prefix){
                List<Gongshui> GongshuiList = op.read_GongshuiList(tmp + "/Gongshui.json");
                if (GongshuiList != null) {
                	GongshuiService.beifen();
                    GongshuiService.insertByJson(GongshuiList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Gongshui c : GongshuiList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //输油
            for(String tmp : prefix){
                List<Shuyou> ShuyouList = op.read_ShuyouList(tmp + "/Shuyou.json");
                if (ShuyouList != null) {
                	ShuyouService.beifen();
                    ShuyouService.insertByJson(ShuyouList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Shuyou c : ShuyouList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //燃气
            for(String tmp : prefix){
                List<Ranqi> RanqiList = op.read_RanqiList(tmp + "/Ranqi.json");
                if (RanqiList != null) {
                	RanqiService.beifen();
                    RanqiService.insertByJson(RanqiList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Ranqi c : RanqiList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //电力
            for(String tmp : prefix){
                List<Dianli> DianliList = op.read_DianliList(tmp + "/Dianli.json");
                if (DianliList != null) {
                	DianliService.beifen();
                    DianliService.insertByJson(DianliList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (Dianli c : DianliList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //通信
            for(String tmp : prefix){
                List<Disaster> disasterList = op.read_disasterList(tmp + "/comm_disaster.json");
                if(disasterList != null){
                	DisasterService.beifen();
                    DisasterService.insertByJson(disasterList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Disaster c: disasterList){
                        System.out.println(c.toString());
                    }
                }
            }

            //水利
            for(String tmp : prefix){
                List<Shuili> ShuiliList = op.read_ShuiliList(tmp + "/Shuili.json");
                if(ShuiliList != null){
                	ShuiliService.beifen();
                    ShuiliService.insertByJson(ShuiliList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Shuili c: ShuiliList){
                        System.out.println(c.toString());
                    }
                }
            }

            //崩塌
            for(String tmp : prefix){
                List<CollapseRecord> collapseRecordList = op.read_collapseRecordList(tmp + "/collapse_record.json");
                if (collapseRecordList != null) {
                	CollapseRecordService.beifen();
                    CollapseRecordService.insertByJson(collapseRecordList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (CollapseRecord c : collapseRecordList) {
                        System.out.println(c.toString());
                    }
                }
            }

            //滑坡
            for(String tmp : prefix){
                List<Huapo> HuapoList = op.read_HuapoList(tmp + "/Huapo.json");
                if(HuapoList != null){
                	HuapoService.beifen();
                    HuapoService.insertByJson(HuapoList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Huapo c: HuapoList){
                        System.out.println(c.toString());
                    }
                }
            }

            //泥石流
            for(String tmp : prefix){
                List<Nishiliu> NishiliuList = op.read_NishiliuList(tmp + "/Nishiliu.json");
                if(NishiliuList != null){
                	NishiliuService.beifen();
                    NishiliuService.insertByJson(NishiliuList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Nishiliu c: NishiliuList){
                        System.out.println(c.toString());
                    }
                }
            }

            //岩溶塌陷
            for(String tmp : prefix){
                List<Yanrongtanta> YanrongtantaList = op.read_YanrongtantaList(tmp + "/Yanrongtanta.json");
                if(YanrongtantaList != null){
                	YanrongtantaService.beifen();
                    YanrongtantaService.insertByJson(YanrongtantaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Yanrongtanta c: YanrongtantaList){
                        System.out.println(c.toString());
                    }
                }
            }

            //地裂缝
            for(String tmp : prefix){
                List<Diliefeng> DiliefengList = op.read_DiliefengList(tmp + "/Diliefeng.json");
                if(DiliefengList != null){
                	DiliefengService.beifen();
                    DiliefengService.insertByJson(DiliefengList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Diliefeng c: DiliefengList){
                        System.out.println(c.toString());
                    }
                }
            }

            //地面沉降
            for(String tmp : prefix){
                List<Dimianchenjiang> DimianchenjiangList = op.read_DimianchenjiangList(tmp + "/Dimianchenjiang.json");
                if(DimianchenjiangList != null){
                	DimianchenjiangService.beifen();
                    DimianchenjiangService.insertByJson(DimianchenjiangList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(Dimianchenjiang c: DimianchenjiangList){
                        System.out.println(c.toString());
                    }
                }
            }

            //次生灾害其他
            for(String tmp : prefix){
                List<CishengzaihaiQita> CishengzaihaiQitaList = op.read_CishengzaihaiQitaList(tmp + "/CishengzaihaiQita.json");
                if(CishengzaihaiQitaList != null){
                	CishengzaihaiQitaService.beifen();
                    CishengzaihaiQitaService.insertByJson(CishengzaihaiQitaList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(CishengzaihaiQita c: CishengzaihaiQitaList){
                        System.out.println(c.toString());
                    }
                }
            }

            //基本震情
            for(String tmp : prefix){
                List<ZhenqingJiben> ZhenqingJibenList = op.read_ZhenqingJibenList(tmp + "/ZhenqingJiben.json");
                if(ZhenqingJibenList != null){
                	ZhenqingJibenService.beifen();
                    ZhenqingJibenService.insertByJson(ZhenqingJibenList);
                    System.out.println("上传数据已更新，数据如下：");
                    for(ZhenqingJiben c: ZhenqingJibenList){
                        System.out.println(c.toString());
                    }
                }
            }

            //灾情预测
            for(String tmp : prefix) {
                List<DisasterPrediction> disasterPredictionList = op.read_disasterPredictionList(tmp + "/disaster_prediction.json");
                if (disasterPredictionList != null) {
                	DisasterPredictionService.beifen();
                    DisasterPredictionService.insertByJson(disasterPredictionList);
                    System.out.println("上传数据已更新，数据如下：");
                    for (DisasterPrediction c : disasterPredictionList) {
                        System.out.println(c.toString());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
