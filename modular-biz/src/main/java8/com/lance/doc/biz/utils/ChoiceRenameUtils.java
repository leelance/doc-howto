package com.lance.doc.biz.utils;

/**
 * ChoiceRenameUtils
 *
 * @author lance
 * @since 2023/12/5 14:08
 */
public class ChoiceRenameUtils {

  public static String dayOfWeek(int day) {
    switch (day) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        return "Weekday";
      case 6:
      case 7:
        return "Weekend";
      default:
        return "Invalid day of the week: " + day;
    }
  }
}
