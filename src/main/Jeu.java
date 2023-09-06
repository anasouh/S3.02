package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private static List<Item> listeObjet;
    private static List<Salle> lstSalle = new ArrayList<>();
    private static int nbSalle;
    private static Scanner sc = new Scanner(System.in);

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

    public static void clear() {
        System.out.println("\033c");
    }

    public static String bold(String s) {
        return Color.BLACK_BOLD + s + Color.RESET;
    }

    public static char demanderLettre() {
        String line = sc.nextLine();
        while (line.equals("")) {
            line = sc.nextLine();
        }
        return line.toLowerCase().charAt(0);
    }

    public static void sleep(double s) {
        try {
            Thread.sleep(((long) s) * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public static int getNbSalle() {
        return nbSalle;
    }

    public static List<Salle> getLstSalle() {
        return lstSalle;
    }

    public static void printFile(String dessin) {
        String currentDir = new File(System.getProperty("user.dir")).getAbsolutePath();
        if (!System.getProperty("user.dir").split("/")[0].equals("src")) currentDir += "/src";
        String path = currentDir + "/main/ascii/" + dessin + ".txt";
        File f = new File(path);
        if (f.exists() && f.canRead()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ioe) {
                System.err.println("Fichier " + path + " illisible");
            }
        }
    }

    public static Livreur creerLivreur()
    {
        System.out.print("Entrez le nom de votre personnage: ");
        String nom = sc.nextLine();
        clear();
        printFile("cycling");
        System.out.println("Salut " + bold(nom) + ", avant tout choisissez votre société : \n " + bold("['U'] UberEats (Guerrier)\n ['D'] Deliveroo (Magicien)\n ['K'] KingDelivery (Voleur)\n autre caractère pour être Indépendant (Vierge)"));
        char choix = sc.next().toLowerCase().charAt(0);
        Societe societe;

        switch (choix)
        {
            case 'u':
                societe = Societe.UberEats;
                break;
            case 'd':
                societe = Societe.Deliveroo;
                break;
            case 'k':
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
        
        switch (Character.toUpperCase(choix)) {
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
                System.out.println(livreur.seeInventory());
                if (!livreur.isEmptyInventory()) {
                    int conso = sc.nextInt();
                    livreur.useItem(consommables, consommables.get(conso));
                }
                break;

            default: System.out.print("");
        }
    }

    public static void actionMonstre(Livreur livreur, Monstre monstre){
        double proba = new Random().nextDouble();
        if (monstre.getType().equals(MonstreType.Guerrier) || monstre.getType().equals(MonstreType.MiniBoss)){
            if (proba < 0.60){
                monstre.frapper(livreur);
            }
            else if (proba < 0.90){
                monstre.setImmune(true);
            }
            else {
                monstre.lancerSort(livreur);
            }
        } else if (monstre.getType().equals(MonstreType.Defense)){
            if (proba < 0.30){
                monstre.frapper(livreur);
            }
            else if (proba < 0.75){
                monstre.setImmune(true);
            }
            else {
                monstre.lancerSort(livreur);
            }
        } else if (monstre.getType().equals(MonstreType.Magicien)){
            if (proba < 0.15){
                monstre.frapper(livreur);
            }
            else if (proba < 0.40){
                monstre.setImmune(true);
            }
            else {
                monstre.lancerSort(livreur);
            }
        }
    }


    public static boolean Combat(Livreur livreur, Monstre monstre){ //retourne true si Livreur gagne
        char choix;

        //during fight these stats can change, after combat they're reverted back to its original value
        double ancienneDef = livreur.getDef() ; double ancienneAtq = livreur.getPhysAtk(); 
        double ancienneSpeed = livreur.getSpeed(); double ancienneStealth = livreur.getStealth();

        livreur.interagir(monstre);
        monstre.interagir(livreur);
        
        while (livreur.getHp() > 0 && monstre.getHp() > 0){
            clear();
            
            System.out.print(Color.RED_BOLD_BRIGHT);
            printFile("combat");
            System.out.print("\n\n\n"+Color.RESET);
            
            System.out.println(livreur);
            System.out.println(monstre);
            System.out.println("\nQue voulez vous faire ?");
            System.out.println(bold(" ['P'] Attaque physique \n ['M'] Attaque magique\n ['B'] Bloquer\n ['O'] Utiliser un objet\n"));
            
            choix = sc.next().toLowerCase().charAt(0);
            sleep(0.5);
            
            if (livreur.getSpeed() > monstre.getSpeed()){
                actionJoueur(livreur, monstre, choix, sc);
                if(!(monstre.getHp()<=0)){
                monstre.frapper(livreur);
                }
            } else {
                monstre.frapper(livreur);
                if(!(livreur.getHp()<=0)){
                actionJoueur(livreur, monstre, choix, sc);
                }
            }

            sleep(2.5);
            
            livreur.setImmune(false);
        }
        
        //System.out.println("Livreur : " + livreur);
        //System.out.println("Monstre : " + monstre);
        clear();
        
        if (livreur.getHp() > 0) {
            livreur.setDef(ancienneDef); livreur.setPhysAtk(ancienneAtq);
            livreur.setSpeed(ancienneSpeed); livreur.setStealth(ancienneStealth);
            System.out.println("Vous avez réussi a vaincre le monste");
            return true;
        }
        System.out.println("Oh non le monstre vous a vaincu");
        return false;
        }
    
    
    public static List<Salle> genererSalles()
    {
        List<Salle> res = new ArrayList<>();
        int rnd = new Random().nextInt(10)+10;
        nbSalle = rnd;
        for (int i = 0; i<rnd; i++)
        {
            res.add(new Salle());
        }
        return res;
    }



    public static void jouerTour(Livreur l) {
        clear();
        if (!lstSalle.isEmpty()){
            Salle current = lstSalle.get(0);
            lstSalle.remove(0);
            System.out.println("Vous arrivez en face de " + current.getName().toString() + "\n");
            if (current.hasEvent())
            {
                current.lancerEvent(l);
            }
            else
            {
                System.out.println("Cette salle est vide...");
            }
        } else {
            System.out.println("Salle du boss");
        }
    }

    public static void finirTour(Livreur l) {
        if (l.getHp() > 0) {
            int currentTour = nbSalle - lstSalle.size();
            // System.out.println("Vous êtes à la salle "+currentTour+" sur "+nbSalle);
            System.out.println("Tapez :\n " + bold(
                    "'A' pour afficher vos stat; \n 'I' pour utiliser un item; \n 'P' pour passer au tour suivant."));

            boolean continuer = false;
            char selec;

            do {
                selec = demanderLettre();
                if (selec == 'a') {
                    System.out.println("" + l + Color.BLACK + " (écrivez n'importe quoi pour skip)" + Color.RESET);
                    demanderLettre();
                } else if (selec == 'i') {
                    System.out.println(l.seeInventory() );
                    if (!l.isEmptyInventory()) {
                        char toUse = demanderLettre();
                        if (toUse >= '0' && toUse <= '9'){
                            Item item = l.inventory.get(toUse - '0');
                            if (item.getCons()){
                                l.useItem(item);
                                System.out.println("Vous avez utilisé 1x " + item.getNom());
                            } else {
                                l.equipItem(item);
                                System.out.println("Vous avez équipé 1x " + item.getNom());
                            }
                        }
                    }
                    System.out.println(""+Color.BLACK + " (écrivez n'importe quoi pour skip)" + Color.RESET);
                    demanderLettre();
                } else if (selec == 'p') {
                    continuer = true;
                    break;
                }
                clear();
                System.out.println("Tapez :\n " + bold("'A' pour afficher vos stat; \n 'I' pour utiliser un item; \n 'P' pour passer au tour suivant."));
                
            } while (!continuer);

            jouerTour(l);

        }
    }



    
    
    public static void main(String[] args)
    {
        clear();
        System.out.println(Color.RED + "________     __________                   _____________      _____     \n" +
                                       "___  __ \\_______  /__(_)__   ______________( )__  ____/_____ __  /_   \n" +
                                       "__  / / /  _ \\_  /__  /__ | / /  _ \\_  ___/|/__  __/  _  __ `/  __/  \n" +
                                       "_  /_/ //  __/  / _  / __ |/ //  __/  /      _  /___  / /_/ // /_      \n" +
                                       "/_____/ \\___//_/  /_/  _____/ \\___//_/       /_____/  \\__,_/ \\__/  \n" +
                                       "                                                                   " + Color.RESET);

        // Debuter Partie
        Livreur joueur = creerLivreur();
        lstSalle = genererSalles();
        int tour = 0;
        
        while (tour < lstSalle.size() && joueur.hp > 0)
        {
            jouerTour(joueur);
            finirTour(joueur);
        }
        sc.close();
    }




    


    
}
