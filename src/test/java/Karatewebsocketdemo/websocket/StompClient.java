package Karatewebsocketdemo.websocket;

import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.function.Consumer;

public class StompClient {

    private static String URL = "ws://localhost:8080/handler/websocket";

    public void listen(Consumer consumer){
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MyMessageConverter());
        StompSessionHandler sessionHandler = new MyStompSessionHandler(consumer);
        stompClient.connect(URL, sessionHandler);
    }
}
