package com.lance.doc.biz;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * JAR Packages Compatible with Multiple Versions
 *
 * @author lance
 * @since 2023/12/5 13:55
 */
@Slf4j
public class DateHelper {

  public static boolean checkIfLeapYear(String dateStr) {
    log.info("Checking for leap year using Java 9 Date Api");
    return LocalDate.parse(dateStr).isLeapYear();
  }
}
