package org.exloz;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServerHandler {

    public void startServer() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

            httpServer.createContext("/hello", new HelloHandlerEndpoint());

            //TODO: Hacerlo mejor en otra clase
//            httpServer.createContext("/echo", exchange -> {
//                if ("POST".equals(exchange.getRequestMethod())) {
//                    String body = new String(exchange.getRequestBody().readAllBytes());
//                    String response = "Recibí: " + body;
//                    exchange.sendResponseHeaders(200, response.getBytes().length);
//                    try (OutputStream os = exchange.getResponseBody()) {
//                        os.write(response.getBytes());
//                    }
//                } else {
//                    exchange.sendResponseHeaders(405, -1); // Method Not Allowed
//                }
//            });


            httpServer.setExecutor(null);
            httpServer.start();

            System.out.println("Servidor funcionando correctamente en el puerto 8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
