import manager.Tickets;
import util.DateTimeHelper;
import util.FlightInfoUtil;
import util.TicketsFromJsonParser;

public class Main {

  public static void main(String[] args) {
    Tickets tickets = new Tickets();
    try {
      final String path = "src/main/resources/tickets.json";
      tickets = TicketsFromJsonParser.parse(path);
    } catch (Exception e) {
      System.out.println("Неверный путь к файлу.");
    }

    System.out.println("Среднее время полета между городами Владивосток и Тель-Авив : "
        + DateTimeHelper.getReadableDuration(FlightInfoUtil.getAverage(tickets,
        "Владивосток",
        "Тель-Авив")));

    System.out.println("90-й процентиль времени полета между городами Владивосток и Тель-Авив : "
        + DateTimeHelper.getReadableDuration(FlightInfoUtil.getPercentile(tickets,
        90,
        "Владивосток",
        "Тель-Авив")));
  }
}
