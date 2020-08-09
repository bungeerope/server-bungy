package org.bungee.rope.bungy.exception.assertion;

import org.bungee.rope.bungy.exception.BaseException;
import org.bungee.rope.bungy.exception.sub.ArgumentException;
import org.bungy.rope.bungy.model.vo.IBaseResponseEnum;


/**
 * @author ZhihaoQuinn
 * @since 2020/8/9
 */
public interface CommonExceptionAssert extends IAssert, IBaseResponseEnum {

	@Override
	default BaseException newException() {
		return new ArgumentException(this);
	}

	@Override
	default BaseException newException(Throwable t) {
		return new ArgumentException(this, t);
	}
}
