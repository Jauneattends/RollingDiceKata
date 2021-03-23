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
    private String[] res;
    private String[] res_2;

    //Construtor
    public Roll(String formula) {


        if (formula.matches("^\\d?[d]\\d[+-]?\\d?$")) {

            res = formula.split("d");

            if (res.length == 1) {
                if (res[0].matches("[+-]")) {
                    res_2 = res[0].split("[+-]");
                    this.diceValue = Integer.parseInt(res_2[0]);
                    this.modifier = Integer.parseInt(res_2[1]);
                } else {
                    this.nbRoll = 1;
                    this.diceValue = Integer.parseInt(res[0]);
                    this.modifier = Integer.parseInt(res[1]);
                }
            }

            if (res.length == 2) {
                // Exemple 2d6+1
                // res[0] = 2
                // res[1] = 6+1 ou 6
                // res_2 [0] = 6
                // res_2 [1] = 1
                if (res[1].matches("[+-]")) {
                    res_2 = res[1].split("[+-]");
                    this.nbRoll = Integer.parseInt(res[0]);
                    this.diceValue = Integer.parseInt(res_2[0]);
                    this.modifier = Integer.parseInt(res_2[1]);
                } else {
                    this.nbRoll = Integer.parseInt(res[0]);
                    this.diceValue = Integer.parseInt(res[1]);
                    this.modifier = 0;
                }
            }
        } else this.statement = false;

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