package Karatewebsocketdemo.websocket;

import com.intuit.karate.junit5.Karate;

public class WebsocketRunner {

    @Karate.Test
    Karate testUsers() {
        return Karate.run("websocket").relativeTo(getClass());
    }
}
