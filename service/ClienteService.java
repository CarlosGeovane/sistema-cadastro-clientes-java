package service;

import app.dao.ClienteDAO; // Importamos o DAO que você criou
import model.Cliente;
import java.util.List;

public class ClienteService {

    // Em vez de ArrayList, agora usamos o DAO
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void adicionarCliente(Cliente cliente) {
        // Validação de Nome
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            System.out.println("❌ Erro: O nome do cliente não pode estar vazio!");
            return;
        }

        // Validação básica de E-mail
        if (!cliente.getEmail().contains("@")) {
            System.out.println("❌ Erro: E-mail inválido! Deve conter '@'.");
            return;
        }

        try {
            clienteDAO.salvar(cliente);
            System.out.println("✅ Cliente cadastrado com sucesso no banco de dados!");
        } catch (RuntimeException e) {
            System.out.println("❌ Falha técnica: " + e.getMessage());
        }
    }

    public void listarClientes() {
        // O DAO buscará a lista direto do MySQL
        List<Cliente> clientes = clienteDAO.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no banco.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    public void buscarClientes(String nome) {
        // O DAO faz o filtro usando SQL (WHERE nome = ...)
        List<Cliente> encontrados = clienteDAO.buscarPorNome(nome);

        if (encontrados.isEmpty()) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println("Cliente(s) encontrado(s):");
            encontrados.forEach(System.out::println);
        }
    }

    public void removerClientes(String nome) {
        // O DAO executa o DELETE no banco
        boolean removido = clienteDAO.removerPorNome(nome);

        if (removido) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado para remoção.");
        }
    }
    // No ClienteService.java
    public List<Cliente> listarClientesParaTabela() {
        return clienteDAO.listarTodos();
    }
}