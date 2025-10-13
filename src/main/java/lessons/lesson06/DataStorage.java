package lessons.lesson06;

import lessons.lesson07.Booking;
import lessons.lesson07.SeatClass;
import lessons.lesson07.SeatStatus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class DataStorage {

    private final String filePath;

    public DataStorage(String filePath) {
        this.filePath = filePath;
    }

    public void saveSeats(Plane plane) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

            for (Seat seat : plane.getSeats()) {
                String ownerName = "";
                String bookingDateTime = "";

                if (seat.getBooking() != null) {
                    ownerName = seat.getBooking().getOwnerName() != null ? seat.getBooking().getOwnerName() : "";
                    bookingDateTime = seat.getBooking().getBookingDateTime() != null
                        ? seat.getBooking().getBookingDateTime().toString()
                        : "";
                }

                bw.write(seat.getSeatNumber() + ";" +
                    seat.getSeatClass().name() + ";" +
                    seat.getStatus().name() + ";" +
                    ownerName + ";" +
                    bookingDateTime + "\n");
            }

            bw.close();
        } catch (IOException e){
            System.out.println("Could not save seats: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadSeats(Plane plane) {
        File file = new File(filePath);

        if (!file.exists() || file.length() == 0) {
            System.out.println("No saved seat data found.");
            saveSeats(plane);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;

            while ((line = br.readLine()) != null && index < plane.getSeats().length) {
                String[] parts = line.split(";");

                int seatNumber = Integer.parseInt(parts[0]);
                SeatClass seatClass = SeatClass.valueOf(parts[1]);
                SeatStatus status = SeatStatus.valueOf(parts[2]);
                String ownerName = parts.length > 3 && !parts[3].isEmpty() ? parts[3] : null;
                String bookingDateTimeStr = parts.length > 4 && !parts[4].isEmpty() ? parts[4] : null;

                Seat seat = new Seat();
                seat.setSeatNumber(seatNumber);
                seat.setSeatClass(seatClass);
                seat.setStatus(status);

                if (ownerName != null) {
                    Booking booking = new Booking();
                    booking.setOwnerName(ownerName);
                    if (bookingDateTimeStr != null) {
                        booking.setBookingDateTime(LocalDateTime.parse(bookingDateTimeStr));
                    }
                    seat.setBooking(booking);
                }

                plane.getSeats()[index++] = seat;
            }

            System.out.println("Seats loaded successfully from file.");
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}