package org.exloz;

public class Main {
  public static void main(String[] args) {
    HttpClientHandler newHandler = new HttpClientHandler();
    newHandler.fetchData();
    HttpServerHandler newServer = new HttpServerHandler();
    newServer.startServer();
  }
}
