package br.edu.ufcg.computacao.mrbet;

import java.util.HashSet;
import java.util.Objects;

/**
 * Classe que cria o tipo Time. Ela contém os atributos codigo, nome, mascote e campeonatosAtuais.
 * @author Isaque Esdras Rocha - Matricula:123110685
 */

public class Time {
	/**
	 * Atributo do codigo que representa o time.
	 */
	private String codigo;
	
	/**
	 * Atributo do nome do time.
	 */
	private String nome;
	
	/**
	 * Atributo do mascote do time.
	 */
	private String mascote;
	
	/**
	 * Atributo sobre os campeonatos que o time disputa atualmente.
	 */
	private HashSet<Campeonato> campeonatosAtuais;
	
	/**
	 * Construtor da classe Time.
	 * @param codigo - codigo que representa o time
	 * @param nome - nome do time
	 * @param mascote - mascote do time
	 */
	public Time(String codigo, String nome, String mascote) {	
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
		this.campeonatosAtuais = new HashSet<>();
	}
	
	
	/**
	 * Sobrescreve o método toString, atualizando a representação em String da classe Time.
	 * @return Uma string no formato: "[Codigo-do-Time] Nome-do-Time / Mascote-do-Time"
	 */
	@Override
	public String toString() {
		return String.format("[%s] %s / %s", this.codigo, this.nome, this.mascote);
	}

	/**
	 * Sobrescreve o método hashCode, utilizando o codigo do time para determinar o hashCode da classe.
	 * @return hashcode gerado apartir do codigo do time.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	/**
	 * Sobrescreve o método equals, utilizando o codigo do time como parametro para determinar se os times são iguais.
	 * @return true, caso os times sejam iguais, ou false, caso os times nao sejam iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	/**
	 * Metodo que adiciona um campeonato ao conjunto dos campeonatos que o time participa.
	 * @param camp - Campeonato que será adicionado ao conjunto de campeonatosAtuais.
	 */
	public void adicionaCampeonato(Campeonato camp) {	
		this.campeonatosAtuais.add(camp);
	}
	
	/**
	 * Método usado para pegar os campeonatos que o time participa.
	 * @return Uma string composta pela representação textual dos campeonatos com um \n entre cada representação.
	 */
	public String getCampeonatosFormatados() {
		String retorno = "";
		
		for(Campeonato campTemporario : this.campeonatosAtuais) {
			retorno += "\n" + campTemporario.toString();
		}
		
		return retorno;
	}
	
	/**
	 * Método usado para pegar o nome do campeonato
	 * @return nome do campeonato
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Método para pegar o hashSet de campeonatos que o time participa.
	 * @return O conjunto dos campeonatos que o time participa
	 */
	public HashSet<Campeonato> getCampeonatos(){
		return this.campeonatosAtuais;
	}

}
