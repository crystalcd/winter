package com.anpai.winter;

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

/**
 * @Author: crystalcd
 * @Description:
 * @Date: 2019/12/1 下午3:37
 */
public class App {
    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create().host("localhost").port(8080)
                        .route(routes ->
                                routes.get("/hello",
                                        (request, response) -> response.sendString(Mono.just("Hello World!")))
                                        .post("/echo",
                                                (request, response) -> response.send(request.receive().retain()))
                                        .get("/path/{param}",
                                                (request, response) -> response.sendString(Mono.just(request.param("param"))))
                                        .ws("/ws",
                                                (wsInbound, wsOutbound) -> wsOutbound.send(wsInbound.receive().retain())))
                        .bindNow();

        server.onDispose()
                .block();
    }
}
