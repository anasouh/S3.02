package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Item;
import main.ItemType;


public class ItemTest {
    @Test
    public void testGetNom(){
        Item item = Item.BATON;
        assertTrue(item.getNom().equals("Baton"));
        assertFalse(item.getNom().equals("Apagnan"));
    }

    @Test
    public void testGetCons(){
        Item baton = Item.BATON;
        assertFalse(baton.getCons());
        Item kebab = Item.KEBAB;
        assertTrue(kebab.getCons());
    }

    @Test
    public void testGetType(){
        Item baton = Item.BATON;
        assertEquals(ItemType.ARME,baton.getType());
        Item kebab = Item.KEBAB;
        assertNull(kebab.getType());
    }

    @Test
    public void testGetModifiedStat(){
        Item baton = Item.BATON;
        assertEquals(baton.getModifiedStat(),"atk");
        assertNotEquals(baton.getModifiedStat(),"hp");
    }

    @Test
    public void testGetPoints(){
        Item kebab = Item.KEBAB;
        assertEquals(kebab.getpoints(),20);
        assertNotEquals(kebab.getpoints(),1000);
    }

    @Test
    public void testRandomObjet(){
        Item item1 = Item.randomObjet();
        Item item2 = Item.randomObjet();
        assertNotEquals(item1,item2);
    }

    @Test
    public void testEstCommande(){
        Item kebab = Item.KEBAB;
        Item cmd = Item.COMMANDE;
        assertFalse(kebab.estCommande());
        assertTrue(cmd.estCommande());
    }
}
