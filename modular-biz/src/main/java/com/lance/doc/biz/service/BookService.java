package com.lance.doc.biz.service;

import com.lance.doc.cmm.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * book service
 *
 * @author lance
 * @since 2023/12/5 00:37
 */
@Slf4j
@Service
public class BookService {

  public Book get(){
    log.info("====>This is a get method.");
    return new Book("Java Book", "James Gosling");
  }
}
