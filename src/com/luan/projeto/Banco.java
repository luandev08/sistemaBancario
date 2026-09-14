package com.luan.projeto;

import java.util.HashMap;
import java.util.Map;

public class Banco {
	Map<Integer, Cliente> listaClientes = new HashMap<>();

	public void criarCliente(String nome, int idade, String cpf) {
		listaClientes.put(Cliente.quantity, new Cliente(nome, idade, cpf));
	}

	public void getClientes() {
		System.out.println("Clientes: " + listaClientes.values());
	}

	public Cliente getCliente(int id) {
		return listaClientes.get(id);
	}

	public void remover(int id) {
		listaClientes.remove(id);
	}

	public void transferir(int idRemetente, int idDestinatario, double valor) {
		if (idRemetente <= 0 || idDestinatario <= 0) {
			throw new IllegalArgumentException("Id inválido!");
		} else {
			throw new IllegalArgumentException("Preencha um id!");
		}

		if (valor > 0) {
			listaClientes.get(idRemetente).sacar(valor);
			listaClientes.get(idDestinatario).depositar(valor);
		} else {
			System.out.println("Valor informado inválido, tente novamente!");
		}
	}

	public void ativarConta(int id) {
		if (id > 0) {
			Cliente cliente = listaClientes.get(id);
			cliente.ativarConta();
			System.out.println(listaClientes.get(id).toString());
		} else {
			throw new IllegalArgumentException("ID informado inválido!");
		}
	}

	public void depositar(int id, double valor) {
		listaClientes.get(id).depositar(valor);
	}

	public void sacar(int id, double valor) {
		listaClientes.get(id).sacar(valor);
	}

}
