import java.util.List;

public class Customer {
    long id;
    String name;
    List<Ticket> tickets;
    CashProvider cash;

    /**
     * @param ticket принимает на вход билет, который планируется купить
     * @return возвращает результат, удалось купить или нет
     */
    void buyTicket (Ticket ticket) {
        if (ticket.isValid && cash.getCash() >= ticket.price) {
            ticket.isValid = false;
            ticket.nameCustomer = this.name;
            tickets.add(ticket);
            cash.buy(ticket.price);
            System.out.printf("Билет приобретен на имя: %s\n", this.name);
            return;
        }
        System.out.println("Билет не может быть приобретен");
    }

    /**
     * @param rootNumber номер билета
     * @return возвращает информацию о билетах
     */
     public List<Ticket> searchTicket(long rootNumber) {
         for (Ticket t : tickets) {
             if (t.rootNumber == rootNumber) {
                 System.out.println("Билет найден:");
                 return tickets;
             }
         }
         System.out.println("Билет отсутствует");
         return null;
    }

    public Customer(long id, String name, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.tickets = tickets;
        cash = new CashProvider(this.name);
    }
}