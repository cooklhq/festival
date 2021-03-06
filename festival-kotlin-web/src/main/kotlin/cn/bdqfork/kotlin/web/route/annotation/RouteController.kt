package cn.bdqfork.kotlin.web.route.annotation

import cn.bdqfork.core.annotation.Optimize
import javax.inject.Named

/**
 * @author bdq
 * @since 2020/1/29
 */
@Optimize
@Named
@RouteMapping
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class RouteController(val value: String = "")