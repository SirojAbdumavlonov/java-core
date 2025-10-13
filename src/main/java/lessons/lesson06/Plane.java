package lessons.lesson06;

public class Plane {
    private Seat[] seats;

    public Plane() {
        seats = new Seat[20 + 96];

        for (int i = 1; i <= 20; i++) {
            seats[i-1] = new Seat("Business", i);
        }
        for (int i = 21; i <= 116; i++) {
            seats[i-1] = new Seat("Economy", i);
        }
    }

    public void showAllSeats() {
        for (Seat seat : seats) {
            seat.getSeatDetails();
        }
    }

    public void bookSeat(int seatNumber, String ownerName) {
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

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }
}
