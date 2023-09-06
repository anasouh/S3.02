package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Livreur;
import main.Societe;


public class LivreurTest {
    
    @Test
    public void testCreationLivreur(){
        Livreur livreur = new Livreur("Maxime",Societe.Deliveroo);
        assertEquals(livreur.getName(),"Maxime");
        assertEquals(livreur.getSociete(),Societe.Deliveroo);
    }

    @Test
    public void testGetHp(){
        Livreur livreur = new Livreur("Maxime",Societe.UberEats);
        assertEquals(livreur.getHp(),100,0);
    }

    @Test
    public void testSetHp(){
        Livreur l = new Livreur("Maxime",Societe.UberEats);
        assertEquals(l.getHp(),100,0);
        l.setHp(20);
        assertEquals(l.getHp(), 20, 0);
    }

    
}
