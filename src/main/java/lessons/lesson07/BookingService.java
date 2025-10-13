package lessons.lesson07;

import lessons.lesson06.Plane;
import lessons.lesson06.Seat;

import java.time.LocalDateTime;

public class BookingService {
    private static final long EXPIRATION_MINUTES = 24;

    public void checkAndCancelExpiredBookings(Plane plane) {
        for (Seat seat : plane.getSeats()) {
            Booking booking = seat.getBooking();
            if (booking != null && isExpired(booking)) {
                seat.unbookSeat();
            }
        }
    }

    private boolean isExpired(Booking booking) {
        LocalDateTime bookingTime = booking.getBookingDateTime();
        return bookingTime.plusMinutes(EXPIRATION_MINUTES).isBefore(LocalDateTime.now());
    }
}

