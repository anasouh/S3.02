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
                Monstre mimick = new Monstre("Mimick");
                Jeu.Combat(livreur, mimick);
            }
        }
        if(rep.equals("non")){
          System.out.println(  "Vous vous eloignez du coffre sans y pretez attention");
        }
        

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
                livreur.addItem(objet);
            }

            if(rdm >24 && rdm <75){
                System.out.println("Vous ne trouvez rien ");
            }

            if(rdm >74){
                Monstre monstre = new Monstre();
                Jeu.Combat(livreur, monstre);
                //créer un monstre aléatoire et faire un combat avec le livreur
            }



        }
        if(rep.equals("non")){
            System.out.println("vous décidez de partir sans faire attention");
        }
       


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
                int rdm2 = Event.rng.nextInt(25)+10;
                livreur.setHp(livreur.getHp()+rdm2);
                System.out.println(Color.RED+"Vous avez récuperer"+ rdm2 +"vie !"+Color.RESET);
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
                    Monstre pnj = new Monstre("etrange");
                    Jeu.Combat(livreur, pnj);
                    //faire un combat entre un pnj et le livreur
                }
            }

            
            
        }

        public static void eventCabane(Livreur livreur){
            Scanner sccabane = new Scanner(System.in);
            String rep ="";
            System.out.println("Vous apercevez une cabane dans la zone. Voulez vous la visiter? (o/n)");
            while(!(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("n"))){
            rep = sccabane.nextLine();
            int rdm = Event.rng.nextInt(101);
            if(rdm<60){
                System.out.println("Cette cabane est vide");
            }
            if(rdm<80 && rdm > 59){
                System.out.println("Vous trouver un objet par terre");
                Item objet = Item.randomObjet();
                System.out.println("c'est :\n" + objet);
                livreur.addItem(objet);

            }
            if(rdm>80){
                System.out.println("oh non un monstre est présent ");
                Monstre monstre = new Monstre();
                Jeu.Combat(livreur, monstre);
                //combat monstre / livreur a faire 
            }
        }
           
        }

        public static void eventGrotte(Livreur livreur){
            Scanner scgrotte = new Scanner(System.in);
            String rep ="";
            System.out.println("vous trouver une entrée de grotte de l'energie semble en sortir voulez vous entrer dedans ?");
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scgrotte.nextLine();
            }
            if(rep.equals("oui")){
                System.out.println("vous explorer la grotte avant de tomber sur ce qui semble etre un sanctuaire ");
                System.out.println("Ecrivez le mot auquel vous penser");
                rep=scgrotte.nextLine();
                int bonus = (rep.length()%3)+1;
                System.out.println("Vous vous sentez en meilleur forme");
                if(bonus == 1){livreur.setPhysAtk(livreur.getPhysAtk()*1.2);}
                if(bonus == 2){livreur.setDef(livreur.getDef()*1.2);}
                if(bonus == 3){livreur.setMana(livreur.getMana()*1.2);}
                System.out.println("vous sortez de la grotte");
            }
            if(rep.equals("non")){
                System.out.println("vous vous éloigner de la grotte");
            }
        
        }

        public static void eventCombat(Livreur livreur){
            System.out.println("Un monstre vous attaque !");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Erreur");
            }
            Monstre monstre = new Monstre();
            Jeu.Combat(livreur, monstre);
            //combat livreur/monstre random
            System.out.println("Vous avez réussi a vaince le monstre");
        }

        public static void eventMonstreDos(Livreur livreur){
            Scanner scmonstredos = new Scanner(System.in);
            String rep ="";
            Monstre monstre = new Monstre();
            //generer un monstre
            System.out.println("Vous repérez un monstre au loin voulez vous l'analyser ?");
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scmonstredos.nextLine();
            }
            if(rep.equals("oui")){
            System.out.println(monstre);


            int rdm = (int)Event.rng.nextInt(101);
            int proba = (int)(monstre.getDanger() * livreur.getStealth() / 100);

             if(rdm <= proba){
                System.out.println("oh non le monstre vous a reperé !");
                Jeu.Combat(livreur, monstre);
                //faire un combat contre le monstre
            }}
            else{
                System.out.println("que voulez vous faire ? \n 1) attaquer \n 2) fuir");
                while(!(rep.equals("attaquer") || rep.equals("fuir"))){
            rep = scmonstredos.nextLine();
            } 
            if(rep.equals("attaquer")){
                Jeu.Combat(livreur, monstre);
            }
            if(rep.equals("fuir")){
                System.out.println("vous arrivez a vous echapper sans combattre ");
            }
        }
        
       
        }

        public static void eventTrap(Livreur livreur){
            Scanner sctrap = new Scanner(System.in);
            String rep ="";
            System.out.println("Vous tombez dans un piège en marchant vous perdez de la vie " + Color.RED_BOLD + (livreur.getHp()*0.05)+5 + Color.RESET);
            livreur.setHp(livreur.getHp() - (livreur.getHp()*0.05)+5);
        }
        

     public static void aleatoire(Livreur livreur){
        int rmd = Event.rng.nextInt(101);
        if(rmd<8){Event.eventTrap(livreur);}
        if(rmd>7 && rmd <13){Event.eventGrotte(livreur);}
        if(rmd>12 && rmd <22){Event.eventCabane(livreur);}
        if(rmd>21 && rmd <36){Event.eventCombat(livreur);}
        if(rmd>35 && rmd <65){Event.eventMonstreDos(livreur);}
        if(rmd>64 && rmd <78){Event.eventPerson(livreur);}
        if(rmd>77 && rmd <93){Event.eventBush(livreur);}
        if(rmd>92 && rmd <100){Event.eventCoffre(livreur);}
    }

   /*  public static void main(String[] args) {
        Livreur liv = new Livreur("zegera", Societe.Deliveroo);
        Event.aleatoire(liv);
    } */
    
}