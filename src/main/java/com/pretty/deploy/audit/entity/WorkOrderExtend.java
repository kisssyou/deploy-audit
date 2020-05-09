package com.pretty.deploy.audit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @description: 
 * @author haoxm
 * @date 2020/5/6 17:56
 */
/**
    * 工单扩展信息表
    */
@Data
@TableName(value = "TF_DEPLOY_AUDIT_WORK_ORDER_EXTEND")
public class WorkOrderExtend {
    /**
     * id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 工单编号
     */
    @TableField(value = "WORK_ORDER_NUMBER")
    private String workOrderNumber;

    /**
     * 下线时间
     */
    @TableField(value = "OFFLINE_TIME")
    private Date offlineTime;

    /**
     * 承载渠道
     */
    @TableField(value = "BEARER_CHAN")
    private String bearerChan;

    /**
     * 业务地址
     */
    @TableField(value = "BUSINESS_URL")
    private String businessUrl;

    /**
     * 业务办理接口
     */
    @TableField(value = "BUSINESS_INTF")
    private String businessIntf;

    /**
     * 业务ncode
     */
    @TableField(value = "BUSINESS_NCODE")
    private String businessNcode;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;
}