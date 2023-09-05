package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private static List<Item> listeObjet;
    private static List<Salle> lstSalle = new ArrayList<>();
    private static int nbSalle;
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
        System.out.print("Entrez le nom de votre personnage: ");
        String nom = sc.nextLine();
        System.out.println("Choisissez votre societe : 'U' pour Uber eat, 'D' pour Deliveroo, " +
                "'K' pour KingDelivery, autre caractère pour Indépendant");
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
        return perso;
    }

    public static void actionJoueur(Livreur livreur, Monstre monstre, char choix, Scanner sc){
        
        switch (choix) {
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

            default: System.out.println("feur");
        }
    }


    public static boolean Combat(Livreur livreur, Monstre monstre){ //retourne true si Livreur gagne
        Scanner sc = new Scanner(System.in);
        char choix;

        //during fight these stats can change, after combat they're reverted back to its original value
        double ancienneDef = livreur.getDef() ; double ancienneAtq = livreur.getPhysAtk(); 
        double ancienneSpeed = livreur.getSpeed(); double ancienneStealth = livreur.getStealth(); 
        
        while (livreur.getHp() > 0 && monstre.getHp() > 0){
            
            System.out.println("Livreur : " + livreur);
            System.out.println("Monstre : " + monstre);
            
            System.out.print("Que voulez vous faire ? ");
            System.out.println("Attaque Physique - 'P' ; Attaque  Magique - 'M' ; Bloquer - 'B' ; Utiliser un objet - 'O' ");
            
            choix = sc.next().charAt(0);
            
            if (livreur.getSpeed() > monstre.getSpeed()){
                actionJoueur(livreur, monstre, choix, sc);
                //actionMonstre();
                monstre.frapper(livreur);
            } else {
                monstre.frapper(livreur);
                actionJoueur(livreur, monstre, choix, sc);
            }
            
            livreur.setImmune(false);
        }
        
        System.out.println("Livreur : " + livreur);
        System.out.println("Monstre : " + monstre);
        
        sc.close();
        
        if (livreur.getHp() > 0) {
            livreur.setDef(ancienneDef); livreur.setPhysAtk(ancienneAtq);
            livreur.setSpeed(ancienneSpeed); livreur.setStealth(ancienneStealth);
            return true;
        }

        return false;
        }
    
    
    public static List<Salle> genererSalles()
    {
        List<Salle> res = new ArrayList<>();
        int rnd = new Random().nextInt(10)+1;
        nbSalle = rnd;
        for (int i = 0; i<rnd; i++)
        {
            res.add(new Salle());
        }
        return res;
    }



    public void jouerTour(Livreur l)
    {
        int nbSalle = lstSalle.size();
        Salle current = lstSalle.get(0);
        lstSalle.remove(0);
        System.out.println("Vous arriver en face de " + current.getName().toString() + "\n");
        if (current.hasEvent())
        {
            current.lancerEvent(l);
        }
        else
        {
            System.out.println("Cette salle est vide...");
        }
        
        
    }

    public void finirTour(Livreur l)
    {
        if(l.getHp()>0)
        {
          int currentTour = nbSalle-lstSalle.size();
          System.out.println("Vous etes à la salle "+currentTour+" sur "+nbSalle);

          Scanner sc = new Scanner(System.in);
          char selec = sc.next().toLowerCase().charAt(0);

          while (selec!='p') 
          {
            System.out.println("Tapper 'A' pour afficher vos stat; \n 'I' pour utiliser un item; \n 'P' pour passer au tour suivant." );
            if(selec == 'a')
            {

            }
            if(selec == 'i')
            {
               l.seeInventory(); 
            }
            if(selec == 'p')
            {
               jouerTour(l);; 
            }
            selec = sc.next().toLowerCase().charAt(0);
          }
        }
    }

    
    
    
    public static void main(String[] args)
    {

        // Debuter Partie
        Livreur joueur = creerLivreur();
        lstSalle = genererSalles();

        joueur.inventory.add(Item.KEBAB);
        joueur.inventory.add(Item.BURGER);
        joueur.inventory.add(Item.PIZZA);

        Monstre monstre = new Monstre("pas Maxime");

        boolean win = Combat(joueur,monstre);
        System.out.println(win);

    }




    


    
}
