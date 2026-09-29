package com.luan.projeto;

public class Conta {

	private double saldo;
	private boolean ativa;

	public void ativarConta() {

		if (!ativa) {
			ativa = true;
			saldo = 0;
		} else {
			throw new IllegalArgumentException("ERRO_ATIVA");
		}

	}
	
	public boolean contaAtiva() {
		if (ativa) {
			return true;
		}else {
			return false;
		} 
	}

	public void depositar(double valor) {
		if (!ativa) {
			throw new IllegalArgumentException("ERRO_INATIVA");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("ERRO_VAL");
		} else {
			saldo += valor;
		}
	}

	public void sacar(double valor) {
		if (!ativa) {
			throw new IllegalArgumentException("ERRO_INATIVA");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("ERRO_VAL");
		} else {
			saldo -= valor;
		}
	}

	public double getSaldo() {
		if(!ativa) {
			throw new IllegalArgumentException("ERRO_INATIVA");
		}else {
			return saldo;
		}

	}
}
