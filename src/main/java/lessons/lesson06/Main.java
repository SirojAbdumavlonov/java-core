package lessons.lesson06;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String filePath = "data.txt";
        Plane plane = new Plane(LocalDateTime.now().plusMinutes(20));
        DataStorage storage = new DataStorage(filePath);
        storage.loadSeats(plane);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Menu");
            System.out.println("1.Show all seats");
            System.out.println("2.Book a seat");
            System.out.println("3.Cancel a seat");
            System.out.println("4.Get seat info");
            System.out.println("5.Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    plane.showAllSeats();
                    break;
                case 2:
                    System.out.println("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    System.out.println("Enter your name: ");
                    String name = scanner.next();
                    plane.bookSeat(seatNumber, name);
                    break;
                case 3:
                    System.out.println("Enter seat number: ");
                    int cancelledSeatNumber =  scanner.nextInt();
                    plane.cancelSeat(cancelledSeatNumber);
                    break;
                case 4:
                    System.out.println("Enter seat number: ");
                    int seatInfoNumber = scanner.nextInt();
                    plane.getSeatDetails(seatInfoNumber);
                    break;
                case 5:
                    System.out.println("Thank you for using this program.");
                    storage.saveSeats(plane);
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}