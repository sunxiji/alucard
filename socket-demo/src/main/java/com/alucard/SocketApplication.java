package com.alucard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketApplication {

    /**
     * 应用层  HTTP协议          HTTP
     * 传输层  TCP协议           TCP
     * 网络层  IP协议            IP
     * 链路层  以太网协议        网络
     *
     * 任何计算机语言通讯,底层都是用socket技术
     * JAVA,C#,C,Socket技术遵循一个规则 二进制+IP+端口号
     * socket网络编程 也有服务器端和客户端
     * socket分为两个非常核心 TCP UDP
     * TCP与UDP区别:
     * 1.UDP面向无连接-----不会建立连接 限制传输64K 不可靠协议
     * 2.TCP协议 面向连接协议 三次握手 字节流传输 效率没有UDP高
     * UDP效率比TCP协议高,TCP协议比UDP协议靠谱
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SocketApplication.class, args);
    }
}
