package com.alucard.controller;

import com.alucard.entity.User;
import com.alucard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request){
		User resultUser=userService.login(user);
		if(resultUser==null){
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "错误");
			return "index";
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "redirect:/success.jsp";
		}
	}
	@ResponseBody
	@RequestMapping("/page/{currPage}/{pageSize}")
	public List<User> getUsersByPage(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize) {
		List<User> userList = userService.queryUsersByPage(currPage, pageSize);
		return userList;
	}
}
