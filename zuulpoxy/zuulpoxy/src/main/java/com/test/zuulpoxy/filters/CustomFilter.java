package com.test.zuulpoxy.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.slf4j.internal.LoggerFactory;

public class CustomFilter extends ZuulFilter {

	private static Logger logger = (Logger) LoggerFactory.getLogger(CustomFilter.class);
	
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest httpServletReq = context.getRequest();
		logger.info(String.format("%s request to s", httpServletReq.getMethod(), httpServletReq.getRequestURL()));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
