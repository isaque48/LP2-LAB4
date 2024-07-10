package br.edu.ufcg.computacao.mrbet;

import java.util.HashSet;
import java.util.Objects;

/**
 * Classe que cria o tipo Campeonato. Ela contém os atributos nome, nParticipantesFinal, nParticipantesAtual e timesParticipantes.
 * @author Isaque Esdras Rocha - Matricula: 123110685.
 */

public class Campeonato {
	/**
	 * Atributo sobre o nome do campeonato.
	 */
	private String nome;
	
	/**
	 * Atributo sobre o número máximo de participantes do campeonato.
	 */
	private int nParticipantesMax;
	
	/**
	 * Atributo sobre a quantidade atual de participantes do campeonato.
	 */
	private int nParticipantesAtual;
	
	/**
	 * Atributo sobre os times que participam do campeonato.
	 */
	private HashSet<Time> timesParticipantes;
	
	/**
	 * Construtor da classe Campeonato. O atributo nParticipantesAtual começa zerado.
	 * @param nome - Nome do campeonato.
	 * @param numeroParticipantes - Número máximo de participantes do campeonato.
	 */
	public Campeonato(String nome, int numeroParticipantes) {
		this.nome = nome;
		this.nParticipantesMax = numeroParticipantes;
		this.timesParticipantes = new HashSet<>();
		this.nParticipantesAtual = 0;
	}
	
	/**
	 * Método para pegar o nome do campeonato.
	 * @return nome do campeonato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Método para adicionar um time ao hashSet de timesParticipantes.
	 * @param timeAdicionado - Time que será adicionado ao conjunto de timesParticipantes.
	 * @return true caso o time tenha sido adicionado corretamente ou se ele ja havia sido adicionado anteriormente, ou retorna false,
	 * caso o time nao tenha sido adicionado pois o campeonato já atingiu o número maximo de participantes.
	 */
	public boolean adicionaTime(Time timeAdicionado) {
		if(this.nParticipantesAtual >= this.nParticipantesMax) {
			return false;
		}
		
		if(this.timesParticipantes.contains(timeAdicionado)) {
			return true;
		}
		
		this.nParticipantesAtual++;
		this.timesParticipantes.add(timeAdicionado);
		return true;
	}
	
	/**
	 * Método que verifica se um time em especifico está no conjunto dos timesParticipantes do campeonato.
	 * @param timeAdicionado - time que será verificado se existe ou não no conjunto dos times participantes do campeonato.
	 * @return true caso o time esteja no campeonato, ou retorna false, caso o time não esteja no campeonato.
	 */
	public boolean verificaTime(Time timeAdicionado) {
		if(this.timesParticipantes.contains(timeAdicionado)) {
			return true;
		}
		
		return false;
	}

	/**
	 * Sobrescreve o método hashCode, utilizando o nome do campeonato para determinar o hashCode da classe.
	 * @return hashcode gerado apartir do nome do campeonato.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	/**
	 * Sobrescreve o método equals, utilizando o nome do campeonato como parametro para determinar se os campeonatos são iguais.
	 * @return true, caso os campeonatos sejam iguais, ou false, caso os campeonatos nao sejam iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}
	
	/**
	 * Sobrescreve o método toString, atualizando a representação em String da classe Campeonato.
	 * @return Uma string no formato: "* Nome-do-Campeonato - Número-de-Participantes-Atual/Número-Maximo-de-Participantes"
	 */
	@Override
	public String toString() {
		return String.format("* %s - %s/%s", this.nome,this.nParticipantesAtual,this.nParticipantesMax);
	}
	
	/**
	 * Método para pegar o número maximo de participantes do campeonato
	 * @return o numero maximo de participantes do campeonato
	 */
	public int getNParticipantesMax() {
		return this.nParticipantesMax;
	}
}
