hosts:
127.0.0.1       a.alucard.com
127.0.0.1       b.alucard.com
127.0.0.1       api.alucard.com
127.0.0.1       www.alucard.com

-----------------------------

禁止浏览器检查（此方法比较扯淡，根本不是解决的办法，掩耳盗铃）
chrome --disable-web-security --user-data-dir=c:\temp3

jsonp = json pending

https://docs.spring.io/spring/docs/5.0.x/spring-framework-reference/web.html#mvc-cors

As of Spring Framework 5.0.7, JSONP support is deprecated and will be removed as of Spring Framework 5.1, CORS should be used instead.

1.jsonp 返回的是script
如果参数里面有callback 就返回script给对方，之所以不是xhr所以能跨域

1.简单请求：
方法为：GET HEAD POST
请求header里面 无自定义头
Content-Type：
        text/plain
        multipart/form-data
        applcation/x-www-form-urlencoded
2.非简单请求：
    put delete方法的ajax请求
    发送json格式的ajax请求
    带自定义头的ajax请求


----nginx

server {
        listen       80;
        ##拦截域名地址
        server_name  api.alucard.com;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;
        ##拦截以/a开头的
        location /a {
            proxy_pass http://a.alucard.com:8080/;
            index  index.html index.htm;
        }
         ##拦截以/b开头的
        location /b {
            proxy_pass http://b.alucard.com:8081/;
            index  index.html index.htm;
        }