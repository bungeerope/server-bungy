package org.bungee.rope.bungy.exception;

import org.bungy.rope.bungy.model.vo.IBaseResponseEnum;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author ZhihaoQuinn
 * @since 2020/8/8
 */
public class BaseException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public BaseException(IBaseResponseEnum baseResponseEnum) {
		super(baseResponseEnum.getCode(), baseResponseEnum.getMsg());
	}

	public BaseException(IBaseResponseEnum baseResponseEnum, Throwable cause) {
		super(baseResponseEnum.getCode(), baseResponseEnum.getMsg(), cause);
	}

}
