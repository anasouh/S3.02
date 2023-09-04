package main;

import java.util.Random;
import java.lang.Math;

class Livreur{
    int hp = 100; //max=100
    String name;
    
    double mana = 100; //max=100
    double atk; //the damage you do to the enemy
    double def; //reducts the damage taken
    double stealth; //the enemy detects you if you don't have stealth
    double speed; //who has more speed plays first

    Societe societe; //decides of the multiplier for all the double characteristics
    

    Livreur(String name, Societe societe){
        this.name = name;
        this.societe = societe;

        Random random = new Random(); //attributes are a random number between 1 and 50 included
        this.atk = random.nextInt(49) + 1;
        this.def = random.nextInt(49) + 1;
        this.stealth = random.nextInt(49) + 1;
        this.speed = random.nextInt(49) + 1;
        
        //depending on societe, multiplies the attributes by a certain %;

        this.atk = Math.ceil(this.atk * societe.getAtkMult());
        this.def = Math.ceil(this.def * societe.getDefMult());
        this.stealth = Math.ceil(this.stealth * societe.getStealthMult());
        this.speed = Math.ceil(this.speed * societe.getSpeedMult());
        this.mana = Math.ceil(this.mana * societe.getManaMult());
    }

    static Livreur creerJoueur(String name, Societe societe){
        Livreur joueur = new Livreur(name, societe);
        return joueur;
    }

    @Override
    public String toString() {
        return "Livreur [hp=" + hp + ", name=" + name + ", mana=" + mana + ", atk=" + atk + ", def=" + def
                + ", stealth=" + stealth + ", speed=" + speed + ", societe=" + societe + "]";
    }
    
    public static void main(String[] args) {
        Livreur joueur = creerJoueur("Marcel",Societe.Deliveroo);
        System.out.println(joueur);
    }
}