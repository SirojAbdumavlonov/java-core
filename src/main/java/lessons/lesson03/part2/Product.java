package lessons.lesson03.part2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String code;
    private String name;
    private double price;
    private int count;

    public String getProductInfo(){
        return String.format("code: %s, name: %s, price: %.2f, count: %d",
            code, name, price, count);
    }
}
