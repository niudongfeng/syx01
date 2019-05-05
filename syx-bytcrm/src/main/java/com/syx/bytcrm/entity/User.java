package com.syx.bytcrm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体类
 *
 * @author 牛东峰
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId("user_id")
    private String userId;
    /**
     * 上级用户ID
     */
    @TableField("user_pid")
    private String userPid;
    /**
     * 所属组织编码
     */
    @TableField("org_code")
    private String orgCode;
    /**
     * 账号
     */
    @TableField("login_name")
    private String loginName;
    /**
     * 密码
     */
    @TableField("login_pwd")
    private String loginPwd;
    /**
     * 设备类型
     */
    @TableField("device_type")
    private Integer deviceType;
    /**
     * 设备号
     */
    @TableField("channel_id")
    private String channelId;
    /**
     * 用户等级
     */
    private Integer level;
    /**
     * 性别
     */
    private Boolean sex;
    /**
     * 头像
     */
    @TableField("head_img")
    private String headImg;
    /**
     * 真实名称
     */
    @TableField("real_name")
    private String realName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 证件类型
     */
    @TableField("idcard_type")
    private String idcardType;
    /**
     * 证件号码
     */
    @TableField("idcard_code")
    private String idcardCode;
    /**
     * 实名认证(0未认证1已认证2认证中3认证失败)
     */
    @TableField("is_check_real")
    private String isCheckReal;
    /**
     * 证件正面照片
     */
    @TableField("idcard_front_img")
    private String idcardFrontImg;
    /**
     * 证件反面照片
     */
    @TableField("idcard_back_img")
    private String idcardBackImg;
    /**
     * 实名认证失败原因
     */
    @TableField("check_real_cause")
    private String checkRealCause;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 微信号
     */
    @TableField("wechat_id")
    private String wechatId;
    /**
     * 微信OPENID
     */
    @TableField("wx_open_id")
    private String wxOpenId;
    /**
     * 微信昵称
     */
    @TableField("wx_nick_name")
    private String wxNickName;
    /**
     * 微信头像
     */
    @TableField("wx_head_img_url")
    private String wxHeadImgUrl;
    /**
     * 微信性别
     */
    @TableField("wx_sex")
    private String wxSex;
    /**
     * 微信国家
     */
    @TableField("wx_country")
    private String wxCountry;
    /**
     * 微信省
     */
    @TableField("wx_province")
    private String wxProvince;
    /**
     * 微信市
     */
    @TableField("wx_city")
    private String wxCity;
    /**
     * 微信用户特权信息
     */
    @TableField("wx_privilege")
    private String wxPrivilege;
    /**
     * 关注保险公司
     */
    private String company;
    /**
     * 公司地址
     */
    @TableField("company_addr")
    private String companyAddr;
    /**
     * 工作年限
     */
    @TableField("work_years")
    private Integer workYears;
    /**
     * 公司工号
     */
    @TableField("job_number")
    private String jobNumber;
    /**
     * 成长值
     */
    @TableField("growth_value")
    private Integer growthValue;
    /**
     * 短信剩余条数
     */
    @TableField("sms_number")
    private Integer smsNumber;
    /**
     * 是否有效
     */
    @TableField("valid_flag")
    private Boolean validFlag;
    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新人
     */
    @TableField("update_user")
    private String updateUser;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPid=" + userPid +
                ", orgCode=" + orgCode +
                ", loginName=" + loginName +
                ", loginPwd=" + loginPwd +
                ", deviceType=" + deviceType +
                ", channelId=" + channelId +
                ", level=" + level +
                ", sex=" + sex +
                ", headImg=" + headImg +
                ", realName=" + realName +
                ", phone=" + phone +
                ", idcardType=" + idcardType +
                ", idcardCode=" + idcardCode +
                ", checkRealFlag=" + isCheckReal +
                ", idcardFrontImg=" + idcardFrontImg +
                ", idcardBackImg=" + idcardBackImg +
                ", checkRealCause=" + checkRealCause +
                ", email=" + email +
                ", address=" + address +
                ", wxOpenId=" + wxOpenId +
                ", wxNickName=" + wxNickName +
                ", wxHeadImgUrl=" + wxHeadImgUrl +
                ", wxSex=" + wxSex +
                ", wxCountry=" + wxCountry +
                ", wxProvince=" + wxProvince +
                ", wxCity=" + wxCity +
                ", wxPrivilege=" + wxPrivilege +
                ", company=" + company +
                ", companyAddr=" + companyAddr +
                ", workYears=" + workYears +
                ", jobNumber=" + jobNumber +
                ", growthValue=" + growthValue +
                ", smsNumber=" + smsNumber +
                ", validFlag=" + validFlag +
                ", lastLoginTime=" + lastLoginTime +
                ", remark=" + remark +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", updateUser=" + updateUser +
                ", updateTime=" + updateTime +
                "}";
    }
}
