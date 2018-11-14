package com.alucard.config;

import com.alucard.entity.Permission;
import com.alucard.handler.MyAuthenticationFailureHandler;
import com.alucard.handler.MyAuthenticationSuccessHandler;
import com.alucard.mapper.PermissionMapper;
import com.alucard.security.MyUserDetailsService;
import com.alucard.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author alucard
 * @Description
 * @Date Create in 11:05 2018/11/13
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationFailureHandler failureHandler;
    @Autowired
    private MyAuthenticationSuccessHandler successHandler;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private PermissionMapper permissionMapper;
    // 用户认证信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 1.写死的方式
        // 设置用户账号信息和权限
//        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("addOrder");
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER")
//                .and()
//                .withUser("test").password("test123").roles("ADMIN");

        // 2.从数据库读的方式
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new PasswordEncoder() {

            // 加密的密码与数据库密码进行比对CharSequence rawPassword 表单字段 encodedPassword
            // 数据库加密字段
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                log.info("rawPassword:[{}],encodedPassword:[{}]",rawPassword , encodedPassword);
                // 返回true 表示认证成功 返回fasle 认证失败
                return MD5Util.encode((String) rawPassword).equals(encodedPassword);
            }

            // 对表单密码进行加密
            @Override
            public String encode(CharSequence rawPassword) {
                log.info("rawPassword:[{}]",rawPassword);
                return MD5Util.encode((String) rawPassword);
            }
        });
    }

    // 配置HttpSecurity 拦截资源
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 1. 写死的方式
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().formLogin();
//        http.formLogin().loginPage("/login").loginProcessingUrl("/login/form").failureUrl("/login-error").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
//                .and()
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .csrf().disable();

        // 2. 从数据库读的方式
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http
                .authorizeRequests();
        // 1.读取数据库权限列表
        List<Permission> listPermission = permissionMapper.findAllPermission();
        for (Permission permission : listPermission) {
            // 设置权限
            authorizeRequests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());
        }
        authorizeRequests.antMatchers("/login").permitAll().antMatchers("/**").fullyAuthenticated().and().formLogin()
                .loginPage("/login").successHandler(successHandler).and().csrf().disable();

    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
