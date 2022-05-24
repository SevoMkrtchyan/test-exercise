package util;

import java.time.Duration;
import java.util.OptionalDouble;
import manager.Tickets;
import model.Ticket;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public class FlightInfoUtil {

  public static Duration getAverage(Tickets tickets, String originName,
      String destinationName) {
    OptionalDouble avg = tickets
        .getTickets()
        .stream()
        .filter(ticket -> {
          if (ticket.getOrigin_name().equals(originName)
              && ticket.getDestination_name().equals(destinationName)) {
            return true;
          } else {
            return ticket.getOrigin_name().equals(destinationName)
                && ticket.getDestination_name().equals(originName);
          }
        }).map(Ticket::getDuration)
        .mapToDouble(Duration::getSeconds)
        .average();
    if (avg.isPresent()) {
      return Duration.ofSeconds((long) avg.getAsDouble());
    } else {
      return Duration.ZERO;
    }
  }

  public static Duration getPercentile(Tickets tickets, double percentileValue,
      String originName, String destinationName) {

    double[] array = tickets
        .getTickets()
        .stream()
        .filter(ticket -> {
          if (ticket.getOrigin_name().equals(originName)
              && ticket.getDestination_name().equals(destinationName)) {
            return true;
          } else {
            return ticket.getOrigin_name().equals(destinationName)
                && ticket.getDestination_name().equals(originName);
          }
        }).map(Ticket::getDuration)
        .mapToDouble(Duration::getSeconds)
        .toArray();
    Percentile percentile = new Percentile();
    percentile.setData(array);
    return Duration.ofSeconds((long) percentile.evaluate(percentileValue));
  }

}
