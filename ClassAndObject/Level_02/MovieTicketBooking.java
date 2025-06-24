package ClassAndObject.Level_02;
import java.util.Scanner;

class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    MovieTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void displayTicket() {
        System.out.println("Movie: " + movieName + ", Seat: " + seatNumber + ", Price: " + price);
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String movieName = sc.nextLine();
        int seatNumber = sc.nextInt();
        double price = sc.nextDouble();
        MovieTicket ticket = new MovieTicket(movieName, seatNumber, price);
        ticket.displayTicket();
        sc.close();
    }
}
