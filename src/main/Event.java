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
        }
            
        }

     public void aleatoire(){
        
    }

    public static void main(String[] args) {
        eventCoffre();
    }
}