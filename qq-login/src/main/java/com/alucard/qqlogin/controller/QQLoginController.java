package com.alucard.qqlogin.controller;

import com.qq.connect.oauth.Oauth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.alucard.qqlogin.constants.Constants.ERROR_500_FTL;
import static com.alucard.qqlogin.constants.Constants.INDEX_FTL;

/**
 * @author sunxiji
 */
@Controller
public class QQLoginController {

    @RequestMapping("/qqAuth")
    public String qqAuth(HttpServletRequest request) {
        try {
            String authorizeURL = new Oauth().getAuthorizeURL(request);
            return "redirect:" + authorizeURL;
        } catch (Exception e) {
            return ERROR_500_FTL;
        }
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        return INDEX_FTL;
    }

    @RequestMapping("/qqLoginBack")
    public String qqLoginBack(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {
        return "success";
    }
}
