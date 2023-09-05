package main;

import java.util.Scanner;

public class Event{
    public static void eventCoffre(Livreur livreur){
        Scanner sccoffre = new Scanner(System.in);
        
        System.out.println("Vous apercevez un coffre Voulez vous l'ouvrir ?");
        String rep = "";
        while(!(rep.equals("oui") || rep.equals("non"))){
            rep = sccoffre.nextLine();
        }
        if(rep.equals("oui")){
            System.out.println("Vous trouvez dans le coffre cet objet : ");
            System.out.println(Item.randomObjet());
            System.out.println("Voulez vous prendre cet objet il vous reste " + Item.afficherNombreObjet());
            rep = "";
            while(!(rep.equals("oui") || rep.equals("non"))){
            rep = sccoffre.nextLine();
        }
            if(rep.equals("oui")){
            Jeu.ajouterObjet(randomObjet());
            }
            if(rep.equals("non")){
                System.out.println("Vous laisser l'objet dans le coffre ");
            }
        }
        
        
        

    }

    public static void main(String[] args) {
        eventCoffre();
    }
}