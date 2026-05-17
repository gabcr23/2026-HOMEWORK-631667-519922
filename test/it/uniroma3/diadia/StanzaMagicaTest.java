package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

    private StanzaMagica stanza;
    // Definiamo una soglia bassa (2) per non dover scrivere decine di addAttrezzo nei test
    private static final int SOGLIA_TEST = 2; 

    @Before
    public void setUp() {
        // Inizializziamo la stanza usando il costruttore che accetta la soglia custom
        stanza = new StanzaMagica("Laboratorio", SOGLIA_TEST);
    }

    @Test
    public void testAggiuntaAttrezzoSottoSoglia() {
        // Inserimento 1: sotto la soglia (SOGLIA = 2)
        stanza.addAttrezzo(new Attrezzo("spada", 3));
        
        assertTrue("L'attrezzo dovrebbe essere presente con il suo nome originale", 
                   stanza.hasAttrezzo("spada"));
        assertEquals("Il peso non deve variare sotto la soglia magica", 
                     3, 
                     stanza.getAttrezzo("spada").getPeso());
    }

    @Test
    public void testAggiuntaAttrezzoSullaSoglia() {
        // Inserimento 1
        stanza.addAttrezzo(new Attrezzo("spada", 3)); 
        // Inserimento 2: ESATTAMENTE sulla soglia
        stanza.addAttrezzo(new Attrezzo("scudo", 5)); 
        
        assertTrue("L'attrezzo inserito sulla soglia non deve subire modifiche al nome", 
                   stanza.hasAttrezzo("scudo"));
        assertEquals("Il peso non deve variare per l'attrezzo inserito esattamente sulla soglia", 
                     5, 
                     stanza.getAttrezzo("scudo").getPeso());
    }
    @Test
    public void testAggiuntaAttrezzoOltreSoglia() {
        // Riempiamo la stanza fino alla soglia
        stanza.addAttrezzo(new Attrezzo("spada", 3)); // Ins. 1
        stanza.addAttrezzo(new Attrezzo("scudo", 5)); // Ins. 2
        
        // Inserimento 3: OLTRE la soglia. Scatta la magia.
        Attrezzo attrezzoDaModificare = new Attrezzo("torcia", 2);
        stanza.addAttrezzo(attrezzoDaModificare);
        
        // Confutazione: Verifichiamo che il vecchio nome NON esista più
        assertFalse("L'attrezzo originale non deve essere presente con il suo nome di base", 
                    stanza.hasAttrezzo("torcia"));
        
        // Verifica nome invertito: "torcia" -> "aicrot"
        assertTrue("L'attrezzo deve essere rintracciabile con il nome invertito", 
                   stanza.hasAttrezzo("aicrot"));
        
        // Verifica peso raddoppiato: 2 * 2 = 4
        assertEquals("Il peso dell'attrezzo magico deve essere raddoppiato", 
                     4, 
                     stanza.getAttrezzo("aicrot").getPeso());
    }

    @Test
    public void testInserimentoNullNonAlteraContatore() {
        // Se passiamo null, il metodo deve restituire false e NON incrementare i contatori interni
        stanza.addAttrezzo(null); 
        
        // Inseriamo due attrezzi veri
        stanza.addAttrezzo(new Attrezzo("spada", 3)); // Dovrebbe essere l'1
        stanza.addAttrezzo(new Attrezzo("scudo", 5)); // Dovrebbe essere il 2 (soglia)
        
        assertTrue("L'inserimento di un null non deve incrementare il contatore degli attrezzi posati", 
                stanza.hasAttrezzo("scudo"));
    }
}