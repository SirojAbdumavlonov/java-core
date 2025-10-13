package lessons.lesson06;

import lessons.lesson07.BookingService;
import lessons.lesson07.SeatClass;

import java.time.LocalDateTime;

public class Plane {
    private Seat[] seats;
    private LocalDateTime departureDateTime;

    public Plane(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;

        seats = new Seat[20 + 96];

        for (int i = 1; i <= 20; i++) {
            seats[i-1] = new Seat(SeatClass.BUSINESS, i);
        }
        for (int i = 21; i <= 116; i++) {
            seats[i-1] = new Seat(SeatClass.ECONOM, i);
        }
    }

    public void showAllSeats() {
        BookingService bookingService = new BookingService();
        bookingService.checkAndCancelExpiredBookings(this);

        for (Seat seat : seats) {
            seat.getSeatDetails();
        }
    }

    public void bookSeat(int seatNumber, String ownerName) {
        if (this.departureDateTime.isBefore(LocalDateTime.now())) {
            System.out.println("It is too late for booking");
            return;
        }
        seats[seatNumber - 1].bookSeat(ownerName);
    }

    public void cancelSeat(int seatNumber) {
        seats[seatNumber - 1].unbookSeat();
    }

    public void getSeatDetails(int seatNumber) {
        seats[seatNumber - 1].getSeatDetails();
    }

    public Seat[] getSeats() {
        return seats;
    }
}