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
    @Scheduled(fixedDelay = 1200000)  //间隔1分钟
    public void first() throws InterruptedException {
        try {
            //死亡
            for(String tmp : prefix){
                List<DeathStatistics> deathStatisticsList = op.read_deathStatisticsList(tmp + "/death_statistics.json");
                if(deathStatisticsList != null) {
                	DeathStatisticsService.beifen();
                	for(int i=0;i<deathStatisticsList.size();i++) {
                		String a = deathStatisticsList.get(i).getReporting_unit();
                		deathStatisticsList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<shoushangList.size();i++) {
                		String a = shoushangList.get(i).getReporting_unit();
                		shoushangList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<ShizongList.size();i++) {
                		String a = ShizongList.get(i).getReporting_unit();
                		ShizongList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<civilStructureList.size();i++) {
                		String a = civilStructureList.get(i).getReporting_unit();
                		civilStructureList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<ZhuanmuList.size();i++) {
                		String a = ZhuanmuList.get(i).getReporting_unit();
                		ZhuanmuList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<ZhuanhunList.size();i++) {
                		String a = ZhuanhunList.get(i).getReporting_unit();
                		ZhuanhunList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<KuangjiaList.size();i++) {
                		String a = KuangjiaList.get(i).getReporting_unit();
                		KuangjiaList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<FangwuQitaList.size();i++) {
                		String a = FangwuQitaList.get(i).getReporting_unit();
                		FangwuQitaList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<JiaotongList.size();i++) {
                		String a = JiaotongList.get(i).getReporting_unit();
                		JiaotongList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<GongshuiList.size();i++) {
                		String a = GongshuiList.get(i).getReporting_unit();
                		GongshuiList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<ShuyouList.size();i++) {
                		String a = ShuyouList.get(i).getReporting_unit();
                		ShuyouList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<RanqiList.size();i++) {
                		String a = RanqiList.get(i).getReporting_unit();
                		RanqiList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<DianliList.size();i++) {
                		String a = DianliList.get(i).getReporting_unit();
                		DianliList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<disasterList.size();i++) {
                		String a = disasterList.get(i).getReporting_unit();
                		disasterList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<ShuiliList.size();i++) {
                		String a = ShuiliList.get(i).getReporting_unit();
                		ShuiliList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<collapseRecordList.size();i++) {
                		String a = collapseRecordList.get(i).getReporting_unit();
                		collapseRecordList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<HuapoList.size();i++) {
                		String a = HuapoList.get(i).getReporting_unit();
                		HuapoList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<NishiliuList.size();i++) {
                		String a = NishiliuList.get(i).getReporting_unit();
                		NishiliuList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<YanrongtantaList.size();i++) {
                		String a = YanrongtantaList.get(i).getReporting_unit();
                		YanrongtantaList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<DiliefengList.size();i++) {
                		String a = DiliefengList.get(i).getReporting_unit();
                		DiliefengList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<DimianchenjiangList.size();i++) {
                		String a = DimianchenjiangList.get(i).getReporting_unit();
                		DimianchenjiangList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<CishengzaihaiQitaList.size();i++) {
                		String a = CishengzaihaiQitaList.get(i).getReporting_unit();
                		CishengzaihaiQitaList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<ZhenqingJibenList.size();i++) {
                		String a = ZhenqingJibenList.get(i).getReporting_unit();
                		ZhenqingJibenList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
                	for(int i=0;i<disasterPredictionList.size();i++) {
                		String a = disasterPredictionList.get(i).getReporting_unit();
                		disasterPredictionList.get(i).setReporting_unit(tmp+"_"+a);
                	}
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
