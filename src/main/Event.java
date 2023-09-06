package main;

import java.util.Random;
import java.util.Scanner;

public class Event{

    private static Random rng = new Random(); 

    public static void noEvent(Livreur livreur){

        Jeu.sleep(2);
        livreur.dire("Vous explorez la zone à la recherche de quelque chose ");
        Jeu.sleep(1);
        livreur.dire("Cette zone est calme, il n'y a rien de spécial à premiere vue");
        int rdm = Event.rng.nextInt(101);
        if(rdm < 21){
            Item item = Item.randomCons();
            Jeu.sleep(1);
            livreur.dire("Oh ?");
            Jeu.sleep(0.5);
            livreur.dire("Un objet est à terre");
            Jeu.sleep(1);
            livreur.dire("Vous avez obtenue "+item, Color.GREEN);

        }
        else{
            Jeu.sleep(0.7);
            livreur.dire("Vous avez pu vous reposer.");
            Jeu.sleep(0.8);
            livreur.dire("Vous récuperez 5 points de vie",Color.RED);
            livreur.setHp(livreur.getHp()+5);
        }
    }

    public static void eventCoffre(Livreur livreur){
        Scanner sccoffre = new Scanner(System.in);
        
        Jeu.printFile("chest");
        Jeu.sleep(1);
        livreur.dire("Vous apercevez un coffre. Voulez vous l'ouvrir ?\n");
        String rep = "";
        while(!(rep.equals("oui") || rep.equals("non"))){
            rep = sccoffre.nextLine();
        }
        if(rep.equals("oui")){
            int rdm = Event.rng.nextInt(101);
            if(rdm>20){
            Item objet = Item.randomEquip();
            Item objet2 = Item.randomEquip();
            Jeu.sleep(1);
            livreur.dire("Vous trouvez dans le coffre ces objets : \n"+objet+"\n"+objet2 );       
            livreur.addItem(objet);
            livreur.addItem(objet2);
            Jeu.sleep(2);
            }
            else{
                livreur.dire("Le coffre etait en réalité un monstre !",Color.RED);
                Jeu.sleep(2);
                Monstre mimick = new Monstre("Mimick");
                Jeu.Combat(livreur, mimick);
            }
        }
        if(rep.equals("non")){
          livreur.dire("Vous vous éloignez du coffre sans y prêter attention");
          Jeu.sleep(2);
        }
        

    }

