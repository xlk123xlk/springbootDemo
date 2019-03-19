package com.xlk.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter2 extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		
		return false;
	}

	@Override
	public Object run() {
		RequestContext cxt =  RequestContext.getCurrentContext();
		cxt.setResponseBody("进入后置过滤器");
		cxt.getResponse().setContentType("text/html;charset=UTF-8");
		int i = 1 / 0;
		return null;
	}

	@Override
	public String filterType() {
		
		return "post";
	}

	@Override
	public int filterOrder() {
		
		return 0;
	}

}
