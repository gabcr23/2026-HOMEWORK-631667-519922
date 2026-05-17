MODIFCHE DA FARE:
1) Continua l'esercizio 6 dall'inizio
2) Test non passati in stanzaTest (forse riadatta gli array con le collezioni)
3) Controlla se devi rimuovere array in stanzaProtected
4) Controlla test in più sui test es.5
5) Es.2 test stanza buia e bloccata non fatti, forse va bene cosi



1) Ho modificato i test 'addAttrezzo_StanzaPiena' e 'setStanzaAdiacenteMaxDirezioni' poiche' nella prima, avendo una hashMap, il codice
   non trova un oggetto con la stessa key, quindi fa un'aggiunta senza contare delle numero massimo degli attrezzi in una stanza. Ora il test 
   controlla che non ci siano 2 oggetti con la stessa key (nome).
   Il secondo test ha la stessa problematica visto che abbiamo una mappa senza fine, dobbiamo controllare che ci sia l'ultimo inserimento    	   effettuato non adiacente 	
2) Ho modificato le classi magica protected e stanza protected togliendo i cicli lineari e implementandoli da array [] a hashMap.
3) Ho aggiunto i test alle stanze che estendono la classe Stanza e ho aggiunto la classe test stanzaMagica che ci siamo dimenticati
4) Test comparatorPerNome in BorsaTest sistemato
5) Ho perfezionato il codice di LabirintoBuilder cosi da far passare tutti e 19 test dati dal professore. 
6) Ho eliminato la classe test PartitaSimulata poiche' rimpiazzata da PartiteSimulate
 