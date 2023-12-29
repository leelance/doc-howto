package com.lance.doc.biz.jdk13.str;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * string 13 test
 *
 * @author lance
 * @since 2023/12/25 09:52
 */
@Slf4j
class String13Tests {

  @Test
  void textBlock() {
    String json = """
        {"name": "Java", "Lang": "zh", "age": 18}
        """;

    log.info("===>{}", json);
  }
}
