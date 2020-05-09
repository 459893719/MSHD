package com.miaosha.demo;

import com.miaosha.demo.domain.Disaster;
import com.miaosha.demo.json.OperateJsonFile;
import com.miaosha.demo.service.DisasterService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReadDataTest {
    @Test
    public void testJsonread() {
        OperateJsonFile a = new OperateJsonFile();

        try {
            List<Disaster> tested = a.read("test.json");
            // 读取文件

            // 测试数据
            List<Disaster> test = new ArrayList<>();
            Disaster a1 = new Disaster("123456400000012001","2020-02-01","1",
                    "1","1","1","1","5");
            Disaster a2 = new Disaster("123456400000012002","2020-02-01 00:00:00","1",
                    "1","1","1","1","5");

            test.add(a1);
            test.add(a2);
            // 先判断长度是否相等
            boolean e = test.size()==tested.size();
            assertTrue(e);
            if(e) {
                // 判断是否一一相等
                for(int i=0;i<test.size();i++) {
                    assertTrue(test.get(i).toString().equals(tested.get(i).toString()));
                }
            }else {
                fail("内容条数不对等！");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            fail("DataRead has exception:"+e.getStackTrace());
        }
    }

    @Test
    public void testisDatasourceInput() {
        DisasterService a = new DisasterService();
        assertTrue(a.isDatasourceInput("www.baidu.com"));
        assertFalse(a.isDatasourceInput(""));
    }
}
