package com.xlk.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter3 extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() {
		RequestContext cxt = RequestContext.getCurrentContext();
		cxt.setResponseBody("出现异常");
		System.out.println("出现异常");
		return null;
	}

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
