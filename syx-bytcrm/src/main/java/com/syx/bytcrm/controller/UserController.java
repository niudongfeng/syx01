package com.syx.bytcrm.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.syx.bytcrm.exp.ParameterFormatException;
import com.syx.bytcrm.form.LoginForm;
import com.syx.bytcrm.service.IUserService;
import com.syx.bytcrm.utils.RandomValidateCodeUtil;
import com.syx.bytcrm.validator.group.Group;
import com.syx.bytcrm.validator.util.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 牛东峰
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Api(tags = "UserController", description = "用户表控制器")
public class UserController {

    private final IUserService userService;

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(@RequestBody(required = false) LoginForm loginForm) throws Exception {

        // 验证登录参数
        ValidatorUtil.validate(loginForm, Group.class);

        // 调用业务登录
        return userService.login(loginForm);
    }

    /**
     * 生成验证码
     *
     * 前端获取验证码js
     * function getVerify(obj){
     *  obj.src = httpurl + "/mapper.system/getVerify?"+Math.random();
     * }
     */
    @RequestMapping(value = "/getVerify",method = RequestMethod.GET)
    @ApiOperation(value = "获取登录验证码")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            //输出验证码图片方法
            randomValidateCode.getRandCode(request, response);
        } catch (Exception e) {
            log.error("获取验证码失败>>>>   ", e);
        }
    }

    /**
     * 页面校验验证码
     */
    @RequestMapping(value = "/checkVerify", method = RequestMethod.POST, headers = "Accept=application/json")
    public boolean checkVerify(@RequestBody Map<String, Object> requestMap, HttpSession session) {
        try{
            //从session中获取随机数
            String inputStr = requestMap.get("inputStr").toString();
            String random = (String) session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
            if (random == null) {
                return false;
            }
            //验证大小写
            //if (random.equals(inputStr)) {
            //忽略大小写
            if(random.equalsIgnoreCase(inputStr)){
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            log.error("验证码校验失败", e);
            return false;
        }
    }

    //private final RedisUtil redisUtil;

//    @RequestMapping(value = "/save", method = RequestMethod.GET)
//    public R save() {
//
//        User user = new User()
//                .setUserId("16015341cfcb44acafa5e12024be98ef")
//                .setCompany("石家庄一");
//        //userService.updateById(user);
//
//
//        try {
//            redisUtil.set("niu", "123456");
//            //redisUtil.expire("niu", 60);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("11111111111");
//        }
//
//        return new R<User>().setCode(0).setMsg("保存成功").setData(user);
//    }

}