    public static void eventBush(Livreur livreur){
        Scanner scbush = new Scanner(System.in);
        String rep="";

        Jeu.printFile("bush");
        Jeu.sleep(1);
        livreur.dire("Vous apercevez un buisson qui semble bouger, \n Souhaitez-vous fouiller ?");

        while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scbush.nextLine();
        }
        if(rep.equals("oui")){
            int rdm = Event.rng.nextInt(101);
            if(rdm < 25){
                Item objet = Item.randomCons();
                
                Jeu.sleep(1);
                System.out.println(Color.GREEN+"Vous avez trouvé un objet dans le buisson !" + objet+Color.RESET);
                livreur.addItem(objet);
                Jeu.sleep(2);
            }

            if(rdm >24 && rdm <75){
                livreur.dire("Vous ne trouvez rien ");
                Jeu.sleep(2);
            }

            if(rdm >74){
                livreur.dire("Oh non un monstre est dans le buisson !");
                Jeu.sleep(2);
                
                Monstre monstre = new Monstre();
                Jeu.Combat(livreur, monstre);
                //créer un monstre aléatoire et faire un combat avec le livreur
            }



        }
        if(rep.equals("non")){
            livreur.dire("Vous décidez de partir sans faire attention");
            Jeu.sleep(2);
        }
       


    }

        public static void eventPerson(Livreur livreur){
            Scanner scperson = new Scanner(System.in);
            String rep ="";

            Jeu.printFile("man" + (new Random().nextInt(4) + 1));
            livreur.dire("Vous apercevez une personne de dos, voulez vous lui dire bonjour ?");
            
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scperson.nextLine();
        }
            int rdm = Event.rng.nextInt(101);
            if(rep.equals("oui")){
            if(rdm<70){
                livreur.dire("La personne vous redonne un peu de vie...");
                Jeu.sleep(2);
                int rdm2 = Event.rng.nextInt(25)+10;
                livreur.setHp(livreur.getHp()+rdm2);
                Jeu.sleep(2);
                System.out.println(Color.RED+"Vous avez récupéré "+ rdm2 +" points de vie !"+Color.RESET);
                Jeu.sleep(2);
            }
            else{
                livreur.dire("La personne sort un couteau !");
                Jeu.sleep(2);
                livreur.dire("Voulez-vous lui donner un tacos pour la calmer ?");
                rep ="";
                while(!(rep.equals("oui") || rep.equals("non"))){
                rep = scperson.nextLine();
                }
                if(rep.equals("oui")){
                    Jeu.sleep(0.5);
                    livreur.dire("Vous donnez un de vos tacos à la personne pour la calmer et vous partez");
                    Jeu.sleep(2);
                }
                if(rep.equals("non")){
                    Jeu.sleep(0.5);
                    livreur.dire("La personne vous agresse !");
                    Monstre pnj = new Monstre("etrange");
                    Jeu.Combat(livreur, pnj);
                    //faire un combat entre un pnj et le livreur
                }
            }
        }
        if(rep.equals("non")){
            Jeu.sleep(0.5);
            livreur.dire("vous trouvez plus judicieux de partir discretement");
        }
            
            
        }

        public static void eventCabane(Livreur livreur){
            Scanner sccabane = new Scanner(System.in);
            String rep ="";

            Jeu.printFile("cahutte");
            Jeu.sleep(1);
            livreur.dire("Vous apercevez une cabane dans la zone. Voulez vous la visiter? (oui/non)");

            while(!(rep.toLowerCase().equals("oui") || rep.toLowerCase().equals("non"))){
            rep = sccabane.nextLine();
            }
            if(rep.equals("oui")){
            int rdm = Event.rng.nextInt(101);
            if(rdm<60){
                Jeu.sleep(0.8);
                livreur.dire("Apres avoir bien chercher vous ne trouvez rien dans cette cabane dommage");
                Jeu.sleep(2);
            }
            if(rdm<80 && rdm > 59){
                Jeu.sleep(0.8);
                livreur.dire("Vous trouvez un objet par terre");
                Item objet = Item.randomObjet();
                Jeu.sleep(0.8);
                System.out.println(Color.GREEN+"c'est :\n" + objet+Color.RESET);
                livreur.addItem(objet);
                Jeu.sleep(2);

            }
            if(rdm>79){
                Jeu.sleep(0.8);
                livreur.dire("Oh non ! Un monstre est présent !");
                Jeu.sleep(2);
                Monstre monstre = new Monstre();
                Jeu.Combat(livreur, monstre);
                //combat monstre / livreur a faire 
            }
        }
        if(rep.equals("non")){
            Jeu.sleep(0.8);
            System.out.println("vous n'explorer pas la cabane");
            Jeu.sleep(2);
        }
        }
           
        

        public static void eventGrotte(Livreur livreur){
            Scanner scgrotte = new Scanner(System.in);
            String rep ="";

            Jeu.printFile("couloir");
            Jeu.sleep(1);
            livreur.dire("Vous trouvez une entrée de grotte. De l'énergie semble en sortir... Voulez vous entrer ?");
            
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scgrotte.nextLine();
            }
            if(rep.equals("oui")){
                Jeu.sleep(0.5);
                livreur.dire("Vous explorez la grotte avant de tomber sur ce qui semble être un sanctuaire");
                Jeu.sleep(1);
                livreur.dire("Ecrivez le mot auquel vous penser");
                rep=scgrotte.nextLine();
                int bonus = (rep.length()%3)+1;
                Jeu.sleep(0.8);
                livreur.dire("Vous vous sentez en meilleur forme");
                Jeu.sleep(1);
                if(bonus == 1){
                    livreur.setPhysAtk(livreur.getPhysAtk()*1.4);
                    System.out.println(Color.RED_UNDERLINED+"Vous vous sentez plus fort..."+Color.RESET);
                }
                if(bonus == 2){
                    livreur.setDef(livreur.getDef()*1.4);
                    System.out.println(Color.YELLOW_UNDERLINED+"Vous sentez que vous êtes plus résistant..."+Color.RESET);
                }
                if(bonus == 3){
                    livreur.setMana(livreur.getMana()*1.4);
                    System.out.println(Color.BLUE_UNDERLINED+"Vous sentez la magie s'accumuler..."+Color.RESET);
                }
                Jeu.sleep(1);
                livreur.dire("Vous sortez de la grotte");
                Jeu.sleep(2);
            }
            if(rep.equals("non")){
                Jeu.sleep(0.6);
                livreur.dire("Vous vous éloignez de la grotte");
                Jeu.sleep(2);
            }
        
        }

        public static void eventCombat(Livreur livreur){
            Jeu.sleep(0.8);
            livreur.dire("Un monstre vous attaque !");
            Jeu.sleep(1);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Erreur");
            }
            Monstre monstre = new Monstre();
            Jeu.Combat(livreur, monstre);
            //combat livreur/monstre random
            
        }

        public static void eventMonstreDos(Livreur livreur){
            Scanner scmonstredos = new Scanner(System.in);
            String rep ="";
            Monstre monstre = new Monstre();
            //generer un monstre
            Jeu.printFile("monstre" + (new Random().nextInt(5) + 1));
            Jeu.sleep(0.8);
            livreur.dire("Vous repérez un monstre au loin. Voulez vous l'analyser ?");
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = scmonstredos.nextLine();
            }
            Jeu.sleep(1);
            if(rep.equals("oui")){
            System.out.println(monstre);


            int rdm = (int)Event.rng.nextInt(101);
            int proba = (int)(monstre.getDanger() * livreur.getStealth() / 100);

             if(rdm <= proba){
                Jeu.sleep(2);
                System.out.println("Oh non ! Le monstre vous a repéré !");
                Jeu.Combat(livreur, monstre);
                //faire un combat contre le monstre
            }
        }
        
                Jeu.sleep(1.5);
                System.out.println("Que voulez-vous faire ? \n attaquer \n fuir");
                while(!(rep.equals("attaquer") || rep.equals("fuir"))){
            rep = scmonstredos.nextLine();
            } 
            if(rep.equals("attaquer")){
                Jeu.Combat(livreur, monstre);
            }
            if(rep.equals("fuir")){
                Jeu.sleep(0.5);
                System.out.println("Vous arrivez à vous faufiler sans que le monstre ne vous voie ");
            }
        
        }
        
       
        

        public static void eventTrap(Livreur livreur){
            Scanner sctrap = new Scanner(System.in);
            String rep ="";
            System.out.println("Vous tombez dans un piège en marchant. Vous perdez de la vie " + Color.RED_BOLD + ((livreur.getHp()*0.05)+5) + Color.RESET);
            livreur.setHp(livreur.getHp() - ((livreur.getHp()*0.05)+5));
            Jeu.sleep(2);
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

     public static void main(String[] args) {
        Livreur liv = new Livreur("bug", Societe.Deliveroo);
        System.out.println(liv); 
        Event.eventMonstreDos(liv);
        System.out.println(liv);
    } 
    
}