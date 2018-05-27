package com.example.springbootDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by wangdi on 2017/8/17.
 */

@Configuration
//注解开启使用STOMP协议来传输基于代理(message broker)的消息,这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册STOMP协议的节点(endpoint),并映射指定的url，这样浏览器直接通过这个地址建立websocket连接
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //这里设置的simple broker是指可以订阅的地址，也就是服务器可以发送的地址
        config.enableSimpleBroker("/topic");
        //这个配置的是服务器订阅消息的前缀，比如@MessageMapping("/hello-socket")，浏览器端发送消息地址就是app/hello-socket;
        config.setApplicationDestinationPrefixes("/app");
    }
}
