package com.luan.projeto;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Scanner sc = new Scanner(System.in);

		int sair = 0;

		while (sair == 0) {
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
			sair++;

			int opcao = sc.nextInt();

			boolean dadoValido = false;

			switch (opcao) {

			case 1:
				while (!dadoValido) {
					try {

						System.out.println("Nome enter Idade enter CPF enter");
						String nome = sc.next();

						if (nome == null || nome.trim().isBlank()) {
							throw new IllegalArgumentException("ERRO_NOME");
						}

						int idade = sc.nextInt();

						if (idade <= 17) {
							throw new IllegalArgumentException("ERRO_IDADE");
						}

						String cpf = sc.next();

						String cpfLimpo = cpf.replaceAll("[^0-9]", "");
						int quantidadeNumerosCpf = cpfLimpo.length();

						if (quantidadeNumerosCpf == 11) {
							cpf = cpfLimpo;
						} else {
							throw new IllegalArgumentException("ERRO_CPF");
						}

						banco.criarCliente(nome, idade, cpf);

						dadoValido = true;
						sair--;

					} catch (InputMismatchException e) {
						System.out.println("Dados Incorretos, tente novamente!");
						sc.nextLine();
					} catch (IllegalArgumentException e) {
						if(e.getMessage().equals("ERRO_NOME")) {
							System.out.println("Nome digitado inválido!");
						}else if(e.getMessage().equals("ERRO_IDADE")) {
							System.out.println("Idade inválida!");
						}else {
							System.out.println("Verifique se o CPF está correto!");
						}
					}
				}
				break;
			case 2:
				dadoValido = false;
				while (!dadoValido) {
					try {
						int id = sc.nextInt();

						if (banco.getCliente(id) != null) {
							System.out.println("Coloque o id:");
							banco.ativarConta(id);

							dadoValido = true;
						} else {
							throw new IllegalArgumentException("O CPF deve possuir 11 números!");
						}

					} catch (InputMismatchException e) {
						System.out.println("Dado Incorreto, tente novamente...");
						sc.nextLine();
					} catch (IllegalArgumentException e) {
						System.out.println("Dados incorretos, tente novamente!");
					}
				}
				sair--;
				break;
			case 3:
				dadoValido = false;
				while (!dadoValido) {
					try {
						System.out.println("Coloque: ID enter VALOR enter");
						banco.depositar(sc.nextInt(), sc.nextDouble());

						dadoValido = true;

					} catch (InputMismatchException e) {
						System.out.println("Dado Incorreto, tente novamente...");
						sc.nextLine();
					}
				}

				sair--;
				break;
			case 4:
				dadoValido = false;
				while (!dadoValido) {
					try {
						System.out.println("Coloque: ID enter VALOR enter");
						banco.sacar(sc.nextInt(), sc.nextDouble());

						dadoValido = true;

					} catch (InputMismatchException e) {
						System.out.println("Dado Incorreto, tente novamente...");
						sc.nextLine();
					}
				}

				sair--;
				break;
			case 5:
				dadoValido = false;
				while (!dadoValido) {
					try {
						System.out.println("Coloque o ID de que envia e depois de que vai receber.");
						System.out.println("Em seguida o valor de envio.");
						banco.transferir(sc.nextInt(), sc.nextInt(), sc.nextDouble());

						dadoValido = true;

					} catch (InputMismatchException e) {
						System.out.println("Dado Incorreto, tente novamente...");
						sc.nextLine();
					}
				}

				sair--;
				break;
			case 6:
				dadoValido = false;
				while (!dadoValido) {
					try {
						System.out.println("Digite o id do usuário desejado:");
						Map<String, Object> dados = banco.getSaldo(sc.nextInt());
						System.out.println(dados.get("saldoString"));

						dadoValido = true;

					} catch (InputMismatchException e) {
						System.out.println("Dado Incorreto, tente novamente...");
						sc.nextLine();
					}
				}

				sair--;
			case 7:
				dadoValido = false;
				while (!dadoValido) {
					try {
						banco.getClientes();

						dadoValido = true;

					} catch (InputMismatchException e) {
						System.out.println("Dado Incorreto, tente novamente...");
						sc.nextLine();
					}
				}

				sair--;
				break;
			case 0:
				dadoValido = false;
				while (!dadoValido) {
					try {
						System.out.println("Sessão finalizada!");

						dadoValido = true;

					} catch (InputMismatchException e) {
						System.out.println("Dado Incorreto, tente novamente...");
						sc.nextLine();
					}
				}
				break;
			default:
				System.out.println("Selecione uma opção válida!");
				sair--;
			}
		}
		sc.close();
	}

}
