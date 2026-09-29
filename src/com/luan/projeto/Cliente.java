package com.luan.projeto;

public class Cliente {

	private String nome;
	private int idade;
	private String cpf;
	
	private Conta conta = new Conta();

	static int quantity = 1;

	public Cliente(String nome, int idade, String cpf) {

		this.nome = nome.toUpperCase();
		this.idade = idade;
		this.cpf = cpf;
		quantity++;
	}
	
	public boolean contaAtiva() {
		return conta.contaAtiva();
	}

	public String toString() {
		return nome;
	}

	public void ativarConta() {
		conta.ativarConta();
	}

	public void depositar(double valor) {
		conta.depositar(valor);
	}

	public void sacar(double valor) {
		conta.sacar(valor);
	}

	public double getSaldo() {
		return conta.getSaldo();
	}

}
