package com.syx.bytcrm.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 牛东峰
 */
@Configuration
@MapperScan(basePackages = {"com.syx.bytcrm.mapper"})
public class MybatisPlusConfiguration {

    /**
     * 分页插件<p>@MapperScan使用此注解来注册Mybatis映射器接口</p>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
