package com.Interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class loginInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("拦截器销毁");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("拦截器启动");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String url = "";
		if (null != ServletActionContext.getRequest().getSession().getAttribute("username")) {
			url = arg0.invoke();
		}else{
			url = "loginfail";
		}
		;

		return url;
	}

}
