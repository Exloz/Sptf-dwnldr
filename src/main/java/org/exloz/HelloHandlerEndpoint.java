package org.exloz;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HelloHandlerEndpoint implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        System.out.println("New request received");
        String response = "{\"test\": \"Hola Mundo\"}";
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        try (OutputStream os =exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
