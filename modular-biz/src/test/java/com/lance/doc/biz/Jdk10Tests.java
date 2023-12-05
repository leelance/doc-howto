package com.lance.doc.biz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * jdk 10
 *
 * @author lance
 * @since 2023/12/5 23:14
 */
@Slf4j
class Jdk10Tests {

  @Test
  @Disabled("local var")
  void localVariable() {
    var bookName = "Java book.";
    log.info("===>{}", bookName.getClass());

    var balls = List.of("football", "basketball");
    log.info("===>{}", balls.getClass());
  }

  @Test
  @Disabled("immutable list")
  void immutableCollection() {
    List<String> list = Arrays.asList("Red", "Green", "Yellow");

    var imList = list.stream().collect(Collectors.toUnmodifiableList());
    log.info("===>{}", imList.getClass());

    var toList = list.stream().toList();
    log.info("===>{}", toList.getClass());

    var thenList = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    log.info("===>{}", thenList.getClass());
  }

  @Test
  void orElseThrow() {
    //Optional<String> optional = Optional.of("hello world");
    Optional<String> optional = Optional.empty();
    var result = optional.orElseThrow(RuntimeException::new);

    log.info("===>{}", result);
  }
}
