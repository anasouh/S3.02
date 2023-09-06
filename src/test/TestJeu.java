package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Jeu;
import main.Livreur;

import static org.junit.jupiter.api.Assertions.*;


public class TestJeu
{
    private Jeu jeu;

    @BeforeEach
    public void setUp() {
        jeu = new Jeu();
    }

    @Test
    public void testCreerLivreur()
    {
        Livreur livreur = jeu.creerLivreur();
        assertNotNull(livreur);
        assertNotNull(livreur.getName());
        assertNotNull(livreur.getSociete());
    }

    @Test
    public void testGenererSalles()
    {

        jeu.genererSalles();
      
        assertTrue(jeu.getLstSalle().size() > 0);
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
