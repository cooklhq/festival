package cn.bdqfork.web;

import cn.bdqfork.core.util.AnnotationUtils;
import cn.bdqfork.web.annotation.Auth;
import cn.bdqfork.web.annotation.PermitAll;
import cn.bdqfork.web.annotation.PermitAllowed;
import cn.bdqfork.web.annotation.RolesAllowed;
import io.vertx.reactivex.ext.web.handler.AuthHandler;

import java.lang.reflect.Method;

/**
 * @author bdq
 * @since 2020/1/27
 */
public class RouteAttribute {

    private Object bean;

    private String baseUrl;

    private Method routeMethod;

    private AuthHandler authHandler;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Method getRouteMethod() {
        return routeMethod;
    }

    public void setRouteMethod(Method routeMethod) {
        this.routeMethod = routeMethod;
    }

    public AuthHandler getAuthHandler() {
        return authHandler;
    }

    public void setAuthHandler(AuthHandler authHandler) {
        this.authHandler = authHandler;
    }

    public boolean requireAuth() {
        if (authHandler == null || AnnotationUtils.isAnnotationPresent(routeMethod, PermitAll.class)) {
            return false;
        }
        Class<?> beanClass = routeMethod.getDeclaringClass();
        return AnnotationUtils.isAnnotationPresent(beanClass, Auth.class)
                || AnnotationUtils.isAnnotationPresent(routeMethod, Auth.class);
    }

    public PermitAllowed getPermits() {
        if (authHandler != null && routeMethod.isAnnotationPresent(PermitAllowed.class)) {
            return routeMethod.getAnnotation(PermitAllowed.class);
        }
        return null;
    }

    public RolesAllowed getRoles() {
        if (authHandler != null && routeMethod.isAnnotationPresent(RolesAllowed.class)) {
            return routeMethod.getAnnotation(RolesAllowed.class);
        }
        return null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object bean;

        private String baseUrl;

        private Method routeMethod;

        private AuthHandler authHandler;

        public Builder setBean(Object bean) {
            this.bean = bean;
            return this;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder setRouteMethod(Method routeMethod) {
            this.routeMethod = routeMethod;
            return this;
        }

        public Builder setAuthHandler(AuthHandler authHandler) {
            this.authHandler = authHandler;
            return this;
        }

        public RouteAttribute build() {
            RouteAttribute attribute = new RouteAttribute();
            attribute.setBean(bean);
            attribute.setBaseUrl(baseUrl);
            attribute.setRouteMethod(routeMethod);
            attribute.setAuthHandler(authHandler);
            return attribute;
        }
    }
}
