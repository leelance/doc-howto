package com.lance.doc.cmm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * book enums
 *
 * @author lance
 * @since 2023/12/5 00:28
 */
@Getter
@AllArgsConstructor
public enum BookEnums {
  /**
   * new_book
   */
  NEW_BOOK("new_book", "new book"),
  OLD_BOOK("old_book", "old book"),
  ;

  private final String type;
  private final String desc;
}
