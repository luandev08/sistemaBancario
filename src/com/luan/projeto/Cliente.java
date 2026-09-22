package com.luan.projeto;

import java.util.function.Function;

public class Cliente {

	private String nome;
	private int idade;
	private String cpf;
	private double saldo;

	static int quantity = 1;

	private boolean contaAtiva = false;

	public Cliente(String nome, int idade, String cpf) {
		
		Function<String, String> caixaAlta = texto -> texto.toUpperCase();
		
		this.nome = caixaAlta.apply(nome);
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
