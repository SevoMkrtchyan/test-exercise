package util;

import java.time.Duration;

public class DateTimeHelper {

  public static String getReadableDuration(Duration duration) {
    return duration.toString()
        .substring(2)
        .replaceAll("(\\d[HMS])(?!$)", "$1 ")
        .toLowerCase();
  }

}
