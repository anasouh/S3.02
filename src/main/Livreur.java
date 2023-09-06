package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class Livreur extends Personnage{

    private String name;
    private double stealth; //the enemy detects you if you don't have stealth
    private Societe societe; //decides of the multiplier for all the double characteristics
    
    private static Random random = new Random();

    List<Item> inventory = new ArrayList<Item>();

    private Item[] equipmentsSlots = new Item[3];

    public Livreur(String name, Societe societe){
        //name,hp,physAtk,mana,def,speed
        super(name,100,(random.nextInt(10) + 30),100,(random.nextInt(10) + 10),(random.nextInt(15) + 30));
        if(name.equals("bug")){
            this.physAtk = 999;
        }
        this.name = name;
        this.societe = societe;
        
        this.stealth = random.nextInt(20) + 30;
        
        //depending on societe, multiplies the attributes by a certain %;

        this.physAtk = Math.ceil(this.physAtk * societe.getAtkMult());
        this.def = (Math.ceil(this.def * societe.getDefMult()));
        this.stealth = Math.ceil(this.stealth * societe.getStealthMult());
        this.speed = (Math.ceil(this.speed * societe.getSpeedMult()));
        this.mana = Math.ceil(this.mana * societe.getManaMult());

        for (int i = 0; i < 5; i += 1){
            inventory.add(Item.COMMANDE);
        }
    }

    static Livreur creerJoueur(String name, Societe societe){
        Livreur joueur = new Livreur(name, societe);
        return joueur;
    }

    public void dire(String replique)
    {
        System.out.println(this.getName()+" : "+replique);
    }
    
    public static void main(String[] args) {
        Livreur joueur = creerJoueur("Marcel",Societe.Deliveroo);
        System.out.println(joueur);
    }
    
    //getters and setters

    public double getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }


    public double getStealth() {
        return stealth;
    }

    public void setStealth(double stealth) {
        this.stealth = stealth;
    }


    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    public Item[] getEquipmentSlots(){
        return this.equipmentsSlots;
    }

    public void equipItem(Item item){
        if (ItemType.estArme(item)){
            equipItem(item, 0);
        } else if (ItemType.estArmure(item)){
            equipItem(item, 1);
        } else if (ItemType.estAccessoire(item)){
            equipItem(item, 2);
        } else {
            System.out.println("Cet objet ne peut pas être équipé");
        }
    }

    public void equipItem(Item item, int slot){
        if (equipmentsSlots[slot] != null){
            inventory.add(equipmentsSlots[slot]);
            switch (equipmentsSlots[slot].getModifiedStat()) {
                case "atk":
                    this.setPhysAtk(this.getPhysAtk() - equipmentsSlots[slot].getpoints());
                    break;
                case "def":
                    this.setDef(this.getDef() - equipmentsSlots[slot].getpoints());
                    break;
                case "stealh":
                    this.setStealth(this.getStealth() - equipmentsSlots[slot].getpoints());
                    break;
                case "speed":
                    this.setSpeed(this.getSpeed() - equipmentsSlots[slot].getpoints());
                    break;
                default:
                    System.out.println("non :)");
            }
        }
        equipmentsSlots[slot] = item;
        switch (item.getModifiedStat()) {
            case "atk":
                this.setPhysAtk(this.getPhysAtk() + item.getpoints());
                break;
            case "def":
                this.setDef(this.getDef() + item.getpoints());
                break;
            case "stealh":
                this.setStealth(this.getStealth() + item.getpoints());
                break;
            case "speed":
                this.setSpeed(this.getSpeed() + item.getpoints());
                break;
            default:
                System.out.println("uwu");
        }
    }

    public String seeInventory(){
        if (isEmptyInventory()) return "Votre inventaire est vide.";
        String result = "";
        for (Item item : inventory){
            result = result + item.toString() + "\n";
        }
        return result;
    }

    public List<Item> listeCons(){
        int cpt = 0;
        List<Item> result = new ArrayList<>();
        Iterator<Item> it = inventory.iterator();
        Item item;
        while (it.hasNext()) {
            item = it.next();
            if (item.getCons()){
                System.out.println("[" + cpt + "] " + item.toString());
                result.add(item);
            }
            cpt++;
            it.remove();
        }
        return result;
    }

    public boolean useItem(List<Item> consommables, Item item){ //Faire en sort que la stat redevienne normal au tour suivant
        if (consommables.contains(item)){
            switch (item.getModifiedStat()) {
                case "atk":
                    this.setPhysAtk(this.getPhysAtk() + item.getpoints());
                    break;
                case "def":
                    this.setDef(this.getDef() + item.getpoints());
                    break;
                case "stealh":
                    this.setStealth(this.getStealth() + item.getpoints());
                    break;
                case "speed":
                    this.setSpeed(this.getSpeed() + item.getpoints());
                    break;
                case "hp":
                    this.setHp(this.getHp() + item.getpoints());
                    break;
                case "mana":
                    this.setMana(this.getMana() + item.getpoints());
                    if (this.getMana() > (100 * societe.getManaMult())){
                        this.setMana((100 * societe.getManaMult()));
                    }
                    break;
                default:
                    System.out.println("non :)");
            }
            consommables.remove(item);
            this.inventory.addAll(consommables);
            return true;
        }
        else return false;
    }

    public boolean isEmptyInventory() {
        return (inventory.size() == 0);
    }
    
    public int commandeRestante(){
        int tailleCommande = 0;
        for (Item item : inventory){
            if (item.estCommande()){
                tailleCommande += 1;
            }
        }
        return tailleCommande;
    }
}