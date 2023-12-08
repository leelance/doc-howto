package com.lance.doc.biz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk 11 test
 *
 * @author lance
 * @since 2023/12/8 10:49
 */
@Slf4j
class Jdk11Tests {

  @Test
  @Disabled("repeat")
  void repeat() {
    String text = "hello";
    String item = text.repeat(4);
    log.info("===>repeat: {}", item);
    Assertions.assertNotNull(item);

    //\r\n
    String books = """
        Java
        Spring
        Scala
        """;
    Stream<String> lines = books.lines();
    log.info("===>lines: {}", lines.collect(Collectors.joining(",")));

    //strip, Returns a string whose value is this string, with all leading and trailing white space removed.
    log.info("===>strip: {}", books.strip());
    log.info("===>strip lead: {}", books.stripLeading());
    log.info("===>strip trail: {}", books.stripTrailing());

    boolean isNull = "".isBlank();
    boolean isEmpty = "".isEmpty();
    log.info("===>is null: {}, is empty: {}", isNull, isEmpty);
  }

  @Test
  void lambdaVar() {
    Consumer<String> consumer = (@NonNull var a) -> log.info("===>{}", a);
    Assertions.assertNotNull(consumer);

    Supplier<Long> supplier = System::nanoTime;
    Assertions.assertNotNull(supplier);

    Function<String, Long> function = (@NonNull var item) -> item.length() * 1000L;
    Assertions.assertNotNull(function);

    Predicate<String> predicate = (var s) -> s.length() > 0;
    Assertions.assertNotNull(predicate);

    BiConsumer<String, Long> biConsumer = (var s, var num) -> log.info("===>{}", s.length() > 0 && num > 10);
    Assertions.assertNotNull(biConsumer);

    BiFunction<String, String, Long> biFunction = (@NonNull var s, @NonNull var h) -> s.length() + h.length() + 1L;
    Assertions.assertNotNull(biFunction);

    BinaryOperator<String> binaryOperator = (var s, var h) -> s.length() + h;
    Assertions.assertNotNull(binaryOperator);
  }
}
