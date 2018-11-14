package com.alucard.security;

import com.alucard.entity.Permission;
import com.alucard.entity.User;
import com.alucard.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 设置动态用户信息
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 1.根据用户名称查询数据用户信息
		User user = userMapper.findByUsername(username);
		// 2.底层会根据数据库查询用户信息，判断密码是否正确
		// 3. 给用户设置权限
		List<Permission> listPermission = userMapper.findPermissionByUsername(username);
		log.info("username:[{}],对应权限:[{}]" , username ,listPermission.toString());
		if (listPermission != null && listPermission.size() > 0) {
			// 定义用户权限
			List<GrantedAuthority> authorities = new ArrayList<>();
			for (Permission permission : listPermission) {
				authorities.add(new SimpleGrantedAuthority(permission.getPermTag()));
			}
			user.setAuthorities(authorities);
		}
		return user;
	}

}
