package lessons.lesson06;

import lessons.lesson07.Booking;
import lessons.lesson07.SeatClass;
import lessons.lesson07.SeatStatus;

import java.time.LocalDateTime;

public class Seat {
    private SeatClass seatClass;
    private SeatStatus status;
    private Booking booking;
    private int seatNumber;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Seat() {}

    public Seat(SeatClass seatClass, int seatNumber) {
        this.seatClass = seatClass;
        this.seatNumber = seatNumber;
        this.status = SeatStatus.FREE;
    }

    public void bookSeat(String ownerName) {
        if (SeatStatus.FREE.equals(this.status)) {
            this.status = SeatStatus.BOOKED;
            this.booking = new Booking(ownerName, LocalDateTime.now());
            System.out.println("Seat booked!");
        } else {
            System.out.println("Seat is already booked");
        }
    }

    public void unbookSeat() {
        this.status = SeatStatus.FREE;
        this.booking = null;
        System.out.println("Cancelled successfully!");
    }

    public void getSeatDetails() {
        System.out.print("Number = " + this.seatNumber + ", class = " + this.seatClass + ", status = " + this.status);
        if (SeatStatus.BOOKED.equals(this.status) || SeatStatus.PAID.equals(this.status)) {
            System.out.print(", name = " + this.booking.getOwnerName() + ", booking date = " + this.booking.getBookingDateTime());
        }
        System.out.println();
    }

}