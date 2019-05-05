package com.syx.bytcrm.form;

import com.syx.bytcrm.validator.group.A;
import com.syx.bytcrm.validator.group.B;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 牛东峰
 */
@Data
@ApiModel(value = "登录表单")
public class LoginForm {

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "请输入用户名", groups = A.class)
    private String loginName;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "请输入密码", groups = B.class)
    private String loginPwd;

}
