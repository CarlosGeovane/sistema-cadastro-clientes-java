package service;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    public void buscarClientes(String nome) {
        boolean encontrado = false;

        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Cliente encontrado:");
                System.out.println(c);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void removerClientes(String nome) {
        Cliente clienteRemover = null;

        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                clienteRemover = c;
                break;
            }
        }

        if (clienteRemover != null) {
            clientes.remove(clienteRemover);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
