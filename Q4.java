
  
   public class MovieTicketBookingSystem {

   
    static class Ticket {
        private int ticketNumber;
        private String customerName;
        private int seatNumber;

        public Ticket(int ticketNumber, String customerName, int seatNumber) {
            this.ticketNumber = ticketNumber;
            this.customerName = customerName;
            this.seatNumber = seatNumber;
        }

        public int getTicketNumber() {
            return ticketNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public int getSeatNumber() {
            return seatNumber;
        }

       
        public String toString() {
            return "Ticket #" + ticketNumber + ", Customer: " + customerName + ", Seat: " + seatNumber;
        }
    }

   
    static class BookingSystem {
        private Ticket[] tickets;
        private int bookingCount;

        public BookingSystem() {
            tickets = new Ticket[10];
            bookingCount = 0;
        }

        public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
            if (bookingCount >= tickets.length) {
                System.out.println("All seats are booked. Cannot book more tickets.");
                return;
            }

           
            if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("Invalid seat number. Must be between 1 and 10.");
                return;
            }

           
            for (int i = 0; i < bookingCount; i++) {
                if (tickets[i].getSeatNumber() == seatNumber) {
                    System.out.println("Seat " + seatNumber + " is already booked.");
                    return;
                }
            }

            // Book the ticket
            tickets[bookingCount++] = new Ticket(ticketNumber, customerName, seatNumber);
            System.out.println("Ticket booked: " + customerName + " (Seat " + seatNumber + ")");
        }

        public void cancelTicket(int ticketNumber) {
            boolean found = false;
            for (int i = 0; i < bookingCount; i++) {
                if (tickets[i].getTicketNumber() == ticketNumber) {
                    found = true;
                    System.out.println("Cancelling ticket #" + ticketNumber + " (Seat " + tickets[i].getSeatNumber() + ")");
                
                    for (int j = i; j < bookingCount - 1; j++) {
                        tickets[j] = tickets[j + 1];
                    }
                    tickets[--bookingCount] = null;
                    break;
                }
            }
            if (!found) {
                System.out.println("Ticket #" + ticketNumber + " not found.");
            }
        }

        public void displayAllBookings() {
            System.out.println("\nCurrent Bookings");
            if (bookingCount == 0) {
                System.out.println("No tickets booked.");
            } else {
                for (int i = 0; i < bookingCount; i++) {
                    System.out.println(tickets[i]);
                }
            }
        }
    }

    
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

       
        bookingSystem.bookTicket(1, "Alice", 1);
        bookingSystem.bookTicket(2, "Bob", 2);
        bookingSystem.bookTicket(3, "Charlie", 3);

      
        bookingSystem.cancelTicket(2);

       
        bookingSystem.bookTicket(4, "Diana", 2);

        
        bookingSystem.displayAllBookings();
    }
}
