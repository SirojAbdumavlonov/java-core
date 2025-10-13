package lessons.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataStorage {

    private final String filePath;

    public DataStorage(String filePath) {
        this.filePath = filePath;
    }

    public void saveSeats(Plane plane) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

            for (Seat seat : plane.getSeats()) {
                bw.write(seat.getSeatNumber() + ":" + seat.getSeatClass() +
                    ":" + seat.isBooked() + ":" + (seat.getOwnerName() == null ? "" : seat.getOwnerName()) + "\n");
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
                String[] parts = line.split(":");
                if (parts.length < 4) continue;

                int seatNumber = Integer.parseInt(parts[0]);
                String seatClass = parts[1];
                boolean isBooked = Boolean.parseBoolean(parts[2]);
                String ownerName = parts[3].isEmpty() ? null : parts[3];

                Seat seat = new Seat();
                seat.setSeatNumber(seatNumber);
                seat.setSeatClass(seatClass);
                seat.setBooked(isBooked);
                seat.setOwnerName(ownerName);

                plane.getSeats()[index++] = seat;
            }

            System.out.println("Seats loaded successfully from file.");
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}