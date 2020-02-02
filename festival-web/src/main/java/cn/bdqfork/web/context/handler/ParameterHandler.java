package cn.bdqfork.web.context.handler;

import io.vertx.reactivex.ext.web.RoutingContext;

import java.lang.reflect.Parameter;

/**
 * @author bdq
 * @since 2020/1/31
 */
public interface ParameterHandler {
    Object[] handle(RoutingContext routingContext, Parameter[] parameters);
}