package lessons.lesson03.part2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fighter {
    private String code;
    private String name;
    private int health;
    private int attack; //урон

    public void fight(Fighter opponent) {
        opponent.health -= this.attack;
        if (opponent.health < 0) {
            opponent.health = 0;
        }
        System.out.println("This fighter: " + opponent.name + " attacked me: " + this.name + " my health: " + this.health);
    }

    public String getFighterInfo() {
        return "Code: " + code + ", Name: " + name +
            ", Health: " + health + ", Attack: " + attack;
    }

}
