package main;

import java.util.Random;
import java.util.Scanner;

public class Event{

    private static Random rng = new Random(); 

    public static void eventCoffre(Livreur livreur){
        Scanner sccoffre = new Scanner(System.in);
        
        System.out.println("Vous apercevez un coffre Voulez vous l'ouvrir ?");
        String rep = "";
        while(!(rep.equals("oui") || rep.equals("non"))){
            rep = sccoffre.nextLine();
        }
        if(rep.equals("oui")){
            int rdm = Event.rng.nextInt(101);
            if(rdm>10){
            Item objet = Item.randomObjet();
            System.out.println("Vous trouvez dans le coffre cet objet : ");
            System.out.println(objet);
           // System.out.println("Voulez vous prendre cet objet il vous reste " + Item.afficherNombreObjet());       
            livreur.addItem(objet);
            }
            else{
                //faire un combat entre un mimick et le livreur
            }
        }
        if(rep.equals("non")){
          System.out.println(  "Vous vous eloignez du coffre sans y pretez attention");
        }
        sccoffre.close();

    }

    public static void eventBush(Livreur livreur){
        Scanner scbush = new Scanner(System.in);
        String rep="";
        System.out.println("Vous apercevez un buisson avec du mouvement a l'interieur , \n souhaitez vous fouiller ?");

        while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scbush.nextLine();
        }
        if(rep.equals("oui")){
            int rdm = Event.rng.nextInt(101);
            if(rdm < 25){
                Item objet = Item.randomCons();
                System.out.println("vous avez trouvez un objet dans le buisson !" + objet);
            }

            if(rdm >24 && rdm <75){
                System.out.println("Vous ne trouvez rien ");
            }

            if(rdm >74){
                //créer un monstre aléatoire et faire un combat avec le livreur
            }



        }
        if(rep.equals("non")){
            System.out.println("vous décidez de partir sans faire attention");
        }
        scbush.close();


    }

        public static void eventPerson(Livreur livreur){
            Scanner scperson = new Scanner(System.in);
            String rep ="";
            System.out.println("Vous apercevez une personne de dos voulez vous allez la voir ?");
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scperson.nextLine();
        }
            int rdm = Event.rng.nextInt(101);

            if(rdm<70){
                System.out.println("texte pnj redonne de la vie");
                System.out.println("Vous commencez a vous sentir mieu");
                livreur.setHp(Event.rng.nextInt(35));
                System.out.println("Vous avez récuperer de la vie !");
            }
            else{
                System.out.println("texte mec méchant veux combat");
                System.out.println("voulez vous donner un tacos a la personne pour la calmer ?");
                while(!(rep.equals("oui") || rep.equals("non"))){
                rep = scperson.nextLine();
                }
                if(rep.equals("oui")){
                    System.out.println("vous donner un de vos tacos a la personne pour la calmer et partez");
                }
                if(rep.equals("non")){
                    //faire un combat entre un pnj et le livreur
                }
            }

            scperson.close();
            
        }

        public static void eventCabane(Livreur livreur){
            Scanner sccabane = new Scanner(System.in);
            String rep ="";
            System.out.println("vous apercevez une cabane dans la zone voulez vous la visiter ?");
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = sccabane.nextLine();
            int rdm = Event.rng.nextInt(101);
            if(rdm<60){
                System.out.println("Cette cabane est v ide il n'y a rien d'interessant");
            }
            if(rdm<80 && rdm > 59){
                System.out.println("Vous trouver un objet par terre");
                Item objet = Item.randomObjet();
                System.out.println("c'est :\n" + objet);
                livreur.addItem(objet);

            }
            if(rdm>80){
                System.out.println("oh non un monstre est présent ");
                //combat monstre / livreur a faire 
            }
        }
            sccabane.close();
        }

        public static void eventGrotte(Livreur livreur){
            Scanner scgrotte = new Scanner(System.in);
            String rep ="";
            System.out.println("vous trouver une entrée de grotte de l'energie semble en sortir voulez vous entrer dedans ?");
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scgrotte.nextLine();
            if(rep.equals("oui")){
                System.out.println("vous explorer la grotte avant de tomber sur ce qui semble etre un sanctuaire ");
                System.out.println("Ecrivez le mot auquel vous penser");
                rep=scgrotte.nextLine();
                int bonus = (rep.length()%4) +1;
                System.out.println("Vous vous sentez en meilleur forme");
                livreur.setHp(livreur.getHp() + 5* bonus);
            }
            if(rep.equals("non")){
                System.out.println("vous vous éloigner de la grotte");
            }
        }
        }

        public static void eventCombat(Livreur livreur){
            System.out.println("Un monstre vous attaque !");
            //timer 
            //combat livreur/monstre random
            System.out.println("Vous avez réussi a vaince le monstre");
        }

        public static void eventMonstreDos(Livreur livreur){
            Scanner scmonstredos = new Scanner(System.in);
            String rep ="";
            //generer un monstre
            System.out.println("Vous reperez un monstre au loin voulez vous l'analyser ?");
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scmonstredos.nextLine();
            System.out.println(/*afficher monstre*/);

            int rdm = (int)Event.rng.nextInt(101);
            //int proba = danger du mob * stealh / 100
            if(rdm <= proba){
                //faire un combat contre le monstre
            }
            else{
                System.out.println("que voulez vous faire ? \n 1) attaquer \n 2) fuir");
                while(!(rep.equals("attaquer") || rep.equals("fuir"))){
            rep = scmonstredos.nextLine();
            }
            if(rep.equals("attaquer")){
                //lancer un combat contre le monstre
            }
            if(rep.equals("fuir")){
                System.out.println("vous arrivez a vous echapper sans combattre ");
            }
        }
        }
        }
        Password for 'https://selim.hamza.etu@gitlab.univ-lille.fr': 


     public void aleatoire(){
        
    }

    public static void main(String[] args) {
        
    }
    
}