package lessons.lesson07;

import java.time.LocalDateTime;

public class Booking {
    private String ownerName;
    private LocalDateTime bookingDateTime;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public Booking(String ownerName, LocalDateTime bookingDateTime) {
        this.ownerName = ownerName;
        this.bookingDateTime = bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public Booking() {}
}
