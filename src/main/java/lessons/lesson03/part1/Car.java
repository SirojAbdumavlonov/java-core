package lessons.lesson03.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String country;
    private String model;
    private int yearOfManufacture;

    public void printCarInfo(){
        System.out.printf("Country: %s, model: %s, year of manufacture: %d", country, model, yearOfManufacture);
    }
}
