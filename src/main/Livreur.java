package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Math;
import main.exceptions.LivreurIntrouvable;

public class Livreur extends Personnage implements Serializable
{

    private String name;
    private double stealth; //the enemy detects you if you don't have stealth
    private Societe societe; //decides of the multiplier for all the double characteristics
    
    private static Random random = new Random();

    List<Item> inventory = new ArrayList<Item>();

    private Item[] equipmentsSlots = new Item[3];

    

    private Livreur(String name, int hp, int physAtk, int mana, int def, int speed, String name2, double stealth,
            Societe societe, List<Item> inventory, Item[] equipmentsSlots) {
        super(name, hp, physAtk, mana, def, speed);
        name = name2;
        this.stealth = stealth;
        this.societe = societe;
        this.inventory = inventory;
        this.equipmentsSlots = equipmentsSlots;
    }

    public Livreur(String name, Societe societe){
        //name,hp,physAtk,mana,def,speed
        super(name,100,(random.nextInt(10) + 30),100,(random.nextInt(10) + 10),(random.nextInt(15) + 30));
        if(name.equals("bug")){
            this.hp = 1000;
            this.mana = 1000;
            this.physAtk = 1000;
            this.def = 100;
            this.speed = 1000;
            this.stealth = 1000;
            inventory.add(Item.PISTOLET);
            inventory.add(Item.GILET);
            inventory.add(Item.LUNETTES);
            inventory.add(Item.CHAUSSETTES);
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

    @Override
    public void interagir(Personnage m)
    {
        this.dire("Oh non ! , "+m.getName()+" à la dalle...",Color.BLUE);
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
            equipItemSlot(item, 0);
        } else if (ItemType.estArmure(item)){
            equipItemSlot(item, 1);
        } else if (ItemType.estAccessoire(item)){
            equipItemSlot(item, 2);
        } else {
            System.out.println("Cet objet ne peut pas être équipé");
        }
    }

    public void equipItemSlot(Item item, int slot){
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
        inventory.remove(item);
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
        int cpt = 0;
        for (Item item : inventory){
            result = result + "[" + cpt + "] " + item.toString() + "\n";
            cpt += 1;
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
            if (!consommables.equals(inventory)){
                this.inventory.addAll(consommables);
            }
            return true;
        }
        else return false;
    }

    public boolean useItem(Item item){
        return useItem(inventory, item);
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

    @Override
    public String toString() {
        String str = super.toString() + "\n\tArme: ";
        if (equipmentsSlots[0] == null){
            str += Color.BLACK + "Aucun" + Color.RESET;
        } else {
            str += equipmentsSlots[0].getNom();
        }
        str += "\n\tArmure: ";
        if (equipmentsSlots[1] == null){
            str += Color.BLACK + "Aucun" + Color.RESET;
        } else {
            str += equipmentsSlots[1].getNom();
        }
        str += "\n\tAccessoire: ";
        if (equipmentsSlots[2] == null){
            str += Color.BLACK + "Aucun" + Color.RESET;
        } else {
            str += equipmentsSlots[2].getNom();
        }
        return str + "\n\n";
    }

    public static Livreur importer(String name) throws LivreurIntrouvable {
        String currentDir = new File(System.getProperty("user.dir")).getAbsolutePath();
        if (!System.getProperty("user.dir").split("/")[0].equals("src")) currentDir += "/src";
        String path = currentDir + "/main/data/" + name + ".bin";
        System.out.println(path);
        File f = new File(path);
        if (f.exists() && f.canRead()) {
            try (ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(path))) {
                Livreur livreur = (Livreur)ois.readObject();
                return livreur;
            } catch (Exception e) {}
        }
        throw new LivreurIntrouvable();
    }

    public void save() {
        String currentDir = new File(System.getProperty("user.dir")).getAbsolutePath();
        if (!System.getProperty("user.dir").split("/")[0].equals("src")) currentDir += "/src";
        String path = currentDir + "/main/data/" + name + ".bin";
        try (ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(this);
        } catch (IOException ioe) {
            System.err.println("Impossible de sauvagerder ce livreur");
        }
    }

    public String combatStats(){
        return super.toString();
    }
}