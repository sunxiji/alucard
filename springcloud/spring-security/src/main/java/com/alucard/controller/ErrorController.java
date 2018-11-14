package com.alucard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ErrorController {

	// 403权限不足页面
	@RequestMapping("/error/403")
	public String error403() {
		log.info("403权限不足");
		return "/error/403";
	}

}
