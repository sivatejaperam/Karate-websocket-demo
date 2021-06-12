Feature: Web socket Testing

  Background:
    * def StompClient = Java.type('Karatewebsocketdemo.websocket.StompClient')
    * def stompClient = new StompClient()
    * def handler = function(msg){ karate.signal(msg) }
    * stompClient.listen(karate.toJava(handler))
    * url 'http://localhost:8080/broadCast'

  Scenario: BroadCast controller should sent message on web socket
    * listen 500
    Given request {"content":"hello"}
    When method post
    Then status 200

    * listen 1000
    * json response = listenResult
    * match response == {"content":"hello"}
