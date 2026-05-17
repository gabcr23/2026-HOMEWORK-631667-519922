package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class StanzaProtected {


    protected String nome;
    protected Map<String, Attrezzo> attrezzi;
    protected Map<String, StanzaProtected> stanzeAdiacenti;
    //Costruttore
    public StanzaProtected(String nome) {
        this.nome = nome;
        this.attrezzi=new HashMap<>();
        this.stanzeAdiacenti= new HashMap<>();
    }
    
    
    /**
     * Imposta una stanza adiacente.
     * Ora abbiamo un numero illimitato di direzioni e se esiste gia', sovrascrive il riferimento alla vecchia, alla nuova
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
       this.stanzeAdiacenti.put(direzione,stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     * @return stanza, o null se non esiste un'uscita con quella direzione
     */
	public StanzaProtected getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Collection<Attrezzo> getAttrezzi() {
        return this.attrezzi.values();
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo == null) return false;
        return this.attrezzi.put(attrezzo.getNome(),attrezzo)==null;
    }

    
    /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	risultato.append(this.stanzeAdiacenti.keySet().toString());
    	risultato.append("\nAttrezzi nella stanza: ");
    	risultato.append(this.attrezzi.values().toString());
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)return false;
		return this.attrezzi.remove(attrezzo.getNome())!=null;
	}

	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
    }
	
	
}
