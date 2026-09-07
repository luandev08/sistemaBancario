package com.luan.projeto;

public class Cliente {

	private String nome;
	private int idade;
	private String cpf;
	private double saldo;

	static int quantity = 1;

	private boolean contaAtiva = false;

	public Cliente(String nome, int idade, String cpf) {
		if (nome == null || nome.trim().isBlank()) {
			throw new IllegalArgumentException("Nome informado é inválido!");
		}

		if (idade <= 17) {
			throw new IllegalArgumentException("Menor de idade não pode fazer o cadastro!");
		}

		String cpfNumeros = cpf.replaceAll("[^0-9]", "");
		int quantidadeNumerosCpf = cpfNumeros.length();

		if (quantidadeNumerosCpf == 11) {
			this.cpf = cpfNumeros;
		} else {
			throw new IllegalArgumentException("O CPF deve possuir 11 números!");
		}
		this.nome = nome;
		this.idade = idade;
		quantity++;
	}

	public String toString() {
		return nome;
	}

	public void ativarConta() {
		contaAtiva = true;
		saldo = 0;
	}

	public void depositar(double valor) {
		if (contaAtiva) {
			if (valor <= 0) {
				throw new IllegalArgumentException("Valor Inválido!");
			} else {
				saldo += valor;
			}
		} else {
			throw new IllegalArgumentException("Sua conta não esta ativa!");
		}
	}

	public void sacar(double valor) {
		if (contaAtiva) {
			if (valor > saldo) {
				throw new IllegalArgumentException("Saldo insuficiente!");
			} else if (valor <= 0) {
				throw new IllegalArgumentException("Valor inválido!");
			} else {
				saldo -= valor;
			}
		} else {
			throw new IllegalArgumentException("Sua conta não esta ativa!");
		}
	}

	public double getSaldo() {
		if (!contaAtiva) {
			throw new IllegalArgumentException("Sua conta não esta ativa!");
		}
		return saldo;
	}

}
