package cn.bdqfork.web.route.annotation;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.handler.TimeoutHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 用于DELETE请求
 *
 * @author bdq
 * @since 2020/1/21
 */
@RouteMapping(method = HttpMethod.DELETE)
@Documented
@Retention(RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
public @interface DeleteMapping {
    String value();

    long timeout() default TimeoutHandler.DEFAULT_TIMEOUT;
}
