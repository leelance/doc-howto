package com.lance.doc.biz.jdk12.exp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * switch test
 *
 * @author lance
 * @since 2023/12/25 09:38
 */
@Slf4j
class SwitchTests {

  @Test
  void expression() {
    String yes = convert(State.YES);
    String no = convert(State.NO);

    log.info("===>yes: {}, no: {}", yes, no);
  }

  private String convert(State state) {
    return switch (state) {
      case YES -> "Yes";
      case NO -> "No";
    };
  }
}
