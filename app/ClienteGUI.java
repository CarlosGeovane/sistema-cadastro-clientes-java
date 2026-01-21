package app;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import model.Cliente;
import service.ClienteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ClienteGUI extends JFrame {
    private ClienteService service = new ClienteService();
    private DefaultTableModel tableModel;
    private JTable tabela;

    private JTextField txtNome = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtTelefone = new JTextField();

    public ClienteGUI() {
        // 1. Configuração do Visual Moderno (FlatLaf)
        try {
            FlatMacDarkLaf.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Configurações da Janela
        setTitle("Sistema de Gestão de Clientes - MacBook M3");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        // 3. Painel de Cadastro (GridBagLayout para não bugar no Mac)
        JPanel painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; painelCadastro.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; painelCadastro.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 1; painelCadastro.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; painelCadastro.add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 2; painelCadastro.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1; painelCadastro.add(txtTelefone, gbc);

        JButton btnSalvar = new JButton("Salvar no Banco");
        gbc.gridx = 1; gbc.gridy = 3; painelCadastro.add(btnSalvar, gbc);

        add(painelCadastro, BorderLayout.NORTH);

        // 4. Tabela
        String[] colunas = {"Nome", "Email", "Telefone"};
        tableModel = new DefaultTableModel(colunas, 0);
        tabela = new JTable(tableModel);
        tabela.setRowHeight(25);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // 5. Botão Atualizar
        JButton btnAtualizar = new JButton("🔄 Atualizar Lista");
        JPanel painelSul = new JPanel();
        painelSul.add(btnAtualizar);
        add(painelSul, BorderLayout.SOUTH);

        // Ações
        btnSalvar.addActionListener(e -> {
            Cliente c = new Cliente(txtNome.getText(), txtEmail.getText(), txtTelefone.getText());
            service.adicionarCliente(c);
            atualizarTabela();
            limparCampos();
        });

        btnAtualizar.addActionListener(e -> atualizarTabela());

        atualizarTabela();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Cliente> lista = service.listarClientesParaTabela();
        for (Cliente c : lista) {
            tableModel.addRow(new Object[]{c.getNome(), c.getEmail(), c.getTelefone()});
        }
    }

    private void limparCampos() {
        txtNome.setText(""); txtEmail.setText(""); txtTelefone.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClienteGUI::new);
    }
}