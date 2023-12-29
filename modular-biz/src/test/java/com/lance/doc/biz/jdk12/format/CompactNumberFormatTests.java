package com.lance.doc.biz.jdk12.format;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 测试数据NumberFormat
 *
 * @author lance
 * @since 2023/12/21 18:14
 */
@Slf4j
class CompactNumberFormatTests {

  /**
   * generateCompactNumberFormats
   *
   * @return Map<String, NumberFormat>
   */
  Map<String, NumberFormat> generateCompactNumberFormats() {
    var numberFormats = new LinkedHashMap<String, NumberFormat>();
    numberFormats.put("zh_en/Long", NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.LONG));
    numberFormats.put("EN/Short", NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT));
    return numberFormats;
  }

  /**
   * generateFormats
   *
   * @param minFractionDigits int
   * @return Map<String, NumberFormat>
   */
  Map<String, NumberFormat> generateFormats(int minFractionDigits) {
    var numberFormats = generateCompactNumberFormats();
    numberFormats.forEach((label, numberFormat) -> numberFormat.setMinimumFractionDigits(minFractionDigits));
    return numberFormats;
  }

  /**
   * compactFormatting
   *
   * @param value long
   */
  void compactFormatting(long value) {
    final Map<String, NumberFormat> numberFormats = generateCompactNumberFormats();

    log.info("===>Compact Number Formatting on long '{}':", value);
    numberFormats.forEach((label, numberFormat) -> log.info("\t {}: {}", label, numberFormat.format(value)));
  }

  /**
   * compactFormatting
   *
   * @param value double
   */
  void compactFormatting(double value) {
    Map<String, NumberFormat> numberFormats = generateCompactNumberFormats();
    log.info("===>Compact Number Formatting on double '{}':", value);

    numberFormats.forEach((label, numberFormat) -> log.info("\t {}: {}", label, numberFormat.format(value)));
  }

  /**
   * 一位
   *
   * @param value value
   */
  void oneFractionalDigitMin(long value) {
    int minFractionDigits = 1;
    Map<String, NumberFormat> numberFormats = generateFormats(minFractionDigits);

    log.info("===?Compact Number Formatting on long '{}' with 1 minimum fraction digit:", value);
    numberFormats.forEach((label, numberFormat) -> log.info("\t {}: {}", label, numberFormat.format(value)));
  }

  /**
   * Invoke demonstrations of compact number formatting on {@code long}
   * values ranging from 15 to 15,000,000.
   */
  void onLongValues() {
    compactFormatting(15_000_000);
    compactFormatting(30_000);
  }

  /**
   * Invoke demonstrations of compact number formatting on {@code double}
   * values ranging from 15.0 to 15,000,000.0.
   */
  void onDoubleValues() {
    compactFormatting(15_000_000.0);
    compactFormatting(30_000_000_000.0);
  }

  /**
   * Invoke demonstrations of compact number formatting on {@code double}
   * values ranging from 15.0 to 15,000,000.0 and with a minimum fractional
   * digits of 1.
   */
  void onLongValuesWithMinFractionDigit() {
    oneFractionalDigitMin(15_000_000);
    oneFractionalDigitMin(2_000_000_000);
  }

  @Test
  void numberFormat() {
    onLongValues();
    onDoubleValues();
    onLongValuesWithMinFractionDigit();
  }
}
