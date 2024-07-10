package br.edu.ufcg.computacao.mrbet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampeonatoTeste {
	Campeonato camp;
	
	@BeforeEach
	void criaCampeonato() {
		this.camp = new Campeonato("Campeonato Teste",2);
	}
	
	@Test
	void adicionaTimeValidoTeste() {
		Time equipe = new Time("002_RJ","Flamengo","Urubu");
		
		assertTrue(this.camp.adicionaTime(equipe));
	}
	
	@Test
	void adicionaTimeRepetidoTeste() {
		Time equipe = new Time("002_RJ","Flamengo","Urubu");
		Time equipe2 = new Time("002_RJ","Flamengo","Urubu");
		
		assertTrue(this.camp.adicionaTime(equipe2));
	}
	
	@Test
	void adicionaTimeAcimaDoLimiteTeste() {
		Time equipe = new Time("002_RJ","Flamengo","Urubu");
		Time equipe2 = new Time("250_PB","Nacional de Patos","Canário");
		Time equipe3 = new Time("252_PB","Sport Lagoa Seca","Carneiro");
		this.camp.adicionaTime(equipe);
		this.camp.adicionaTime(equipe2);
		
		assertFalse(this.camp.adicionaTime(equipe3));
	}
	
	@Test
	void verificaTimePresenteNoCampeonatoTeste() {
		Time equipe = new Time("002_RJ","Flamengo","Urubu");
		this.camp.adicionaTime(equipe);
		
		assertTrue(this.camp.verificaTime(equipe));
	}
	
	@Test
	void verificaTimeNaoPresenteNoCampeonatoTeste() {
		Time equipe = new Time("002_RJ","Flamengo","Urubu");
		
		assertFalse(this.camp.verificaTime(equipe));
	}
	

}
