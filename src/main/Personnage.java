package main;

public abstract class Personnage {

    //changed all the attributes to protected because of issues with Livreur (which extends Personnage)
    //changed the attributes to double because of issues with Livreur and Societe which do calculations in percentage (needing double)

    private final static int MANA_MAGIC = 20;
    
    protected String name;
    protected double hp;
    protected double physAtk;
    protected double mana;
    protected double def;
    protected double speed;
    
    public Personnage(String name, int hp, int physAtk, int mana, int def, int speed) {
        this.name = name;
        this.hp = hp;
        this.physAtk = physAtk;
        this.mana = mana;
        this.def = def;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double d) {
        this.hp = d;
    }

    public double getPhysAtk() {
        return physAtk;
    }

    public void setPhysAtk(double d) {
        this.physAtk = d;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double d) {
        this.def = d;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public double calculerReduction() {
        // Calculer la réduction de dégât produite par notre défense
        return 100 / (100 + this.def);
    }

    public int calculerDegats(Personnage p) {
        // Calculer les dégâts émis à un personnage en prenant compte de sa défense
        return (int) (this.physAtk * p.calculerReduction());
    }

    public void frapper(Personnage p) {
        // Attaque phyisque
        p.setHp(p.hp - calculerDegats(p));
    }

    public void lancerSort(Personnage p) {
        // Attaque magique
        p.setHp(p.hp - this.physAtk);
        this.setMana(this.mana - MANA_MAGIC);
    }

    //calculer qui attaque en premier (avec speed, nouvel attribut) + changer lancerSort pour infliger + de dégâts en % 

}