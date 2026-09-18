package com.luan.projeto;

import java.util.HashMap;
import java.util.Map;

public class Banco {
	Map<Integer, Cliente> listaClientes = new HashMap<>();

	public void criarCliente(String nome, int idade, String cpf) {
		listaClientes.put(Cliente.quantity, new Cliente(nome, idade, cpf));
	}

	public void getClientes() {
		System.out.println(listaClientes.values());
	}

	public Cliente getCliente(int id) {
		return listaClientes.get(id);
	}

	public void remover(int id) {
		listaClientes.remove(id);
	}

	public void transferir(int idRemetente, int idDestinatario, double valor) {
		if(listaClientes.get(idRemetente) == null || listaClientes.get(idDestinatario) == null || valor <= 0) {
			System.out.println("Dados inválidos!");
		}
		listaClientes.get(idRemetente).sacar(valor);
		listaClientes.get(idDestinatario).depositar(valor);
		
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
	
	public Map<String, Object> getSaldo(int id) {
		double saldo = listaClientes.get(id).getSaldo();
		
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("origem", saldo);
		mapa.put("saldoString", "R$ "+saldo);
		return mapa;
		
	}

}
