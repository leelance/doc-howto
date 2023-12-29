package com.lance.doc.biz.jdk13.exp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * switch test
 *
 * @author lance
 * @since 2023/12/25 09:38
 */
@Slf4j
class Switch13Tests {

  @Test
  void expression() {
    String three = convert(3);
    String ten = convert(10);
    String oneHand = convert(100);

    log.info("===>3 is: {}, 10 is: {}, 100 is: {}", three, ten, oneHand);
  }

  private String convert(int num) {
    return switch (num) {
      case 0 -> {
        log.info("===>{}", num);
        yield "zero";
      }
      case 1, 3, 5, 7, 9 -> {
        log.info("===>1, 3, 5, 7, 9 is even");
        yield "even";
      }
      case 2, 4, 6, 8, 10 -> "odd";
      default -> "default";
    };
  }
}
