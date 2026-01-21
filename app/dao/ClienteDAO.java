package app.dao;

import app.factory.ConnectionFactory;
import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar: " + e.getMessage());
        }
    }

    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente(rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar: " + e.getMessage());
        }
        return clientes;
    }

    public List<Cliente> buscarPorNome(String nome) {
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    clientes.add(new Cliente(rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar: " + e.getMessage());
        }
        return clientes;
    }

    public boolean removerPorNome(String nome) {
        String sql = "DELETE FROM clientes WHERE nome = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover: " + e.getMessage());
        }
    }
}