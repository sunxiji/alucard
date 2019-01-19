package com.alucard.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.junit.Test;

public class IniRealmTest {
    /**
     * 读取user.ini初始化文件(个人感觉生产不会用到)
     */
    @Test
    public void testAuthentication() {

        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        //1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("alucard", "123456");
        subject.login(token);

//        System.out.println("isAuthenticated:"+subject.isAuthenticated());
        Assert.isTrue(subject.isAuthenticated());
        subject.checkPermission("user:delete");
        subject.checkRole("admin");

    }
}
