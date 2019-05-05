package com.syx.bytcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.bytcrm.entity.User;
import com.syx.bytcrm.exp.UserNotFoundException;
import com.syx.bytcrm.form.LoginForm;
import com.syx.bytcrm.mapper.UserMapper;
import com.syx.bytcrm.result.ResultUtil;
import com.syx.bytcrm.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表业务实现类
 *
 * @author 牛东峰
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param loginForm 登录表单对象
     * @return 登录信息
     */
    @Override
    public R<User> login(LoginForm loginForm) {
        // 通过登录名查询用户
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("login_name", loginForm.getLoginName());
        User user = userMapper.selectOne(userWrapper);

        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }

        // 密码加密
        //loginForm.setLoginPwd(Md5Utils.md5(loginForm.getLoginPwd()));

        // 验证密码
        if (!user.getLoginPwd().equals(loginForm.getLoginPwd())) {
            throw new UserNotFoundException("您输入的用户名或密码有误！");
        }

        // 检查用户状态
        if (!user.getValidFlag()) {
            throw new UserNotFoundException("您的账号已被停用！");
        }

        return new R<User>().setCode(ResultUtil.SUCCESS_CODE).setMsg("登录成功").setData(user);
    }
}
