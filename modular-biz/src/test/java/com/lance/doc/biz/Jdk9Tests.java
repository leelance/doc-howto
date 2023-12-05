package com.lance.doc.biz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk9 test
 *
 * @author lance
 * @since 2023/12/5 13:25
 */
@Slf4j
class Jdk9Tests {

  @Test
  @Disabled("of")
  void of() {
    List<String> colors = List.of("red", "green", "yellow", "black");
    log.info("===>color: {}", colors);

    Set<Integer> nums = Set.of(1, 2, 3, 4, 5);
    log.info("===>num: {}", nums);

    Map<String, Object> ganders = Map.of("1", "man", "2", "female");
    log.info("===>ganders: {}", ganders);

    Map<String, Object> books = Map.ofEntries(Map.entry("Java", "jdk17"), Map.entry("redis", "v6.0.2"));
    log.info("===>books: {}", books);
  }

  @Test
  @Disabled("option")
  void option() {
    //ifPresentOrElse
    Optional<String> optional = Optional.of("Hello world.");
    optional.ifPresentOrElse(
        val -> log.info("===>Value: {}", val),
        () -> log.info("===>Value is null")
    );

    // OR
    Optional<String> first = Optional.empty();
    Optional<String> second = Optional.of("Hello world");

    Optional<String> result = first.or(() -> second);
    log.info("===>result: {}", result.get());

    // Stream
    Optional<String> optionalValue = Optional.of("Hello");
    optionalValue.stream().forEach(s -> log.info("===>{}", s));
  }

  @Test
  @Disabled("read data")
  void readData() throws FileNotFoundException {
    FileOutputStream fos = new FileOutputStream("hello.txt");
    try (fos) {
      fos.write("Hello world.".getBytes());
    } catch (IOException e) {
      log.error("===>read file fail: ", e);
    }
  }

  @Test
  @Disabled("take while")
  void takeWhile() {
    List<String> chars = List.of("a", "b", "c", "", "e", "f");
    // abc
    String take = chars.stream().takeWhile(s -> !s.isBlank()).collect(Collectors.joining());
    //ef
    String drop = chars.stream().dropWhile(s -> !s.isBlank()).collect(Collectors.joining());

    log.info("===>take: {}", take);
    log.info("===>drop: {}", drop);

    Stream<String> stream = Stream.ofNullable("Hello world");
    Stream<String> nullStream = Stream.ofNullable(null);

    //02468
    String nums = Stream.iterate(0, n -> n < 10, n -> n + 2).map(String::valueOf).collect(Collectors.joining());
    log.info("===>nums: {}", nums);
  }

  @Test
  void httpClient() throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("https://postman-echo.com/get"))
        .version(HttpClient.Version.HTTP_2)
        .header("x-traceId", "100000001")
        .timeout(Duration.ofSeconds(10L))
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    log.info("===>response code: {}", response.statusCode());
    log.info("===>response body: {}", response.body());

    HttpClient httpClient = HttpClient.newHttpClient();
    WebSocket webSocket = httpClient.newWebSocketBuilder()
        .buildAsync(URI.create("wss://127.0.0.1:9001"), new WebSocketListener())
        .get();

    webSocket.sendText("Hello, WebSocket!", true);
    webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "Goodbye!");
  }

  static class WebSocketListener implements WebSocket.Listener {
    @Override
    public void onOpen(WebSocket webSocket) {
      log.info("===>websocket opened");
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
      log.info("===>Received message: {}", data);
      return null;
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
      log.info("===>websocket closed with status code: {}", statusCode);
      return null;
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
      log.info("===>websocket fail:", error);
    }
  }

  interface Encode {
    /**
     * Public abstract method (default in pre-Java 8 interfaces)
     */
    void encode();

    /**
     * Public default method (introduced in Java 8)
     */
    default void base64Encode(String data) {
      //Default method in interface
      privateMethod(data);
    }

    /**
     * Private method (introduced in Java 9)
     */
    private void privateMethod(String data) {
      Base64.getEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }
  }
}
