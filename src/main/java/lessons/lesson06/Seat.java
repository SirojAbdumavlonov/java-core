package lessons.lesson06;

public class Seat {
    private String ownerName;
    private String seatClass;
    private int seatNumber;
    private boolean isBooked;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Seat() {}

    public Seat(String seatClass, int seatNumber) {
        this.ownerName = "";
        this.seatClass = seatClass;
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public void bookSeat(String ownerName) {
        if (!isBooked) {
            this.isBooked = true;
            this.ownerName = ownerName;
            System.out.println("Seat booked!");
        } else {
            System.out.println("Seat is already booked");
        }
    }

    public void unbookSeat() {
        this.isBooked = false;
        this.ownerName = "";
        System.out.println("Cancelled successfully!");
    }

    public void getSeatDetails() {
        System.out.print("Number = " + this.seatNumber + ", class = " + this.seatClass);
        if (this.isBooked) {
            System.out.print(", booked, name = " + this.ownerName);
        }
        System.out.println();
    }

}