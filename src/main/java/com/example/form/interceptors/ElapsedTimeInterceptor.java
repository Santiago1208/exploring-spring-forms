package com.example.form.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("elapsedTimeInterceptor")
public class ElapsedTimeInterceptor implements HandlerInterceptor {

	private final static Logger logger = LoggerFactory.getLogger(ElapsedTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("Getting in preHandle()");
		logger.info("The handler is " + handler);
		if (handler instanceof HandlerMethod) {
			HandlerMethod controllerMethod = (HandlerMethod) handler;
			logger.info("This is the controller method " + controllerMethod.getMethod().getName());
		}
		// Elapsed time only for GET requests
		if (request.getMethod().equalsIgnoreCase("get")) {
			long initialTime = System.currentTimeMillis();
			request.setAttribute("initialTime", initialTime);
			Random random = new Random();
			Integer sleep = random.nextInt(100);
			Thread.sleep(sleep);
		}
		return true;

		/* 
		Use this only in the case when you must return false (neither interceptors and the handler method will be executed)
		response.sendRedirect(request.getContextPath().concat("the route you want"));
		return false;
		*/
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// Elapsed time only for GET requests
		if (request.getMethod().equalsIgnoreCase("get")) {
			long endTime = System.currentTimeMillis();
			long initialTime = (Long) request.getAttribute("initialTime");
			long elapsedTime = endTime - initialTime;
			if (handler instanceof HandlerMethod) {
				modelAndView.addObject("elapsedTime", elapsedTime);
			}
			logger.info("Elapsed time while loading view: " + elapsedTime + " ms");
			logger.info("Getting out from postHandle()");
		}
	}

}
