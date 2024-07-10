package br.edu.ufcg.computacao.mrbet;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MrBetSistemaTeste {
	
	MrBetSistema mr;
	
	@BeforeEach
	void criarSistema() {
		this.mr = new MrBetSistema();
	}

	@Test
	void criarTimeEntradaNulaTeste1() {
		try {
			mr.cadastraTime(null, null, null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void criarTimeEntradaNulaTeste2() {
		try {
			mr.cadastraTime(null, "Flamengo", "Urubu");
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}

	@Test
	void criarTimeEntradaNulaTeste3() {
		try {
			mr.cadastraTime("002_RJ", null, "Urubu");
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}

	@Test
	void criarTimeEntradaNulaTeste4() {
		try {
			mr.cadastraTime("002_RJ", "Flamengo", null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void criarTimeEntradaVaziaTeste1() {
		try {
			mr.cadastraTime("", "", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void criarTimeEntradaVaziaTeste2() {
		try {
			mr.cadastraTime("", "Flamengo", "Urubu");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void criarTimeEntradaVaziaTeste3() {
		try {
			mr.cadastraTime("002_RJ", "", "Urubu");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void criarTimeEntradaVaziaTeste4() {
		try {
			mr.cadastraTime("002_RJ", "Flamengo", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void criaTimeValidoTeste() {
		assertEquals("INCLUSÃO REALIZADA!",mr.cadastraTime("002_RJ", "Flamengo", "Urubu"));
	}
	
	@Test
	void criaTimeJaExistenteTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		assertEquals("TIME JÁ EXISTE!",mr.cadastraTime("002_RJ", "Flamengo", "Urubu"));
	}
	
	@Test
	void recuperaTimeEntradaNulaTeste() {
		try {
			mr.recuperaTime(null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void recuperaTimeEntradaVaziaTeste() {
		try {
			mr.recuperaTime("");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void recuperaTimeNaoExistenteTeste() {
		try {
			mr.recuperaTime("002_RJ");
		} catch(IllegalArgumentException erro) {
			assertEquals("O TIME NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void recuperaTimeValidoTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		assertEquals("[002_RJ] Flamengo / Urubu", mr.recuperaTime("002_RJ"));
	}
	
	@Test
	void cadastraCampeonatoEntradaNulaTeste1() {
		try {
			mr.cadastraCampeonato(null,null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void cadastraCampeonatoEntradaNulaTeste2() {
		try {
			mr.cadastraCampeonato("Brasileirao", null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void cadastraCampeonatoEntradaNulaTeste3() {
		try {
			mr.cadastraCampeonato(null, "2");
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void cadastraCampeonatoEntradaVaziaTeste1() {
		try {
			mr.cadastraCampeonato("", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void cadastraCampeonatoEntradaVaziaTeste2() {
		try {
			mr.cadastraCampeonato("Brasileirao", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void cadastraCampeonatoEntradaVaziaTeste3() {
		try {
			mr.cadastraCampeonato("", "2");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void cadastraCampeonatoValidoTeste() {
		assertEquals("CAMPEONATO ADICIONADO!",mr.cadastraCampeonato("Brasileirão série A 2023", "20"));
	}
	
	@Test
	void cadastraCampeonatoComNomeJaExistenteTeste1() {
		mr.cadastraCampeonato("Brasileirão série A 2023", "40");
		assertEquals("CAMPEONATO JÁ EXISTE!",mr.cadastraCampeonato("Brasileirão série A 2023", "20"));
	}
	
	@Test
	void cadastraCampeonatoComNomeJaExistenteTeste2() { //dessa vez testando com uma variação de letras minusculas e maisculas
		mr.cadastraCampeonato("brasileirão SÉRIE a 2023", "40");
		assertEquals("CAMPEONATO JÁ EXISTE!",mr.cadastraCampeonato("Brasileirão série A 2023", "20"));
	}
	
	@Test
	void incluiTimeCampeonatoEntradaNulaTeste1() {
		try {
			mr.incluiTimeEmCampeonato(null, null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void incluiTimeCampeonatoEntradaNulaTeste2() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.incluiTimeEmCampeonato("002_RJ", null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void incluiTimeCampeonatoEntradaNulaTeste3() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.incluiTimeEmCampeonato(null, "Brasileirao");
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void incluiTimeCampeonatoEntradaVaziaTeste1() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.incluiTimeEmCampeonato("", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void incluiTimeCampeonatoEntradaVaziaTeste2() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.incluiTimeEmCampeonato("002_RJ", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}

	@Test
	void incluiTimeCampeonatoEntradaVaziaTeste3() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.incluiTimeEmCampeonato("", "Brasileirao");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void incluiTimeCampeonatoValidoTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		assertEquals("TIME INCLUÍDO NO CAMPEONATO",mr.incluiTimeEmCampeonato("002_RJ", "Brasileirao"));
	}
	
	@Test
	void incluiTimeCampeonatoComLimiteTimesAtingidoTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraTime("250_PB", "Nacional de Patos", "Canário");
		mr.cadastraTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mr.cadastraCampeonato("Torneio", "2");
		mr.incluiTimeEmCampeonato("002_RJ", "Torneio");
		mr.incluiTimeEmCampeonato("250_PB", "Torneio");
		
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!",mr.incluiTimeEmCampeonato("252_PB", "Torneio"));
	}
	
	@Test
	void incluiTimeNaoExistenteCampeonatoTeste() {
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.incluiTimeEmCampeonato("002_RJ", "Brasileirao");
		}catch(IllegalArgumentException erro) {
			assertEquals("O TIME NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void incluiTimeCampeonatoNaoExistenteTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		
		try {
			mr.incluiTimeEmCampeonato("002_RJ", "Brasileirao");
		}catch(IllegalArgumentException erro) {
			assertEquals("O CAMPEONATO NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeEntradaNulaTeste1() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.verificaTimeEmCampeonato(null, null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeEntradaNulaTeste2() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.verificaTimeEmCampeonato("002_RJ", null);
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeEntradaNulaTeste3() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.verificaTimeEmCampeonato(null, "Brasileirao");
		} catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeEntradaVaziaTeste1() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.verificaTimeEmCampeonato("", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeEntradaVaziaTeste2() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.verificaTimeEmCampeonato("002_RJ", "");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeEntradaVaziaTeste3() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.verificaTimeEmCampeonato("", "Brasileirao");
		} catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeNaoExistenteTeste() {
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.verificaTimeEmCampeonato("002_RJ", "Brasileirao");
		}catch(IllegalArgumentException erro) {
			assertEquals("O TIME NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeEmCampeonatoNaoExistenteTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");

		try {
			mr.verificaTimeEmCampeonato("002_RJ", "Brasileirao");
		}catch(IllegalArgumentException erro) {
			assertEquals("O CAMPEONATO NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void verificaExistenciaTimeValidoTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		mr.incluiTimeEmCampeonato("002_RJ", "Brasileirao");
		
		assertEquals("O TIME ESTÁ NO CAMPEONATO!",mr.verificaTimeEmCampeonato("002_RJ", "Brasileirao"));
	}
	
	@Test
	void verificaNaoExistenciaTimeValidoTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraTime("250_PB", "Nacional de Patos", "Canário");
		mr.cadastraCampeonato("Brasileirao", "20");
		mr.incluiTimeEmCampeonato("002_RJ", "Brasileirao");
		
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!",mr.verificaTimeEmCampeonato("250_PB", "Brasileirao"));
	}
	
	@Test
	void exibeCampeonatosTimeEntradaNulaTeste() {
		try {
			mr.exibirCampeonatosDoTime(null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void exibeCampeonatosTimeEntradaVaziaTeste() {
		try {
			mr.exibirCampeonatosDoTime("");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void exibeCampeonatosTimeNaoExistenteTeste() {
		try {
			mr.exibirCampeonatosDoTime("002_RJ");
		}catch(IllegalArgumentException erro) {
			assertEquals("O TIME NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void exibeCampeonatosTimeValidoTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		mr.cadastraCampeonato("Libertadores", "32");
		mr.incluiTimeEmCampeonato("002_RJ", "Brasileirao");
		mr.incluiTimeEmCampeonato("002_RJ", "Libertadores");
		
		assertEquals("Campeonatos do Flamengo:\n" + "* Brasileirao - 1/20" + "\n* Libertadores - 1/32", mr.exibirCampeonatosDoTime("002_RJ"));
	}
	
	@Test
	void realizaApostaEntradaNulaTeste1() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta(null, null, null, null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaNulaTeste2() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta(null,"Brasileirao","1","250,50");
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}

	@Test
	void realizaApostaEntradaNulaTeste3() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("002_RJ", null, "1", "250,5");
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaNulaTeste4() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("002_RJ", "Brasileirao", null, "250,50");
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaNulaTeste5() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("002_RJ", "Brasileirao", "1", null);
		}catch(NullPointerException erro) {
			assertEquals("Argumento Nulo",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaVaziaTeste1() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("", "", "", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaVaziaTeste2() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("", "Brasileirao", "1", "250,50");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaVaziaTeste3() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("002_RJ", "", "1", "250,50");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaVaziaTeste4() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("002_RJ", "Brasileirao", "", "250,50");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaEntradaVaziaTeste5() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("002_RJ", "Brasileirao", "1", "");
		}catch(IllegalArgumentException erro) {
			assertEquals("Argumento Inválido",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaTimeNaoExistenteTeste() {
		mr.cadastraCampeonato("Brasileirao", "20");
		
		try {
			mr.realizarAposta("002_RJ", "Brasileirao", "1", "250,50");
		}catch(IllegalArgumentException erro) {
			assertEquals("O TIME NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaCampeonatoNaoExistenteTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		
		try {
			mr.realizarAposta("002_RJ", "Brasileirao", "1", "250,50");
		}catch(IllegalArgumentException erro) {
			assertEquals("O CAMPEONATO NÃO EXISTE!",erro.getMessage());
		}
	}
	
	@Test
	void realizaApostaAcimaDaQuantidadeDeTimesTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		assertEquals("APOSTA NÃO REGISTRADA!", mr.realizarAposta("002_RJ", "Brasileirao", "21", "250,50"));
	}
	
	@Test
	void realizaApostaValidaTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraCampeonato("Brasileirao", "20");
		
		assertEquals("APOSTA REGISTRADA!", mr.realizarAposta("002_RJ", "Brasileirao", "1", "250,50"));
	}
	
	@Test
	void exibirApostasTeste() {
		mr.cadastraTime("002_RJ", "Flamengo", "Urubu");
		mr.cadastraTime("250_PB", "Nacional de Patos", "Canário");
		mr.cadastraTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mr.cadastraCampeonato("Brasileirao", "20");
		mr.realizarAposta("002_RJ", "Brasileirao", "1", "500.50");
		mr.realizarAposta("250_PB", "Brasileirao", "2", "300,25");
		mr.realizarAposta("252_PB", "Brasileirao", "3", "400");
		
		assertEquals("1. [002_RJ] Flamengo / Urubu\n" + "Brasileirao\n" + "1/20\n" + "R$ 500.50\n\n" +
				"2. [250_PB] Nacional de Patos / Canário\n" + "Brasileirao\n" + "2/20\n" + "R$ 300.25\n\n" + 
				"3. [252_PB] Sport Lagoa Seca / Carneiro\n" + "Brasileirao\n" + "3/20\n" + "R$ 400.00\n\n", mr.exibirApostas());
	}
}
