package org.bungee.rope.bungy.exception.handler;

import org.bungee.rope.bungy.exception.BaseException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author ZhihaoQuinn
 * @since 2020/8/9
 */
@Component
public class GlobalDefaultErrorAttributes extends DefaultErrorAttributes {

	/*
	 * 重写父类默认错误属性，如果是BaseException将重新封装错误属性值，否则返回默认值
	 */
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		if (getError(webRequest) instanceof BaseException) {
			BaseException be = (BaseException) getError(webRequest);
			errorAttributes.put("exception", be.getClass().getSimpleName());
			errorAttributes.put("message", be.getMessage());
			errorAttributes.put("status", be.getStatus());
			errorAttributes.put("error", be.getStatus().getReasonPhrase());
			return errorAttributes;
		}
		errorAttributes.put("exception", "SystemException");
		errorAttributes.put("message", "System Error , Check logs!");
		errorAttributes.put("status", "500");
		errorAttributes.put("error", " System Error ");
		return errorAttributes;
	}
}
