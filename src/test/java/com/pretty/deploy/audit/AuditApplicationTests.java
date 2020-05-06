package com.pretty.deploy.audit;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pretty.deploy.audit.entity.WorkOrder;
import com.pretty.deploy.audit.mapper.WorkOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
class AuditApplicationTests {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Test
    void contextLoads() {
        log.info("dddddddddddddddddd");
        QueryWrapper wrapper = new QueryWrapper();
        if (workOrderMapper == null){
            log.info("nulllllllll");
        }
        WorkOrder workOrders = workOrderMapper.selectOne(wrapper);
        log.info("workOrders:{}", JSON.toJSONString(workOrders));

    }

}
