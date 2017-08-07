
package com.zdsoft.webservice.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.zdsoft.webservice.namespace.userservice.IUserService;
import com.zdsoft.webservice.namespace.userservice.User;



/**
 * @author YuYang(zdsoft.yang@foxmail.com)
 *
 * @date 2014Äê5ÔÂ2ÈÕ
 */
@Component("userService")
public class UserServiceImpl implements IUserService {
	
	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);

	public String login(String username, String password) {
		LOG.info("Entered into UserServiceImpl method.");
		
		LOG.debug("username:" + username);
		LOG.debug("password:" + password);
		
		String info = "login failed.";
		
		if("scott".equals(username) && "tiger".equals(password)) {
			info = "login success.";
		}
		
		LOG.debug(info);
		LOG.info("Exit from UserServiceImpl method.");
		
		return info;
	}

	public User getUser(String username) {
		LOG.info("Entered into getUser method.");
		
		LOG.debug(username);
		
		User user = new User();
		user.setNickname(username + "--nickname");
		user.setPassword(username + "--password");
		user.setUsername(username + "--username");
		
		LOG.info("Exit from getUser method.");
		return user;
	}

}

