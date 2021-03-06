package cn.bdqfork.web.route.filter;


import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bdq
 * @since 2020/1/28
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public FilterChain() {
    }

    public FilterChain(List<Filter> filters) {
        this.filters.addAll(filters);
    }

    public void registerFilter(Filter filter) {
        filters.add(filter);
    }

    public void doFilter(RoutingContext routingContext) throws Exception {
        doFilter(routingContext, this);
    }

    @Override
    public void doFilter(RoutingContext routingContext, FilterChain filterChain) throws Exception {
        if (index == filters.size()) {
            return;
        }
        filters.get(index++).doFilter(routingContext, filterChain);
    }
}
