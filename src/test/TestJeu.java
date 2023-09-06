package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Jeu;



public class TestJeu
{

    @Test
    public void testGenererSalles()
    {
        assertTrue(Jeu.genererSalles().size() > 0);
    }

    /*

    @Test
    public void testCombat()
    {
        Livreur livreur = new Livreur("Nom", Societe.UberEats);
        Monstre monstre = new Monstre("Monstre", MonstreType.Guerrier);
        boolean resultatCombat = jeu.Combat(livreur, monstre);
        assertTrue(resultatCombat); // Assurez-vous que le livreur gagne dans ce cas.
    }

    @Test
    public void testActionJoueur()
    {

        Livreur livreur = new Livreur("Nom", Societe.UberEats);
        Monstre monstre = new Monstre("Monstre", MonstreType.Guerrier);


        char choixAttaque = 'P';
        jeu.actionJoueur(livreur, monstre, choixAttaque, null);
        assertEquals(monstre.getHp(), monstre.getMaxHp() - livreur.getPhysAtk());


        Item item = new Item("Potion", 20);
        livreur.ajouterObjet(item);
        char choixObjet = 'O';
        jeu.actionJoueur(livreur, monstre, choixObjet, null);
        assertTrue(livreur.getListeObjet().isEmpty());
    }
    */
}
