package random;

import java.util.Scanner;

public class Ticket {
    private int ticketId;
    private int price;
    private static int availableTickets;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getAvailableTickets() {
        return availableTickets;
    }

    public static void setAvailableTickets(int availableTickets) {
        Ticket.availableTickets = availableTickets;
    }

    public int calculateTicketCost(int noOfTickets) {
        if (Ticket.getAvailableTickets() >= noOfTickets && Ticket.getAvailableTickets() > 0) {
            setAvailableTickets(getAvailableTickets() - noOfTickets);
            //availableTickets -= noOfTickets;
            return price * noOfTickets;
        } else {
            return -1;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter movie name");
        String movieName = scanner.nextLine();

        System.out.println("Enter no of bookings");
        int noOfBookings = scanner.nextInt();

        System.out.println("Enter the available tickets");
        int availableTickets = scanner.nextInt();

        Ticket.setAvailableTickets(availableTickets);

        for (int i = 1; i <= noOfBookings; i++) {
            Ticket ticket = new Ticket();

            System.out.println("Enter the ticketid");
            ticket.setTicketId(scanner.nextInt());

            System.out.println("Enter the price");
            ticket.setPrice(scanner.nextInt());

            System.out.println("Enter the no of tickets");
            int noOfTickets = scanner.nextInt();

            int totalAmount = ticket.calculateTicketCost(noOfTickets);
            if (totalAmount >= 0) {
                System.out.println("Available tickets: " + (Ticket.getAvailableTickets() + noOfTickets));
                System.out.println("Total amount: " + totalAmount);
                System.out.println("Available ticket after booking: " + Ticket.getAvailableTickets());
            } else {
                if (Ticket.getAvailableTickets() == 0) {
                    System.out.println("House full");
                } else {
                    System.out.println("Tickets are not available");
                }
            }
        }

        scanner.close();
    }
}
