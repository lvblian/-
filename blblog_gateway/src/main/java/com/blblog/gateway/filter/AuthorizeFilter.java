package com.blblog.gateway.filter;

import com.blblog.gateway.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    //令牌头名字
    private static final String AUTHORIZE_TOKEN = "Authorization";
    /***
     * 全局过滤器
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取Request、Response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获取请求的URI
        String path = request.getURI().getPath();

        //如果是登录、goods等开放的微服务[这里的goods部分开放],则直接放行,这里不做完整演示，完整演示需要设计一套权限系统
        if (path.startsWith("/api/user/login")) {
            //放行
            Mono<Void> filter = chain.filter(exchange);
            return filter;
        }

        //获取头文件中的令牌信息
        String tokent = request.getHeaders().getFirst(AUTHORIZE_TOKEN);
        Boolean hastoken = true;
        //如果头文件中没有，则从请求参数中获取
        if (StringUtils.isEmpty(tokent)) {
            tokent = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
            hastoken = false;

        }
        //从cookie在获取
        if (StringUtils.isEmpty(tokent)) {
            HttpCookie httpCookie = request.getCookies().getFirst(AUTHORIZE_TOKEN);
            if (httpCookie != null) {
                tokent = httpCookie.getValue();
            }
        }
        //如果为空，则输出错误代码
        if (StringUtils.isEmpty(tokent)) {
            //设置方法不允许被访问，405错误代码
            response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED);
            return response.setComplete();
        }else {
            if (!hastoken) {
                if (!tokent.startsWith("bearer ") && !tokent.startsWith("Bearer ")) {
                    tokent = "bearer "+tokent;
                }
                request.mutate().header(AUTHORIZE_TOKEN,tokent);
            }
        }

        //解析令牌数据
//        try {
//            Claims claims = JwtUtil.parseJWT(tokent);
//        } catch (Exception e) {
//            e.printStackTrace();
//            //解析失败，响应401错误
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }

        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

