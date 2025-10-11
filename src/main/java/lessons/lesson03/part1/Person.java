package lessons.lesson03.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;

    public void introduce(){
        System.out.printf("Name - %s, age - %d", name, age);
    }
}
