package main;

import java.util.List;
import java.util.Scanner;

public class Jeu {
    private static List<Item> listeObjet;
//t
     public static void setListeObjet(List<Item> listeObjet) {
        Jeu.listeObjet = listeObjet;
    }

    public static void retirerObjet(Item objet){
        Jeu.listeObjet.remove(objet);
    }

    public static void ajouterObjet(Item objet){
        Jeu.listeObjet.add(objet);
    }

    public static List<Item> getListeObjet() {
        return listeObjet;
    }

    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre nom de personnage : ");
        String nom = sc.nextLine();
        Livreur perso = new Livreur(nom, Societe.Deliveroo);
        System.out.println();
        System.out.println("Ok " + perso.getName() + ", voici vos statistiques : ");
        System.out.println(perso);
        perso.addItem(Item.BATON);
        perso.addItem(Item.KEBAB);
        perso.addItem(Item.CHAUSSETTES);
        System.out.println(perso.seeInventory());
        sc.close();
    }




    


    
}
