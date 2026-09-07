package com.luan.projeto;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco();
		
		try {
			banco.criarCliente("Luan", 20, "50139076831");
			banco.criarCliente("Lívia", 20, "56542132655");
			
			Cliente cliente1 = banco.getCliente(1);
			Cliente cliente2 = banco.getCliente(2);
			
			cliente1.ativarConta();
			cliente2.ativarConta();
			
			//banco.remover(2);
			banco.getClientes();
			
			
			System.out.println(cliente1.getSaldo());
			System.out.println(cliente2.getSaldo());
			
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} finally {
			System.out.println("Processo finalizado!");
		}
	}
}
