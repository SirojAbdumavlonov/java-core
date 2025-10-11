package lessons.lesson03.part2;

import java.util.Random;

public class StreetFight {
    private final Random random = new Random();

    private Fighter fighter1;
    private Fighter fighter2;

    public StreetFight(Fighter fighter1, Fighter fighter2){
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public void fight(){
        if (fighter1 == null || fighter2 == null){
            throw new RuntimeException("Add both fighters!");
        }

        while (fighter1.getHealth() > 0 && fighter2.getHealth() > 0){
            Fighter attacker = getRandomFighterToFight(fighter1, fighter2);
            Fighter defender = (attacker == fighter1) ? fighter2 : fighter1;

            attacker.fight(defender);
        }

        Fighter winner = fighter1.getHealth() > 0 ? fighter1 : fighter2;
        System.out.println("Winner: " + winner.getFighterInfo());
    }

    public Fighter getRandomFighterToFight(Fighter fighter1, Fighter fighter2){
        int value = random.nextInt(2) + 1; //get random: 1 or 2
        return value == 1 ? fighter1 : fighter2;
    }
}
