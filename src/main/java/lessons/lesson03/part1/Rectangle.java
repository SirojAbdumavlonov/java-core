package lessons.lesson03.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle {
    private double length;
    private double width;

    public double calculateSquare(){
        return this.length * this.width;
    }

    public double calculatePerimeter(){
        return this.length * 2 + this.width * 2;
    }
}

