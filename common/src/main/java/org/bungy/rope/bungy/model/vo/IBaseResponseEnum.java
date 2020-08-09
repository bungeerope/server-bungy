package org.bungy.rope.bungy.model.vo;

import org.springframework.http.HttpStatus;

/**
 * @author ZhihaoQuinn
 * @since 2020/8/8
 */
public interface IBaseResponseEnum {

	HttpStatus getCode();

	String getMsg();
}
