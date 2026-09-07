package com.luan.projeto;

import java.util.HashMap;
import java.util.Map;

public class Banco {
	Map<Integer, Cliente> listaClientes = new HashMap<>();

	public void criarCliente(String nome, int idade, String cpf) {
		listaClientes.put(Cliente.quantity, new Cliente(nome, idade, cpf));
	}

	public void getClientes() {
		System.out.println("Clientes: "+listaClientes.values());
	}

	public Cliente getCliente(int id) {
		return listaClientes.get(id);
	}

	public void remover(int id) {
		listaClientes.remove(id);
	}

	public void transferir(Cliente remetente, Cliente destinatario, double valor) throws ClienteInexistenteException {
		if (remetente == null || destinatario == null) {
			throw new ClienteInexistenteException("Cliente inválido!");
		}
		if (valor > 0) {
			remetente.sacar(valor);
			destinatario.depositar(valor);
		}
	}

}
