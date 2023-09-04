package main;

public abstract class Personnage {
    private final static int MANA_MAGIC = 20;
    private final static int MANA_PHYSIC = 5;
    
    private String name;
    private int pv;
    private int physAtk;
    private int magicAtk;
    private int mana;
    private int def;
    
    public Personnage(String name, int pv, int physAtk, int magicAtk, int mana, int def) {
        this.name = name;
        this.pv = pv;
        this.physAtk = physAtk;
        this.magicAtk = magicAtk;
        this.mana = mana;
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPhysAtk() {
        return physAtk;
    }

    public void setPhysAtk(int physAtk) {
        this.physAtk = physAtk;
    }

    public int getMagicAtk() {
        return magicAtk;
    }

    public void setMagicAtk(int magicAtk) {
        this.magicAtk = magicAtk;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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
        p.setPv(p.pv - calculerDegats(p));
        this.setMana(this.mana - MANA_PHYSIC);
    }

    public void lancerSort(Personnage p) {
        // Attaque magique
        p.setPv(p.pv - this.magicAtk);
        this.setMana(this.mana - MANA_MAGIC);
    }
}