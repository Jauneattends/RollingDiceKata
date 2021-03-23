package src;

import Random.RNG;

public class Roll {

    public enum RollType {
        NORMAL,
        ADVANTAGE,
        DISADVANTAGE
    }

    // Attributes
    private boolean statement = true;
    private int diceValue;
    private int nbRoll;
    private int modifier = 0;
    private int result = 0;

    //Construtor
    public Roll(String formula) {

    }

    //Construtor
    public Roll(int diceValue, int nbRoll, int modifier) {
        if(diceValue <= 0) {
            this.statement = false;
        }
        this.diceValue = diceValue;

        if(nbRoll <= 0) {
            this.statement = false;
        }
        this.nbRoll = nbRoll;

        this.modifier = modifier;
        this.result = result;

    }

    public int makeRoll(RollType rollType) {
        Dice d = new Dice(this.diceValue);
        if (!this.statement){
            return -1;
        }

        int res = 0;
        for (int i = 0; i < nbRoll ; i++) {
            res += d.rollDice(); // res retourne le chiffre obtenu avec le lancer de dés.
        }

        res += this.modifier;

        if (res < 0){
            return 0;
        }

        System.out.println("Dice value : ");
        System.out.println(res);
        return res;
    }
}