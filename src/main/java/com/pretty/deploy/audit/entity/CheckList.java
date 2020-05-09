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
 * @date 2020/5/7 9:58
 */
/**
    * 上线自检列表
    */
@Data
@TableName(value = "TF_DEPLOY_AUDIT_CHECK_LIST")
public class CheckList {
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
     * 文案一致性
     */
    @TableField(value = "PAGE_CONSISTENCY")
    private String pageConsistency;

    /**
     * 提示一致性
     */
    @TableField(value = "PROMPT_CONSISTENCY")
    private String promptConsistency;

    /**
     * 查询一致性
     */
    @TableField(value = "INQUIRE_CONSISTENCY")
    private String inquireConsistency;

    /**
     * 扣费一致性
     */
    @TableField(value = "DEDUCTION_CONSISTENCY")
    private String deductionConsistency;

    /**
     * 未登录预览
     */
    @TableField(value = "NO_LOGIN_PREVIEW")
    private String noLoginPreview;

    /**
     * 预校验
     */
    @TableField(value = "PRE_VERIFICATION")
    private String preVerification;

    /**
     * 提示语
     */
    @TableField(value = "HINT")
    private String hint;

    /**
     * 二次确认
     */
    @TableField(value = "SECOND_CONFIRMATION")
    private String secondConfirmation;

    /**
     * 退订功能
     */
    @TableField(value = "UNSUBSCRIBE")
    private String unsubscribe;

    /**
     * 访问日志
     */
    @TableField(value = "ACCESS_LOG")
    private String accessLog;

    /**
     * 二次确认
     */
    @TableField(value = "SECOND_CONFIRMATION_LOG")
    private String secondConfirmationLog;

    /**
     * 办理日志
     */
    @TableField(value = "HANDLE_LOG")
    private String handleLog;

    /**
     * 接口报文
     */
    @TableField(value = "INTERFACE_MESSAGE")
    private String interfaceMessage;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;
}