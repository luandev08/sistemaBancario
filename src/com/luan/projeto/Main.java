package com.luan.projeto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Scanner sc = new Scanner(System.in);

		int sair = 0;
		
		while(sair == 0) {
			System.out.println("==== BANCO ====");
			System.out.println("1 - Criar cliente");
			System.out.println("2 - Ativar conta");
			System.out.println("3 - Depositar");
			System.out.println("4 - Sacar");
			System.out.println("5 - Transferir");
			System.out.println("6 - Consultar saldo");
			System.out.println("7 - Listar Clientes");
			System.out.println("0 - Sair");
			sair++;
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
			
			case 1:
				System.out.println("Nome: || Idade || CPF");
				banco.criarCliente(sc.next(), sc.nextInt(), sc.next());
				sair--;
				break;
			case 2:
				System.out.println("Coloque o id:");
				banco.ativarConta(sc.nextInt());
				sair--;
				break;
			case 3:
				System.out.println("Coloque: ID || VALOR");
				banco.depositar(sc.nextInt(),sc.nextDouble());
				sair--;
				break;
			case 4:
				System.out.println("Coloque: ID || VALOR");
				banco.sacar(sc.nextInt(), sc.nextDouble());
				sair--;
				break;
			case 5:
				System.out.println("Coloque o ID de que envia e depois de que vai receber.");
				System.out.println("Em seguida o valor de envio.");
				banco.transferir(sc.nextInt(), sc.nextInt(), sc.nextDouble());
				sair--;
				break;
			case 7:
				banco.getClientes();
				sair--;
				break;
				
			}
		}
		sc.close();
	}
	
}
