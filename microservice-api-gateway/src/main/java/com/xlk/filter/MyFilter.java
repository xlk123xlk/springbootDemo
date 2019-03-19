package com.xlk.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

//定义自己的过滤器
@Component
public class MyFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	//设置过滤条件
	@Override
	public boolean shouldFilter() {
		 return true;
	}

	//具体操作
	@Override
	public Object run() {
		//判断当前用户有没有登录
		RequestContext ctx = RequestContext.getCurrentContext();//获取当前容器context
		HttpServletRequest request = ctx.getRequest();
		Object aa = request.getSession().getAttribute("");
		Object bb = request.getParameter("id");
		if(bb == null) {
			log.warn("access token is empty");
			//过滤该请求，不往下级服务去转发请求，到此结束
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody("{\"result\":\"accessToken为空!\"}");
			ctx.getResponse().setContentType("text/html;charset=UTF-8");
			return null;
		}
		return null;
	}

	/*
	 * 
     * 返回过滤类型，有：pre，route，post，error
     * PRE：这种过滤器在请求被路由之前调用
     * ROUTING：这种过滤器将请求路由到微服务
     * POST：这种过滤器在路由到微服务以后执行
     * ERROR：在其他阶段发生错误时执行该过滤器
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	//返回过滤的优先级，数字越大，优先级越高，越早执行
	@Override
	public int filterOrder() {
		return 0;
	}

}
