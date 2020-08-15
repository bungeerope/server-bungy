package org.bungee.rope.bungy.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author ZhihaoQuinn
 * @since 2020/8/9
 */
@Slf4j
@Component
@Order(-2) // 标记AspectJ的切面程序，值越小拥有越高的优先级，这里设置较高的优先级。
public class SysExceptionHandler extends AbstractErrorWebExceptionHandler { // AbstractErrorWebExceptionHandler，此抽象类用来拓展与实现全局错误处理

    /*
     * 构造函数将GlobalDefaultErrorAttributes全局异常属性实现类的值设置到AbstractErrorWebExceptionHandler抽象类的局部变量中去
     */
    public SysExceptionHandler(GlobalDefaultErrorAttributes errorAttributes, ApplicationContext applicationContext,
                               ServerCodecConfigurer serverCodecConfigurer) {
        super((ErrorAttributes) errorAttributes, new ResourceProperties(), applicationContext);
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        super.setMessageReaders(serverCodecConfigurer.getReaders());
    }

    /*
     * 重写getRoutingFunction方法，设置对应的RequestPredicates、Mono服务响应对象
     */
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(final ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    /*
     * 将全局异常属性值设置到新的ServerResponse中
     */
    private Mono<ServerResponse> renderErrorResponse(final ServerRequest request) {
        final Map<String, Object> errorPropertiesMap = getErrorAttributes(request, false);
        return ServerResponse.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromValue(errorPropertiesMap));
    }
}
