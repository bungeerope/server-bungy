package org.bungee.rope.bungy.exception.sub;

import org.bungee.rope.bungy.exception.BaseException;
import org.bungy.rope.bungy.model.vo.IBaseResponseEnum;

/**
 * @author ZhihaoQuinn
 * @since 2020/8/9
 */
public class ArgumentException extends BaseException {

    public ArgumentException(IBaseResponseEnum baseResponseEnum) {
        super(baseResponseEnum);
    }

    public ArgumentException(IBaseResponseEnum baseResponseEnum, Throwable cause) {
        super(baseResponseEnum, cause);
    }
}
