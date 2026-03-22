package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;


class GiocatoreTest {

	
    private Giocatore giocatore;
    

    
    @BeforeEach
    void setUp() {
        this.giocatore = new Giocatore();
    }

    
    

    @Test
    void testCostruttoreInizializzaCFU() {
        assertEquals(20, giocatore.getCfu()); //I CFU iniziali sono 20
    }

    @Test
    void testCostruttoreInizializzaBorsa() {
        assertNotNull(giocatore.getBorsa());
    }

    @Test
    void testCostruttoreCreaBorsaVuota() {
        assertTrue(giocatore.getBorsa().isEmpty());
    }

   
    
    
    @Test
    void testSetCfuModificaValore() {
        giocatore.setCfu(10);
        assertEquals(10, giocatore.getCfu());
    }

    @Test
    void testSetCfuAZero() {
        giocatore.setCfu(0);
        assertEquals(0, giocatore.getCfu());
    }

    @Test
    void testSetCfuAValoreNegativo() {
        giocatore.setCfu(-5);
        assertEquals(-5, giocatore.getCfu()); //Nota: il metodo setCfu() non impedisce
                                             // valori negativi!
    }

    
    
    
    @Test
    void testGetCfuValoreIniziale() {
        assertEquals(20, giocatore.getCfu());
    }

    @Test
    void testGetCfuDopoModifica() {
        giocatore.setCfu(15);
        assertEquals(15, giocatore.getCfu());
    }

    @Test
    void testGetCfuDopoModificaNegativa() {
        giocatore.setCfu(-3);                //anche qui...Nota: il metodo setCfu() non impedisce
                                            // valori negativi!
        assertEquals(-3, giocatore.getCfu());
    }

    
    
}
