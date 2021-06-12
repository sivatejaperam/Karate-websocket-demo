package Karatewebsocketdemo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.*;

import java.util.function.Consumer;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(MyStompSessionHandler.class);

    private Consumer handler;

    public MyStompSessionHandler(Consumer handler){
        this.handler = handler;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/greetings", this);
        logger.info("Subscribed to /topic/greetings");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received::" + payload);
        handler.accept(payload);
    }
}
