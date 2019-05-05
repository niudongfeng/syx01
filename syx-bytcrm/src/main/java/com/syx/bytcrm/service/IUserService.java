package com.syx.bytcrm.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syx.bytcrm.entity.User;
import com.syx.bytcrm.form.LoginForm;

/**
 * 用户表业务接口
 *
 * @author 牛东峰
 */
public interface IUserService extends IService<User> {

    /**
     * 用户登录
     *
     * @param loginForm 登录表单对象
     * @return 登录结果
     */
    R<User> login(LoginForm loginForm);

}
