package com.lance.doc.biz.web;

import com.lance.doc.cmm.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * index controller
 *
 * @author lance
 * @since 2023/12/5 09:24
 */
@Slf4j
@RestController
public class IndexController {

  @GetMapping("index")
  public Book index() {
    String name = "Hello world";
    String author = "Jim Green";
    return new Book(name, author);
  }
}
