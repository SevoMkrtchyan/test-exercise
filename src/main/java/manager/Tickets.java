package manager;

import java.util.List;
import model.Ticket;

public class Tickets {

  private List<Ticket> tickets;

  public Tickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  public Tickets(){

  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  @Override
  public String toString() {
    return "TicketHolder{" +
        "tickets=" + tickets +
        '}';
  }

}
