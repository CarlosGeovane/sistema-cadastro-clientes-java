import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();

        while (true) {
            System.out.println("\n=== Sistema de Cadastro de Clientes ===");
            System.out.println("1. cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por nome");
            System.out.println("4. Remover cliente");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");
            String opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Nome: ");
                    String nome = ler.nextLine();
                    System.out.println("Email: ");
                    String email = ler.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = ler.nextLine();
                    Cliente novoCliente = new Cliente(nome, email, telefone);
                    clienteService.adicionarCliente(novoCliente);
                    break;
                case "2":
                    clienteService.listarClientes();
                    break;
                case "3":
                    System.out.println("Digite o nome do cliente: ");
                    String nomeBusca = ler.nextLine();
                    clienteService.buscarClientes(nomeBusca);
                    break;
                case "4":
                    System.out.println("Digite o nome do cliente a ser removido: ");
                    String nomeRemover = ler.nextLine();
                    clienteService.removerClientes(nomeRemover);
                    break;
                case "5":
                    System.out.println("Encerrando o programa...");
                    ler.close();
                    return;
                default:
                    System.out.println("Opção Inválida.");
            }
        }
    }
}
