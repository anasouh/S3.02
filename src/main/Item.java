package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public enum Item {
    //Equipements
    BATON("Baton", ItemType.ARME, "atk", 5),
    MATRAQUE("Matraque", ItemType.ARME, "atk", 20),
    PISTOLET("Pistolet", ItemType.ARME, "atk", 35),
    OREILLERS("Tenue en oreillers", ItemType.ARMURE, "def", 5),
    GILET("Gilet", ItemType.ARMURE, "def", 15),
    SUIT("Tenue oficielle de livreur", ItemType.ARMURE, "def", 25),
    CHAUSSETTES("Chaussettes", ItemType.ACCESSOIRE, "speed", 20),
    SCOOTER("Scooter", ItemType.ACCESSOIRE, "speed", 45),
    LUNETTES("Lunettes de soleil", ItemType.ACCESSOIRE, "stealth", 15),
    CARTON("Carton", ItemType.ACCESSOIRE, "stealth", 35),
    //Consommables
    CHAMPIGNON("Champignon", "hp", 30),
    POMME("Pomme", "mana", 20),
    PIZZA("Pizza", "hp", 75),
    MOUNTAINDEW("Mountain Dew", "mana", 75),
    STEROIDES("Stéroïdes", "atk", 10),
    TACOS("Tacos","def",15),
    KEBAB("Kebab","atk",50),
    BURGER("Burger","mana",30),
    RIZ("Un seul grain de riz","hp",1),
    SUSHI("Sushi","stealth",20),
    CAFE("Café","speed",25);

    private String nom;
    private boolean cons;
    private ItemType type;
    private String modifiedStat;
    private int points;

    //Constructeur d'Item équipement
    private Item(String nom, ItemType type, String modifiedStat, int points){
        this.nom = nom;
        this.cons = false;
        this.type = type;
        this.modifiedStat = modifiedStat;
        this.points = points;
    }

    //Constructeur d'Item consommable
    private Item(String nom, String modifiedStat, int points){
        this.nom = nom;
        this.cons = true;
        this.modifiedStat = modifiedStat;
        this.points = points;
    }

    public String getNom(){
        return nom;
    }

    public boolean getCons(){
        return cons;
    }

    public ItemType getType(){
        if (!cons){
            return type;
        }
        return null;
    }

    public String getModifiedStat(){
        return modifiedStat;
    }

    public int getpoints(){
        return points;
    }

    @Override
    public String toString(){
        String str = nom + ": + " + points + " " + modifiedStat;
        if (cons){
            str += " [Consommable]";
        } else {
            str += " [" + type + "]";
        }
        return str;
    }

    public static Item randomObjet(){
        return Item.values()[new Random().nextInt(Item.values().length)];
    }

    public static Item randomCons(){
        List<Item> cons = new ArrayList<>();
        Item[] items = Item.values();
        for (Item i : items){
            if (i.getCons()){
                cons.add(i);
            }
        }
        return cons.get(new Random().nextInt(cons.size()));
    }
}