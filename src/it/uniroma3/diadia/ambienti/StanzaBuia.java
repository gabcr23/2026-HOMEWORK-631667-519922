package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	//variabili d'istanza
	private String attrezzoCheIllumina;

	//Costruttore
	public StanzaBuia(String nome, String attrezzoCheIllumina) {
		super(nome);
		this.attrezzoCheIllumina = attrezzoCheIllumina;
	}

	
	// Restituisce la descrizione della stanza.
	// Se manca l'attrezzo che illumina, la stanza risulta buia
	// e viene mostrato un messaggio di oscurit� totale.
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(this.attrezzoCheIllumina))  //se NON presente...
			return "qui c'è un buio pesto";
		return super.getDescrizione();
	}
}
