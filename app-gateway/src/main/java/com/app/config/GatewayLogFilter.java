package com.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author dc.yuan
 * @version 1.0
 * @date 2022-09-05 10:53
 */
@Component
public class GatewayLogFilter implements GlobalFilter, Ordered {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String beginTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        exchange.getAttributes().put("beginTime", beginTime);
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = Long.valueOf(exchange.getAttribute("beginTime"));
                    if (startTime != null) {
                        log.info("-----------Gateway打印日志开始-------------");
                        log.info("访问接口host: " + exchange.getRequest().getURI().getHost());
                        log.info("访问接口端口: " + exchange.getRequest().getURI().getPort());
                        log.info("访问接口URL: " + exchange.getRequest().getURI().getPath());
                        log.info("访问参数: " + exchange.getRequest().getURI().getRawQuery());
                        log.info("访问时间: " + (Long.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))) - startTime) + "ms");
                        log.info("-----------Gateway打印日志结束-------------");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return -100;
    }
}