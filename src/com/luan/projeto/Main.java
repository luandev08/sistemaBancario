package com.luan.projeto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void consultarSaldo(Scanner sc, Banco banco) {
		try {
			System.out.println("Digite o id desejado:");

			int id = sc.nextInt();

			System.out.println("R$ " + banco.getSaldo(id));

		} catch (InputMismatchException e) {
			System.out.println("Dado incorreto, tente novamente...");
			sc.nextLine();

		} catch (IllegalArgumentException e) {
			System.out.println("Usuário não encontrado!");
		}
	}

	public static void depositar(Scanner sc, Banco banco) {
		try {
			System.out.println("Coloque: ID 'enter' VALOR 'enter'");
			int id = sc.nextInt();
			double valor = sc.nextDouble();

			banco.depositar(id, valor);

		} catch (InputMismatchException e) {
			System.out.println("Dados Incorretos, tente novamente...");
			sc.nextLine();
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals("ERRO_ID")) {
				System.out.println("Id não encontrado!");
			} else if (e.getMessage().equals("ERRO_VAL")) {
				System.out.println("Valor inválido!");
			} else if (e.getMessage().equals("ERRO_SALDO")) {
				System.out.println("Saldo insufíciente!");
			}
		}
	}

	public static void sacar(Scanner sc, Banco banco) {

		try {
			System.out.println("Coloque: ID 'enter' VALOR 'enter'");
			int id = sc.nextInt();
			double valor = sc.nextDouble();

			banco.sacar(id, valor);

		} catch (InputMismatchException e) {
			System.out.println("Dado Incorreto, tente novamente...");
			sc.nextLine();
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals("ERRO_ID")) {
				System.out.println("Id não encontrado!");
			} else if (e.getMessage().equals("ERRO_VAL_INSUF")) {
				System.out.println("Valor inválido!");
			} else {
				System.out.println("Conta inativa!");
			}
		}
	}

	public static void ativarConta(Scanner sc, Banco banco) {
		try {
			System.out.println("Coloque o id:");
			int id = sc.nextInt();

			banco.ativarConta(id);

		} catch (InputMismatchException e) {
			System.out.println("Dado Incorreto, tente novamente...");
			sc.nextLine();
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals("ERRO_ATIVA")) {
				System.out.println("Conta já está ativada!");
			} else {
				System.out.println("Id não encontrado!");
			}
		}
	}

	public static void cadastrarCliente(Scanner sc, Banco banco) {
		try {

			System.out.println("Nome 'enter' Idade 'enter' CPF 'enter'");
			sc.nextLine();
			String nome = sc.nextLine();
			int idade = sc.nextInt();
			String cpf = sc.next();

			banco.criarCliente(nome, idade, cpf);

		} catch (InputMismatchException e) {
			System.out.println("Dados Incorretos, tente novamente!");
			sc.nextLine();
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals("ERRO_NOME")) {
				System.out.println("Nome digitado inválido!");
			} else if (e.getMessage().equals("ERRO_IDADE")) {
				System.out.println("Idade inválida!");
			} else {
				System.out.println("Verifique se o CPF está correto!");
			}
		}

	}

	public static void transferir(Scanner sc, Banco banco) {
		try {
			System.out.println("Coloque: ID de origem | enter | ID destino | enter");
			System.out.println("Valor desejado: | enter |");

			int origem = sc.nextInt();
			int destino = sc.nextInt();
			Double valor = sc.nextDouble();

			banco.transferir(origem, destino, valor);

		} catch (InputMismatchException e) {
			System.out.println("Dado Incorreto, tente novamente...");
			sc.nextLine();
		} catch (IllegalArgumentException e) {

			switch (e.getMessage()) {
			case "ERRO_VAL":
				System.out.println("Valor inválido!");
				break;
			case "ERRO_VAL_INSUF":
				System.out.println("Valor insufíciente!");
				break;
			case "ERRO_ID":
				System.out.println("Id não encontrado!");
				break;
			case "ERRO_ID_IG":
				System.out.println("Id de origem e destino iguais!");
				break;
			case "ERRO_INATIVA":
				System.out.println("Uma conta ou ambas estao inativas!");
				break;
			}
		}
	}

	public static int lerScanner(Scanner sc) {
		while (true) {
			try {
				System.out.println("Selecione uma opção:");
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Entrada do tipo letra é inválido, selecione uma opção válida!");
				sc.nextLine();
			}
		}
	}

	public static void main(String[] args) {
		Banco banco = new Banco();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("");
			System.out.println("==== BANCO ====");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Ativar conta");
			System.out.println("3 - Depositar");
			System.out.println("4 - Sacar");
			System.out.println("5 - Transferir");
			System.out.println("6 - Consultar saldo");
			System.out.println("7 - Listar Clientes");
			System.out.println("0 - Sair");
			System.out.println("");

			switch (lerScanner(sc)) {

			case 1:
				cadastrarCliente(sc, banco);
				break;
			case 2:
				ativarConta(sc, banco);
				break;
			case 3:
				depositar(sc, banco);
				break;
			case 4:
				sacar(sc, banco);
				break;
			case 5:
				transferir(sc, banco);
				break;
			case 6:
				consultarSaldo(sc, banco);
				break;
			case 7:
				System.out.println(banco.getClientes());
				break;
			case 0:
				System.out.println("Sessão finalizada!");
				return;
			default:
				System.out.println("Selecione uma opção válida!");
			}

		}
	}
}
