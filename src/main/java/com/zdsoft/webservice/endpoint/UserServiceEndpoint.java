package com.zdsoft.webservice.endpoint;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.zdsoft.webservice.namespace.userservice.GetUser;
import com.zdsoft.webservice.namespace.userservice.GetUserResponse;
import com.zdsoft.webservice.namespace.userservice.IUserService;
import com.zdsoft.webservice.namespace.userservice.Login;
import com.zdsoft.webservice.namespace.userservice.LoginResponse;
import com.zdsoft.webservice.namespace.userservice.User;


/**
 * @author YuYang(zdsoft.yang@foxmail.com)
 *
 * @date 2014年5月2日
 */

@Endpoint
public class UserServiceEndpoint {
	
	private static final Logger LOG = LogManager.getLogger(UserServiceEndpoint.class);
	
	//UserService.wsdl声明的命名空间
    public static final String USERVICE_NAMESPACE = "http://webservice.zdsoft.com/namespace/userservice";

	@Resource(name="userService")
	private IUserService userService;
	
	@PayloadRoot(namespace = USERVICE_NAMESPACE, localPart = "login")
	@ResponsePayload
	public LoginResponse handelLoginRequest(@RequestPayload Login request) {
		LOG.info("Entered into handelLoginRequest method.");
		
		String info = userService.login(request.getUsername(), request.getPassword());

		LoginResponse response = new LoginResponse();
		response.setInfo(info);
		
		LOG.info("Exit from handelLoginRequest method.");
		return response;
	}
	
	@PayloadRoot(namespace = USERVICE_NAMESPACE, localPart = "getUser")
	@ResponsePayload
	public GetUserResponse HandelGetUserRequest(@RequestPayload GetUser request) {
		LOG.info("Entered into HandelGetUserRequest method.");
		
		User user = userService.getUser(request.getUsername());
		
		GetUserResponse response = new GetUserResponse();
		response.setUser(user);
		
		LOG.info("Exit from  HandelGetUserRequest method.");
		return response;
	}
}