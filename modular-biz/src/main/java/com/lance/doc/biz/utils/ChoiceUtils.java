package com.lance.doc.biz.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * ChoiceRenameUtils
 *
 * @author lance
 * @since 2023/12/5 14:08
 */
@Slf4j
@UtilityClass
public class ChoiceUtils {

  public static String dayOfWeek(int day) {
    return switch (day) {
      case 1, 2, 3, 4, 5 -> "Weekday";
      case 6, 7 -> "Weekend";
      default -> "Invalid day of the week: " + day;
    };
  }
}
