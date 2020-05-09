package com.pretty.deploy.audit.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author haoxm
 * @description:
 * @date 2020/5/9 16:26
 */
@Data
public class WorkOrderDto {
    @Length(min = 1, max = 10, message = "工单编号")
    private String workOrderNumber;
}
