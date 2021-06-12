package Karatewebsocketdemo.websocket;

import org.springframework.messaging.Message;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.util.MimeType;


/**
 *
 * You can use StringMessageConverter , MappingJackson2MessageConverter, or any other message converters.
 * that fits your needs. or you can override AbstractMessageConverter and implement your own message converter
 */
public class MyMessageConverter extends AbstractMessageConverter {

    public MyMessageConverter() {
        super(new MimeType("application", "json"));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return true;
    }

    protected Object convertFromInternal(Message<?> message, Class<?> targetClass,  Object conversionHint) {
        Object payload = message.getPayload();
        return payload instanceof String ? payload : new String((byte[])((byte[])payload));
    }
}
