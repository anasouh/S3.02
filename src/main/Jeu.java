package main;

import java.util.List;
import java.util.Scanner;

public class Jeu {
    private static List<Item> listeObjet;
    private static List<Salle> lstSalle;
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

    public static Livreur creerLivreur()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre nom de personnage : ");
        String nom = sc.nextLine();
        System.out.println("Choisissez votre societe : 'U' pour Uber eat, 'D' pour Deliveroo, " +
                "'K' pour KingDelivery, autre caracter pour Indépendant");
        char choix = sc.next().charAt(0);
        Societe societe;

        switch (choix)
        {
            case 'U':
                societe = Societe.UberEats;
                break;
            case 'D':
                societe = Societe.Deliveroo;
                break;
            case 'K':
                societe = Societe.KingDelivery;
                break;
            default:
                societe = Societe.Indépendant;
        }
        Livreur perso = new Livreur(nom, societe);
        System.out.println();
        System.out.println("Ok " + perso.getName() + ", voici vos statistiques : ");
        System.out.println(perso);
        sc.close();
        return perso;
    }

    public static Salle genererSalle()
    {

    }

    public static void jouerTour(Livreur l)
    {
        
    }

    
    
    public static void main(String[] args)
    {
        Livreur joueur = creerLivreur();
        int nbSalle = lstSalle.size();
        for (int i = 0; i < nbSalle; i++)
        {
            Salle current = lstSalle[0];
            lstSalle.remove(0);

            

        }
    }




    


    
}
