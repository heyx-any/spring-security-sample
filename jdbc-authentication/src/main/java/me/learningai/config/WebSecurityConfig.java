package me.learningai.config;

import me.learningai.security.core.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring security 配置.
 * @author heyx
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置自定义UserDetailService,用以从数据库加载用户信息
        auth.userDetailsService(springDataUserDetailsService())
            //设置密码加密
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            //允许swagger 文档匿名访问
            .antMatchers("/swagger*/**","/v2/**", "/webjars/**").permitAll()
            //设置其他所有请求都需认证
            .anyRequest().authenticated()
            .and()
            .formLogin().defaultSuccessUrl("/user/me");

    }

    @Bean
    public SpringDataUserDetailsService springDataUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

}