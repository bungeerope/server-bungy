package org.bungee.rope.bungy.exception;

import org.bungy.rope.bungy.model.vo.IBaseResponseEnum;

/**
 * @author ZhihaoQuinn
 * @since 2020/8/8
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	protected IBaseResponseEnum baseResponseEnum;
}
