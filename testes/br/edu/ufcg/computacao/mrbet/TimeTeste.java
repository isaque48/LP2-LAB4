package br.edu.ufcg.computacao.mrbet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTeste {
	
	Campeonato camp;
	Time equipe;
	
	  @BeforeEach
	    void criaTime(){
	        this.equipe = new Time("002_RJ", "Flamengo", "Urubu");
	        this.camp = new Campeonato("Brasileirao", 20);
	    }

	@Test
	void adicionaCampeonato() {
		assertFalse(this.equipe.getCampeonatos().contains(camp));
		this.equipe.adicionaCampeonato(camp);
		assertTrue(this.equipe.getCampeonatos().contains(camp));
	}
	
	@Test
	void imprimeCampeonatos() {
		Campeonato liberta = new Campeonato("Libertadores",32);
		this.equipe.adicionaCampeonato(camp);
		this.equipe.adicionaCampeonato(liberta);
		
		assertEquals("\n* Brasileirao - 0/20" + "\n* Libertadores - 0/32" , this.equipe.getCampeonatosFormatados());
	}

}
