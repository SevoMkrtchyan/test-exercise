package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

  private String origin;
  private String origin_name;
  private String destination;
  private String destination_name;
  private String departure_date;
  private String departure_time;
  private String arrival_date;
  private String arrival_time;
  private String carrier;
  private int stops;
  private int price;

  public Ticket(String origin, String origin_name, String destination, String destination_name,
      String departure_date,
      String departure_time, String arrival_date, String arrival_time, String carrier, int stops,
      int price) {
    this.origin = origin;
    this.origin_name = origin_name;
    this.destination = destination;
    this.destination_name = destination_name;
    this.departure_date = departure_date;
    this.departure_time = departure_time;
    this.arrival_date = arrival_date;
    this.arrival_time = arrival_time;
    this.carrier = carrier;
    this.stops = stops;
    this.price = price;
  }


  public Duration getDuration() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");

    LocalDateTime departure = LocalDateTime.parse(departure_date + " " + departure_time, formatter);
    LocalDateTime arrival = LocalDateTime.parse(arrival_date + " " + arrival_time, formatter);

    return Duration.between(departure, arrival);
  }

  public String getOrigin() {
    return origin;
  }

  public String getOrigin_name() {
    return origin_name;
  }

  public String getDestination() {
    return destination;
  }

  public String getDestination_name() {
    return destination_name;
  }

  public String getDeparture_date() {
    return departure_date;
  }

  public String getDeparture_time() {
    return departure_time;
  }

  public String getArrival_date() {
    return arrival_date;
  }

  public String getArrival_time() {
    return arrival_time;
  }

  public String getCarrier() {
    return carrier;
  }

  public int getStops() {
    return stops;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Ticket{" +
        "origin='" + origin + '\'' +
        ", origin_name='" + origin_name + '\'' +
        ", destination='" + destination + '\'' +
        ", destination_name='" + destination_name + '\'' +
        ", departure_date='" + departure_date + '\'' +
        ", departure_time='" + departure_time + '\'' +
        ", arrival_date='" + arrival_date + '\'' +
        ", arrival_time='" + arrival_time + '\'' +
        ", carrier='" + carrier + '\'' +
        ", stops=" + stops +
        ", price=" + price +
        '}';
  }
}
