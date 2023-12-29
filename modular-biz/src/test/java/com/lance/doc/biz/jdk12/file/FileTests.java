package com.lance.doc.biz.jdk12.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
class FileTests {

  @Test
  void fileMatch() throws IOException {
    String filename1 = "/Users/lance/home/logs/test.sh";
    String filename2 = "/Users/lance/home/logs/.DS_Store";

    Path filePath1 = Path.of(filename1);
    Path filePath2 = Path.of(filename2);


    log.info("files: {} and {} = {}", filePath1.getFileName(), filePath2.getFileName(), Files.isSameFile(filePath1, filePath2));
    log.info("files: {} and {} = {}", filePath1.getFileName(), filePath2.getFileName(), Files.mismatch(filePath1, filePath2));

  }
}
