package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	/*
	 * Il labirinto miniamale e' <<monolocale>> poiche' ci basta sapere solo se il contenuto della stanza sia uguale a quello richiesto
	 * per l'illuminazione
	 */
    private StanzaBuia stanzaBuia;

    @Before
    public void setUp() {
        stanzaBuia = new StanzaBuia("cantina", "lanterna");
    }

    @Test
    public void testDescrizioneSenzaAttrezzoIlluminante() {
        assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }

    @Test
    public void testDescrizioneConAttrezzoIlluminante() {
        stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 1));
        assertNotEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
        assertTrue(stanzaBuia.getDescrizione().contains("cantina"));
    }

    @Test
    public void testStanzaBuiaSiComportaComeStanzaNormale() {
        stanzaBuia.addAttrezzo(new Attrezzo("chiave", 1));
        assertTrue(stanzaBuia.hasAttrezzo("chiave"));
    }
    @Test
    public void testDescrizioneConAttrezzoSbagliato() {
        // Inserisco un attrezzo che non è la "lanterna"
        stanzaBuia.addAttrezzo(new Attrezzo("osso", 1));
        
        // SINTASSI JUNIT 4: messaggio, valore_atteso, valore_reale
        assertEquals("La stanza deve rimanere buia se l'attrezzo inserito non e' quello illuminante",
                     "qui c'è un buio pesto", 
                     stanzaBuia.getDescrizione());
    }
    @Test
    public void testAggiuntaERimozioneAttrezzoIlluminante() {
        Attrezzo lanterna = new Attrezzo("lanterna", 1);
        
        // Fase 1: Inserisco e accendo la luce
        stanzaBuia.addAttrezzo(lanterna);
        assertNotEquals("La stanza deve illuminarsi con la lanterna",
                        "qui c'è un buio pesto", 
                        stanzaBuia.getDescrizione());
        
        // Fase 2: Rimuovo la luce
        stanzaBuia.removeAttrezzo(lanterna);
        
        // Fase 3: Verifico il ripristino del buio
        assertEquals("Dopo aver rimosso la lanterna, la stanza deve tornare buia",
                     "qui c'è un buio pesto", 
                     stanzaBuia.getDescrizione());
    }
}
