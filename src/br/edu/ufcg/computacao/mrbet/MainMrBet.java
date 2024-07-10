package br.edu.ufcg.computacao.mrbet;

import java.util.Scanner;

/**
 * Interface com menus texto para controlar o sistema MrBetSistema.
 * 
 * @author Isaque Esdras Rocha - Matrícula: 123110685
 *
 */

public class MainMrBet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MrBetSistema mr = new MrBetSistema();
		
		String escolha = "";
		while (true) {
			escolha = menu(sc);
			comando(escolha,mr,sc);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println("\n(M)Minha inclusão de times\n" + 
				"(R)Recuperar time\n" + 
				"(.)Adicionar campeonato\n" + 
				"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" + 
				"(E)Exibir campeonatos que o time participa\n" + 
				"(T)Tentar a sorte e status\n" + 
				"(!)Já pode fechar o programa!\n" + 
				"\n" + 
				"Opção> ");
		return scanner.nextLine().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, MrBetSistema mr, Scanner scanner) {
		switch(opcao) {
			case "M":
				criarTime(mr,scanner);
				break;
			case "R":
				recuperaTime(mr,scanner);
				break;
			case ".":
				criarCampeonato(mr,scanner);
				break;
			case "B":
				incluirOuVerificaTime(mr,scanner);
				break;
			case "E":
				exibeCampeonatosTime(mr,scanner);
				break;
			case "T":
				apostaOuStatus(mr,scanner);
				break;
			case "!":
				finaliza();
				break;
			default:
				throw new IllegalArgumentException("Comando inválido");	
		}
	}
	
	/**
	 * Cadastra um time no sistema.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void criarTime(MrBetSistema mr, Scanner sc) {
		System.out.print("\nCódigo: ");
		String codigo = sc.nextLine();
		System.out.print("\nNome: ");
		String nome = sc.nextLine();
		System.out.print("\nMascote: ");
		String mascote = sc.nextLine();
		System.out.println(mr.cadastraTime(codigo, nome, mascote));
	}
	
	/**
	 * Exibe um time cadastrado no sistema.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void recuperaTime(MrBetSistema mr, Scanner sc) {
		System.out.print("\nCódigo: ");
		String codigo = sc.nextLine();
		System.out.println(mr.recuperaTime(codigo));
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void finaliza() {
		System.out.println("\nPor hoje é só pessoal!");
		System.exit(0);
	}
	
	/**
	 * Cadastra um campeonato no sistema.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void criarCampeonato(MrBetSistema mr, Scanner sc) {
		System.out.print("\nCampeonato: ");
		String camp = sc.nextLine();
		System.out.print("\nParticipantes: ");
		String participantes = sc.nextLine();
		System.out.println(mr.cadastraCampeonato(camp, participantes));
	}
	
	/**
	 * Inclui um time em um campeonato ou verifica se um time está presente em um determinado campeonato.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void incluirOuVerificaTime(MrBetSistema mr, Scanner sc) {
		System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
		String escolha = sc.nextLine().toUpperCase();
		switch(escolha) {
		case "I":
			incluiTime(mr,sc);
			break;
		case "V":
			verificaTime(mr,sc);
			break;
		default:
			throw new IllegalArgumentException("Comando inválido");	
		}
	}
	
	/**
	 * Inclui um time em um determinado campeonato.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void incluiTime(MrBetSistema mr,Scanner sc) {
		System.out.print("Código: ");
		String codigoTime = sc.nextLine();
		System.out.print("Campeonato: ");
		String campeonatoEscolhido = sc.nextLine();
		System.out.println(mr.incluiTimeEmCampeonato(codigoTime, campeonatoEscolhido));
	}
	
	/**
	 * Verifica se um determinad time está presente em um determinado campeonato.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void verificaTime(MrBetSistema mr, Scanner sc) {
		System.out.print("Código: ");
		String codigoTime = sc.nextLine();
		System.out.print("Campeonato: ");
		String campeonatoEscolhido = sc.nextLine();
		System.out.println(mr.verificaTimeEmCampeonato(codigoTime, campeonatoEscolhido));
	}
	
	/**
	 * Exibe todos os campeonatos que um time está participando.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void exibeCampeonatosTime(MrBetSistema mr, Scanner sc) {
		System.out.print("Time: ");
		String time = sc.nextLine();
		System.out.println(mr.exibirCampeonatosDoTime(time));
	}
	
	/**
	 * Cadastra uma aposta no sistema ou exibe todas as apostas cadastras no sistema
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void apostaOuStatus(MrBetSistema mr, Scanner sc) {
		System.out.println("(A)Apostar ou (S)Status das Apostas?");
		String escolha = sc.nextLine().toUpperCase();
		switch(escolha) {
		case "A":
			realizaAposta(mr,sc);
			break;
		case "S":
			exibeStatus(mr,sc);
			break;
		default:
			throw new IllegalArgumentException("Comando inválido");	
		}
	}
	
	/**
	 * Cadastra uma aposta no sistema.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void realizaAposta(MrBetSistema mr, Scanner sc) {
		System.out.print("Código: ");
		String codigoTime = sc.nextLine();
		System.out.print("Campeonato: ");
		String campeonatoEscolhido = sc.nextLine();
		System.out.print("Colocação: ");
		String colocacao = sc.nextLine();
		System.out.print("Valor da Aposta: R$");
		String valor = sc.nextLine();
		System.out.println(mr.realizarAposta(codigoTime, campeonatoEscolhido, colocacao, valor));
	}
	
	/**
	 * Exibe todas as apostas cadastras no sistema.
	 * @param mr - O sistema MrBetSistema a ser manipulado.
	 * @param sc - Scanner para pedir informações do contato.
	 */
	private static void exibeStatus(MrBetSistema mr, Scanner sc) {
		System.out.println("Apostas: \n");
		System.out.print(mr.exibirApostas());
	}

}
