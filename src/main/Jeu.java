package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private static List<Item> listeObjet;
    private static List<Salle> lstSalle = new ArrayList<>();
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
        return perso;
    }


    public static boolean Combat(Livreur livreur, Monstre monstre){ //retourne true si Livreur gagne
        Scanner sc = new Scanner(System.in);
        char choix;
        
        while (livreur.getHp() > 0 && monstre.getHp() > 0){
            
            System.out.print("Que voulez vous faire ? ");
            System.out.println("Attaque Physique - 'P' ; Attaque  Magique - 'M' ; Bloquer - 'B' ; Utiliser un objet - 'O' ");

            choix = sc.next().charAt(0);
    
            switch (choix)
            {
                case 'P': //attaque physique
                    livreur.frapper(monstre);
                    break;

                case 'M': //attaque magique
                    livreur.lancerSort(monstre);
                    break;

                case 'B': //bloquer
                    livreur.setImmune(true);
                    break;

                case 'O': //utiliser un objet
                    List<Item> consommables = livreur.listeCons(); //afficher la liste des item consommables possédés
                    int conso = sc.nextInt();
                    livreur.useItem(consommables, consommables.get(conso));
                    break;

                default:
                    System.out.println("conard");

                }
                
                // monstre attaque
                monstre.frapper(livreur);
                
                System.out.println("Livreur : " + livreur);
                System.out.println("Monstre : " + monstre);
        }

        sc.close();

        return (livreur.getHp() > 0);
        
    }
    

    public static List<Salle> genererSalles()
    {
        List<Salle> res = new ArrayList<>();
        int rnd = new Random().nextInt(10)+1;
        for (int i = 0; i<rnd; i++)
        {
            res.add(new Salle());
        }
        return res;
    }



    public void jouerTour(Livreur l)
    {
        int nbSalle = lstSalle.size();
        for (int i = 0; i < nbSalle; i++)
        {
            Salle current = lstSalle.get(0);
            lstSalle.remove(0);
        }
    }

    
    
    
    public static void main(String[] args)
    {

        // Debuter Partie
        Livreur joueur = creerLivreur();
        lstSalle = genererSalles();

        joueur.inventory.add(Item.KEBAB);
        joueur.inventory.add(Item.BURGER);
        joueur.inventory.add(Item.POMME);

        Monstre monstre = new Monstre("Maxime",100,10,100,10,1,10);

        boolean win = Combat(joueur,monstre);
        System.out.println(win);

    }




    


    
}
