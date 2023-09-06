package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Monstre;

public class MonstreTest {
    @Test
    public void testCreateurMonstre(){
        Monstre m = new Monstre("Maxime",100,99,98,97,96,95);
        assertNotNull(m);
    }

}
