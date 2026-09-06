package com.luan.projeto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Banco {
	Map<Integer, Cliente> listaClientes = new HashMap<>();

	public void getClientes(Collection<Cliente> nomes) {
		System.out.println("Clientes: "+nomes);
	}
	
	public void transferir(Cliente remetente, Cliente destinatario, double valor) throws ClienteInexistenteException {
		if(remetente == null || destinatario == null) {
			throw new ClienteInexistenteException("Cliente inválido!");
		}
		remetente.transferir(valor);
		destinatario.depositar(valor);
	}
	
	public void criarCliente(String nome, int idade, String cpf) {
		listaClientes.put(Cliente.quantity, new Cliente(nome, idade, cpf));
	}
	
	public Cliente getCliente(int id) {
		return listaClientes.get(id);
	} 

}
