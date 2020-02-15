package cn.bdqfork.web.server;

import io.reactivex.Completable;
import io.vertx.reactivex.core.AbstractVerticle;

/**
 * @author bdq
 * @since 2020/1/21
 */
public class WebVerticle extends AbstractVerticle {
    private WebServer webServer;

    public WebVerticle(WebServer webServer) {
        this.webServer = webServer;
    }

    @Override
    public Completable rxStart() {
        return Completable.fromAction(() -> webServer.start());
    }

    @Override
    public Completable rxStop() {
        return Completable.fromAction(() -> webServer.stop());
    }

}
