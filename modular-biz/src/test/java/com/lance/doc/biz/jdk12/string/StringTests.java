package com.lance.doc.biz.jdk12.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * String test
 *
 * @author lance
 * @since 2023/12/25 09:28
 */
@Slf4j
class StringTests {

  @Test
  @Disabled("file paths")
  void filePaths() throws IOException {
    Process process = Runtime.getRuntime().exec("/Users/lance/home/logs/test.sh");
    log.info("===>{}", process);
  }

  @Test
  void html() {
    String html = """
           <html>
              <body>
                 <p>Hello World.</p>
              </body>
           </html>
        """;
    log.info("===>{}", html.stripIndent());
  }
}
