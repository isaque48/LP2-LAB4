package br.edu.ufcg.computacao.mrbet;

/**
 * Classe que cria o tipo Aposta. Ela contém os atributos posicaoTabela,valorApostado,equipe e
 * torneio.
 * @author Isaque Esdras Rocha - Matrícula: 123110685.
 */

public class Aposta {
	
	/**
	 * Atributo correspondente a posição que o usuario aposta que o time ficará no campeonato.
	 */
	private int posicaoTabela;
	
	/**
	 * Atributo correspondente ao valor que o usuario está apostandando.
	 */
	private double valorApostado;
	
	/**
	 * Atributo correspondente ao time que o usuario está apostando.
	 */
	private Time equipe;
	
	/**
	 * Atributo correspondente ao campeonato no qual o time, que está sendo apostado, disputa.
	 */
	private Campeonato torneio;
	
	/**
	 * Construtor do tipo Aposta.
	 * @param posicao - posição na qual se está apostando que o time irá ficar.
	 * @param valor - valor apostado.
	 * @param timeAposta - time que está sendo apostado.
	 * @param torneioAposta - torneio no qual o time apostado disputa.
	 */
	public Aposta(int posicao, double valor, Time timeAposta, Campeonato torneioAposta) {
		this.posicaoTabela = posicao;
		this.valorApostado = valor;
		this.equipe = timeAposta;
		this.torneio = torneioAposta;
	}
	
	/**
	 * Sobrescreve o método toString, atualizando a representação em String da classe Aposta.
	 * @return Uma string no formato: [Código-do-Time] Nome-do-Time / Mascote-do-Time
	 * 				  Nome-do-Torneio-que-foi-Apostado
	 * 				  Posição-Apostada/Número-Máximo-de-Participantes-do-Torneio
	 * 				  R$ Valor-Apostado
	 * 
	 */
	@Override
	public String toString() {
		return this.equipe.toString() + "\n" + this.torneio.getNome() + "\n" + this.posicaoTabela + 
				"/" + this.torneio.getNParticipantesMax() + "\n" + String.format("R$ %.2f", this.valorApostado) + "\n";
	}
}
