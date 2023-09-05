package main;

import java.util.Random;

public class Monstre extends Personnage{
    private int danger;
    private MonstreType type;
    private static Random random = new Random();

    public Monstre(String name, int pv, int physAtk, int magicAtk, int mana, int def, int danger){
        super(name,pv,physAtk,magicAtk,mana,def);
        this.danger = danger;
        this.type = MonstreType.random();
    }

    public Monstre(String name){ //monstre random
        super(name,100,(random.nextInt(24) + 1),100,(random.nextInt(24) + 1),(random.nextInt(24) + 1));
        this.danger = random.nextInt(100); //si le danger du monstre est + grand que le stealth du Livreur alors il voit le Livreur
        this.type = MonstreType.random();
        if (this.type.equals(MonstreType.Magicien)) this.mana *= 1.5;
        if (this.type.equals(MonstreType.Guerrier)) this.physAtk *= 1.5;
        if (this.type.equals(MonstreType.Defense)) this.def *= 1.5;
        if (this.type.equals(MonstreType.MiniBoss)) {
            this.mana *= 1.5;
            this.physAtk *= 1.5;
            this.def *= 1.5;
            this.danger *= 1.5;
        }
    }

    public int getDanger() {
        return danger;
    }

    public String getName() {
        return type.getName();
    }

    @Override
    public String toString(){
        String result = super.toString();
        result = result + "Type : " + this.type + "Danger : " + this.danger;
        return result;
    }

    
}