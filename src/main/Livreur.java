package main;

import java.util.Random;
import java.lang.Math;

public class Livreur extends Personnage{

    private String name;
    private int hp = 100; //max=100
    private double mana = 100; //max=100
    private double stealth; //the enemy detects you if you don't have stealth

    private Societe societe; //decides of the multiplier for all the double characteristics
    
    private static Random random = new Random();

    public Livreur(String name, Societe societe){
        //name,hp,physAtk,mana,def,speed
        super(name,100,(random.nextInt(49) + 1),100,(random.nextInt(49) + 1),(random.nextInt(49) + 1));
        this.name = name;
        this.societe = societe;
        
        this.stealth = random.nextInt(49) + 1;
        
        //depending on societe, multiplies the attributes by a certain %;

        this.physAtk = Math.ceil(this.physAtk * societe.getAtkMult());
        this.def = (Math.ceil(this.def * societe.getDefMult()));
        this.stealth = Math.ceil(this.stealth * societe.getStealthMult());
        this.speed = (Math.ceil(this.speed * societe.getSpeedMult()));
        this.mana = Math.ceil(this.mana * societe.getManaMult());
    }

    static Livreur creerJoueur(String name, Societe societe){
        Livreur joueur = new Livreur(name, societe);
        return joueur;
    }

    @Override
    public String toString() {
        return "Livreur [hp=" + this.hp + ", name=" + this.name + ", mana=" + this.mana + ", atk=" + this.physAtk + ", def=" + this.def
                + ", stealth=" + this.stealth + ", speed=" + this.speed + ", societe=" + this.societe + "]";
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

    
}