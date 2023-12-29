package com.lance.doc.biz.jdk13.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * file 13 test
 *
 * @author lance
 * @since 2023/12/25 09:55
 */
@Slf4j
class File13Tests {

  @Test
  void fileSystem() throws IOException {
    FileSystem fileSystem = FileSystems.getDefault();
    Iterable<Path> it = fileSystem.getRootDirectories();

    it.forEach(path -> log.info("===>{}", path.getFileName()));
    log.info("===>{}", it);

    Map<String, Boolean> map = Map.of("create", true);
    FileSystem logSystem = FileSystems.newFileSystem(Paths.get("/Users/lance/home/logs/a.txt"), map);
    logSystem.getFileStores().forEach(path -> log.info("===>log file: {}", path.name()));
  }
}
