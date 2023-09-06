package main;

public abstract class Personnage implements Interactable<Personnage>
{

    private final static double MANA_MAGIC = 20;
    
    protected String name;
    protected double hp;
    protected double physAtk;
    protected double mana;
    protected double def;
    protected double speed;
    private boolean immune = false; //during fight or using an item, livreur can be immune to the enemy's physical attacks
    
    public Personnage(String name, int hp, int physAtk, int mana, int def, int speed) {
        this.name = name;
        this.hp = hp;
        this.physAtk = physAtk;
        this.mana = mana;
        this.def = def;
        this.speed = speed;
    }

    public Personnage(String name){ //monstre générique
        this.name = name;
        this.hp = 100;
        this.physAtk = 20;
        this.mana = 100;
        this.def = 20;
        this.speed = 15;
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
        if (this.hp > 100) this.hp = 100;
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

    public boolean isImmune() {
        return immune;
    }

    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    public double calculerReduction() {
        // Calculer la réduction de dégât produite par notre défense
        return 100 / (100 + this.def);
    }

    @Override
    public void dire(String txt, Color c)
    {
        System.out.println(c+txt+Color.RESET);
    }

    @Override
    public abstract void interagir(Personnage truc);


    public int calculerDegats(Personnage p) {
        // Calculer les dégâts émis à un personnage en prenant compte de sa défense
        if (p.isImmune()){
            return 0;
        }
        return (int)(this.physAtk * p.calculerReduction());
    }

    public void frapper(Personnage p) {
        // Attaque physique
        int degats = calculerDegats(p);
        System.out.println(p.getName() + " perd " + degats + "HP!");
        p.setHp(p.hp - degats);
    }

    public boolean lancerSort(Personnage p) {
        // Attaque magique
        if (mana >= MANA_MAGIC) {
            int degats = (int)(this.physAtk * 1.2);
            System.out.println(p.getName() + " perd " + degats + "HP!");
            p.setHp(p.hp - degats);
            this.setMana(this.mana - MANA_MAGIC);
            return true;
        }
        System.out.println("Vous n'avez pas assez de mana pour lancer ce sort");
        return false;
    }

    public Personnage attackingFirst(Personnage p){
        if (this.speed < p.speed) return p;
        else return this;
    }

    public abstract void dire(String replique);
    
    @Override
    public String toString() {
        return "\t" + Color.WHITE_BOLD + this.getName().toUpperCase() + " " + Color.RED + ((int) hp) + " HP | " + Color.BLUE + ((int) physAtk) + " ATK | " + Color.GREEN + ((int) def) + " DEF | " + Color.YELLOW + ((int) mana) + " MANA | " + Color.CYAN + ((int)speed) + " SPEED" + Color.RESET;
    }


    

}