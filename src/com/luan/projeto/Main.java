package com.luan.projeto;

public class Main {

	public static void main(String[] args) {
		Banco conta = new Banco();
		
		try {
			conta.criarCliente("Luan", 20, "50139076831");
			Cliente luan = conta.getCliente(1);
x
			
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} finally {
			System.out.println("Processo finalizado!");
		}
	}
}
