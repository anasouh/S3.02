package main;

import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre nom de personnage : ");
        String nom = sc.nextLine();
        Livreur perso = new Livreur(nom, Societe.Deliveroo);
        System.out.println();
        System.out.println("Ok " + perso.name + ", voici vos statistiques : ");
        System.out.println(perso);
        sc.close();
    }
}
