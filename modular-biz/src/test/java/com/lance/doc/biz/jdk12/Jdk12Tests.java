package com.lance.doc.biz.jdk12;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * jdk 12 test
 *
 * @author lance
 * @since 2023/12/21 17:07
 */
@Slf4j
class Jdk12Tests {

  @Test
  @Disabled("switch expression")
  void switchExpression() {
    int month = (int) (System.currentTimeMillis() % 12) + 1;
    log.info("===>month: {}", month);
    String season = switch (month) {
      case 12, 1, 2 -> "Winter";
      case 3, 4, 5 -> "Spring";
      case 6, 7, 8 -> "Summer";
      case 9, 10, 11 -> "Autumn";
      default -> {
        log.info("invalid month number");
        yield "invalid month number";
      }
    };
    log.info("===>season: {}", season);
  }

  @Test
  void numberFormat() {
    long money = 1703151549421L;
    NumberFormat format = NumberFormat.getInstance(Locale.CHINA);
    //1,703,151,245,237
    String num = format.format(money);
    log.info("===>format: {}", num);

    NumberFormat compactFormat = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.LONG);
    String compactNum = compactFormat.format(money);
    log.info("===>compactNum: {}", compactNum);

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
    String currencyNum = currencyFormat.format(money);
    log.info("===>currencyNum: {}", currencyNum);

    NumberFormat intFormat = NumberFormat.getIntegerInstance(Locale.CHINA);
    String intNum = intFormat.format(money);
    log.info("===>intNum: {}", intNum);

    NumberFormat percentFormat = NumberFormat.getPercentInstance(Locale.CHINA);
    String percentNum = percentFormat.format(0.3212);
    log.info("===>percentNum: {}", percentNum);

  }
}
