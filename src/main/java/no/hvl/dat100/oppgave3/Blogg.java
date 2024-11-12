package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < getAntall(); i++) {
			if(innlegg.equals(innleggtabell[i])) {
				return i;
			}
		}

		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i = 0; i < getAntall(); i++) {
			if(innlegg.erLik(innleggtabell[i])) {
				return true;
			}
		}

		return false;
	}

	public boolean ledigPlass() {
		return getAntall() < innleggtabell.length - 1;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(ledigPlass() && !finnes(innlegg)) {
			leggTil(innlegg);
			return true;
		}
		return false;
	}
	
	public String toString() {
		String s = String.valueOf(getAntall());
		for(int i = 0; i < getAntall(); i++) {
			s += innleggtabell[i].toString();
		}

		return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}