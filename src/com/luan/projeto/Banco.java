package com.luan.projeto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Banco {
	private final Map<Integer, Cliente> listaClientes = new HashMap<>();

	public void criarCliente(String nome, int idade, String cpf) {

		if (nome == null || nome.trim().isBlank())
			throw new IllegalArgumentException("ERRO_NOME");

		if (idade <= 17)
			throw new IllegalArgumentException("ERRO_IDADE");

		String cpfLimpo = cpf.replaceAll("[^0-9]", "");

		int quantidadeNumerosCpf = cpfLimpo.length();

		if (quantidadeNumerosCpf == 11) {
			cpf = cpfLimpo;
		} else {
			throw new IllegalArgumentException("ERRO_CPF");
		}

		listaClientes.put(Cliente.quantity, new Cliente(nome, idade, cpf));
	}

	public Collection<Cliente> getClientes(){
		return listaClientes.values();
	}

	public Cliente getCliente(int id) {
		return listaClientes.get(id);
	}

	public void remover(int id) {
		listaClientes.remove(id);
	}

	public void transferir(int id1, int id2, double valor) {
		
		Cliente origem = listaClientes.get(id1);
		Cliente destino = listaClientes.get(id2);
		
		if(origem.contaAtiva() == false || destino.contaAtiva() == false) {
			throw new IllegalArgumentException("ERRO_INATIVA");
		}else if (origem == null || destino == null) {
			throw new IllegalArgumentException("ERRO_ID");
		} else if (origem.getSaldo() < valor) {
			throw new IllegalArgumentException("ERRO_VAL_INSUF");
		} else if (origem == destino) {
			throw new IllegalArgumentException("ERRO_ID_IG");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("ERRO_VAL");
		}
		
		origem.sacar(valor);
		destino.depositar(valor);
	}

	public void ativarConta(int id) {

		Cliente cliente = listaClientes.get(id);

		if (cliente != null) {
			cliente.ativarConta();
		} else {
			throw new IllegalArgumentException("ERRO_ID");
		}

	}

	public void depositar(int id, double valor) {

		Cliente cliente = listaClientes.get(id);

		if (cliente == null) {
			throw new IllegalArgumentException("ERRO_ID");
		} else if (valor <= 0) {
			throw new IllegalArgumentException("ERRO_VALOR");
		}

		cliente.depositar(valor);
	}

	public void sacar(int id, double valor) {

		Cliente cliente = listaClientes.get(id);

		if (cliente == null) {
			throw new IllegalArgumentException("ERRO_ID");
		} else if (cliente.getSaldo() < valor || valor <= 0) {
			throw new IllegalArgumentException("ERRO_SALDO");
		} else {
			cliente.sacar(valor);
		}
	}

	public double getSaldo(int id) {
		if (listaClientes.get(id) == null) {
			throw new IllegalArgumentException("ERRO_ID");
		}

		return listaClientes.get(id).getSaldo();
	}
}
