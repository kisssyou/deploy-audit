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
 * @date 2020/5/1 8:03
 */

/**
 * 工单信息表
 */
@Data
@TableName(value = "TF_DEPLOY_AUDIT_WORK_ORDER")
public class WorkOrder {
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
     * 工单名称
     */
    @TableField(value = "WORK_ORDER_NAME")
    private String workOrderName;

    /**
     * 开发负责人
     */
    @TableField(value = "DEVELOPER")
    private String developer;

    /**
     * 负责人
     */
    @TableField(value = "PRINCIPAL")
    private String principal;

    /**
     * 渠道
     */
    @TableField(value = "CHAN")
    private String chan;

    /**
     * 是否紧急版本: 0-否，1-是
     */
    @TableField(value = "URGENT_VERSION")
    private String urgentVersion;

    /**
     * 测试情况
     */
    @TableField(value = "TEST_SITUATION")
    private String testSituation;

    /**
     * 风险评估
     */
    @TableField(value = "RISK_ASSESSMENT")
    private String riskAssessment;

    /**
     * 备注
     */
    @TableField(value = "REMARK")
    private String remark;

    /**
     * 上线日期
     */
    @TableField(value = "ONLINE_DATE")
    private Date onlineDate;

    /**
     * 提交审核时间
     */
    @TableField(value = "SUBMIT_AUDIT_TIME")
    private Date submitAuditTime;

    /**
     * 审核结束时间
     */
    @TableField(value = "END_AUDIT_TIME")
    private Date endAuditTime;

    /**
     * 上线完成时间
     */
    @TableField(value = "END_ONLINE_TIME")
    private Date endOnlineTime;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;
}