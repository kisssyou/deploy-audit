package com.pretty.deploy.audit.controller;

import com.pretty.deploy.audit.dto.WorkOrderDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author haoxm
 * @description: 工单相关接口
 * @date 2020/5/9 9:53
 */
@RestController()
@RequestMapping(value = "/work/order")
public class WorkOrderController {

    @RequestMapping("/dto")
    public WorkOrderDto dto(@Valid WorkOrderDto workOrderDto){
        return workOrderDto;
    }

}
