package main;


public class Monstre extends Personnage{
    private int danger;
    private MonstreType type;

    public Monstre(String name, int pv, int physAtk, int magicAtk, int mana, int def, int danger){
        super(name,pv,physAtk,magicAtk,mana,def);
        this.danger = danger;
        this.type = MonstreType.random();
    }

    public int getDanger() {
        return danger;
    }

    public String getName() {
        return type.getName();
    }

}