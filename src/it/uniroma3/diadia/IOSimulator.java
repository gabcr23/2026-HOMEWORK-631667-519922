package it.uniroma3.diadia;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class IOSimulator implements IO{

	private List<String> righeDaLeggere;
	private int indiceLettura;
	
	//Mappiamo l'indice della riga letta ai messaggi generati
	private Map<Integer, List<String>> inputToOutputMap;
	
	//Raccogliamo tutti i messaggi in ordine, per aiutarci nei test
	private List<String> tuttiIMessaggiProdotti;
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.tuttiIMessaggiProdotti=new ArrayList<>();
		this.inputToOutputMap=new HashMap<>();	
		}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.tuttiIMessaggiProdotti.add(messaggio);
		int indiceUltimoComando=this.indiceLettura-1;
		if(indiceUltimoComando>=0 && this.inputToOutputMap.containsKey(indiceUltimoComando)) {
			this.inputToOutputMap.get(indiceUltimoComando).add(messaggio);
		}
	}
	@Override
	public String leggiRiga() {
		if(this.indiceLettura < this.righeDaLeggere.size()) {
			String riga=this.righeDaLeggere.get(this.indiceLettura);
			this.inputToOutputMap.put(this.indiceLettura, new ArrayList<>());
			this.indiceLettura++;
			return riga;
		}
		return "fine";
	}
	
	//Getter
	public List<String> getMessaggiStampati() {
	    return this.tuttiIMessaggiProdotti;
	}
	public List<String> getMessaggiDiComandoAlNumero(int indiceComando) {
        return this.inputToOutputMap.get(indiceComando);
    }
	public boolean hasMessaggio(String messaggioAtteso) {
		if(messaggioAtteso==null)return false;
		for(String msg: this.tuttiIMessaggiProdotti) {
			if(msg!=null && msg.contains(messaggioAtteso)) {
				return true;
			}
		}
		return false;
	}

}
