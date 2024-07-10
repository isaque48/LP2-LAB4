package br.edu.ufcg.computacao.mrbet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe responsável por criar o sistema do MrBet. Ela contém os atributos times,campeonatos e apostas.
 * @author Isaque Esdras Rocha - Matricula: 123110685
 */
public class MrBetSistema {
	/**
	 * Atributo dos times cadastrados no sistema.
	 */
	private HashMap<String, Time> times;
	
	/**
	 * Atributo dos campeonatos cadastrados no sistema.
	 */
	private HashMap<String,Campeonato> campeonatos;
	
	/**
	 * Atributo das apostas cadastradas no sistema.
	 */
	private ArrayList<Aposta> apostas;
	
	/**
	 * Construtor da classe MrBetSistema.
	 */
	public MrBetSistema() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}
	
	/**
	 * Método responsável por cadastrar um time no sistema, utilizando o codigo do time como chave para o hashMap times.
	 * @param codigo - Codigo que representa o time que será cadastrado
	 * @param nome - Nome do time que será cadastrado
	 * @param mascote - Mascote do time que será cadastrado.
	 * @return Uma string "TIME JÁ EXISTE!" caso o time ja tenha sido cadastrado; 
	 * Uma string "INCLUSÃO REALIZADA" caso o time tenha sido cadastrado com sucesso.
	 * @throws NullPointerException caso as entradas sejam nulas; 
	 * IllegalArgumentException caso as entradas sejam strings vazias.
	 */
	public String cadastraTime(String codigo, String nome, String mascote) {
		if(codigo == null || nome == null || mascote == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(codigo.trim().equals("") || nome.trim().equals("") || mascote.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(this.times.containsKey(codigo)) {
			return "TIME JÁ EXISTE!";
		}
		
		Time timeCadastro = new Time(codigo,nome,mascote);
		
		this.times.put(codigo, timeCadastro);
		return "INCLUSÃO REALIZADA!";
	}
	
	/**
	 * Método responsável por retornar uma representação textual do time cadastrado no sistema.
	 * @param codigo - Codigo que representa o time.
	 * @return Caso o time exista será retornado uma string com a representação textual dele; 
	 * "TIME NÃO EXISTE", caso o time nao tenha sido cadastrado no sistema.
	 * @throws NullPointerException caso a entrada seja nula; 
	 * IllegalArgumentException caso a entrada seja uma string vazia, ou caso o time não exista.
	 */
	public String recuperaTime(String codigo) {
		if(codigo == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(codigo.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(!(this.times.containsKey(codigo))) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
		
		return this.times.get(codigo).toString();
	}
	
	/**
	 * Método responsável por cadastrar um campeonato no sistema, utilizando o nome do campeonato em caps lock como chave do hashMap campeonatos.
	 * @param nome - Nome do capeonato
	 * @param nParticipantes - Número maximo de participantes do campeonato.
	 * @return Uma string "CAMPEONATO JÁ EXISTE!" caso o campeonato já tenha sido cadastrado no sistema, mesmo que escrito com outra variação de letras maisculas e minusculas;
	 * Uma string "CAMPEONATO ADICIONADO!" caso o campeonato tenha sido cadastrado com sucesso.
	 * @throws NullPointerException caso as entradas sejam nulas; 
	 * IllegalArgumentException caso as entradas sejam strings vazias.
	 */
	public String cadastraCampeonato(String nome, String nParticipantes) {
		if(nome == null || nParticipantes == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(nome.trim().equals("") || nParticipantes.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		int quantidadePart = Integer.parseInt(nParticipantes);
		Campeonato campCadastro = new Campeonato(nome,quantidadePart);
		
		if(this.campeonatos.containsKey(nome.toUpperCase())) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		
		this.campeonatos.put(nome.toUpperCase(),campCadastro);
		return "CAMPEONATO ADICIONADO!";
	}
	
	/**
	 * Método responsável por incluir um time em um campeonato.
	 * @param identTime - Identificador do time, ou seja, o codigo do time.
	 * @param idCampeonato - Identificador do  campeonato, ou seja, o nome do campeonato.
	 * @return "TIME INCLUIDO NO CAMPEONATO" caso o time tenha sido incluido com sucesso no campeonato ou caso o time já tenha sido adicionado ao campeonato anteriormente;
	 * "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!" caso o número maximo de participantes do campeonato já tenha sido atingido e o time não foi adicionado;
	 * @throws NullPointerException caso as entradas sejam nulas; 
	 * IllegalArgumentException caso as entradas sejam strings vazias, ou caso o time ou o campeonato não existam.
	 */
	public String incluiTimeEmCampeonato(String identTime, String identCampeonato) {
		if(identTime == null || identCampeonato == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(identTime.trim().equals("") || identCampeonato.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(!(this.times.containsKey(identTime))) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
		
		if(!(this.campeonatos.containsKey(identCampeonato.toUpperCase()))) {
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		}
		
		if(!(this.campeonatos.get(identCampeonato.toUpperCase()).adicionaTime(this.times.get(identTime)))) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}
		
		this.times.get(identTime).adicionaCampeonato(this.campeonatos.get(identCampeonato.toUpperCase())); 
		this.campeonatos.get(identCampeonato.toUpperCase()).adicionaTime(this.times.get(identTime));
		return "TIME INCLUÍDO NO CAMPEONATO";
	}
	
	 /**
	  * Método que verifica se um time em especifico existe em um campeonato especifico.
	  * @param identTime - Identificador do time, ou seja, o codigo do time.
	  * @param identCampeonato - Identificador do campeonato, ou seja, o nome do campeonato.
	  * @return "O TIME ESTÁ NO CAMPEONATO" caso o time exista no campeonato;
	  * "O TIME NÃO ESTÁ NO CAMPEONATO" caso o time não exista no campeonato.
	  * @throws NullPointerException caso as entradas sejam nulas; 
	  * IllegalArgumentException caso as entradas sejam strings vazias, ou caso o time ou o campeonato não existam.
	  */
	public String verificaTimeEmCampeonato(String identTime, String identCampeonato) {
		if(identTime == null | identCampeonato == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(identTime.trim().equals("") || identCampeonato.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(!(this.times.containsKey(identTime))) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
		
		if(!(this.campeonatos.containsKey(identCampeonato.toUpperCase()))) {
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		}
		
		if(this.campeonatos.get(identCampeonato.toUpperCase()).verificaTime(this.times.get(identTime))) {
			return "O TIME ESTÁ NO CAMPEONATO!";
		}
		
		return "O TIME NÃO ESTÁ NO CAMPEONATO!";
	}
	
	/**
	 * Método responsável por exibir os campeonatos que um time participa.
	 * @param identTime - Identificador do time, ou seja, o codigo do time.
	 * @return Uma lista com todos os campeonatos que o time participa no formato: Campeonatos do Nome-do-Time: 
	 * 								     	       Representação-Textual-da-Classe-Campeonato.
	 * @throws NullPointerException caso a entrada seja nula; 
	 * IllegalArgumentException caso a entrada seja uma string vazia, ou caso o time não exista.
	 */
	public String exibirCampeonatosDoTime(String identTime) {
		if(identTime == null) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(identTime.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(!(this.times.containsKey(identTime))) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
		
		Time equipe = this.times.get(identTime);
		return String.format("Campeonatos do %s:", equipe.getNome()) + equipe.getCampeonatosFormatados();
	}
	
	/**
	 * Método responsável por cadastrar uma aposta no sistema.
	 * @param identTime - Identificador do time, ou seja, o nome do time.
	 * @param posicao - Posição apostada que o time ficará no final do campeonato.
	 * @param valor - Valor que será apostado.
	 * @return "APOSTA NÃO REGISTRADA" caso a posição apostada, que o time ficará no final do campeonato, sejá uma posição maior que o número de participantes do campeonato;
	 * "APOSTA REGISTRADA" caso a aposta tenha sido cadastrada com sucesso no sistema.
	 * @throws NullPointerException caso as entradas sejam nulas; 
	 * IllegalArgumentException caso as entradas sejam strings vazias, ou caso o time ou o campeonato não existam.
	 */
	public String realizarAposta(String identTime, String identCampeonato, String posicao, String valor){
		if(identTime == null || identCampeonato == null || posicao == null || valor == null ) {
			throw new NullPointerException("Argumento Nulo");
		}
		
		if(identTime.trim().equals("") || identCampeonato.trim().equals("") || posicao.trim().equals("") || valor.trim().equals("")) {
			throw new IllegalArgumentException("Argumento Inválido");
		}
		
		if(!(this.times.containsKey(identTime))) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
		
		if(!(this.campeonatos.containsKey(identCampeonato.toUpperCase()))) {
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		}
		
		int posicaoAposta = Integer.parseInt(posicao);
		if(posicaoAposta > this.campeonatos.get(identCampeonato.toUpperCase()).getNParticipantesMax()) {
			return "APOSTA NÃO REGISTRADA!";
		}
		
		valor = valor.replace(",", ".");
		double valorAposta = Double.parseDouble(valor);
		
		Time timeApostado = this.times.get(identTime);
		Campeonato torneio = this.campeonatos.get(identCampeonato.toUpperCase());
		Aposta novaAposta = new Aposta(posicaoAposta, valorAposta, timeApostado, torneio);
		this.apostas.add(novaAposta);
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Método responsável por exibir as apostas cadastras no sistema.
	 * @return Uma lista das apostas, cadastradas no sistema, no formato: Posição-da-Aposta. Representação-Textual-da-Classe-Aposta
	 */
	public String exibirApostas() {
		String retorno = "";
		
		for(int indice = 0; indice < this.apostas.size();indice++) {
			retorno += (indice + 1) + ". " + this.apostas.get(indice).toString() + "\n";
		}
		
		return retorno;
	}
}
