import java.util.List;
import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria abbPessoaFisica = new ArvoreBinaria();
        ArvoreBinaria abbPessoaJuridica = new ArvoreBinaria();

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Inscrição de cliente");
            System.out.println("2. Oferta de novo serviço e/ou aplicação");
            System.out.println("3. Menu de consulta");
            System.out.println("4. Encerrar o programa");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Inscrição de cliente");
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("CPF/CNPJ: ");
                    String cpfCnpj = scanner.next();
                    System.out.print("Número da Conta: ");
                    String numeroConta = scanner.next();
                    System.out.print("Tipo de Conta (Física ou Jurídica): ");
                    String tipoConta = scanner.next();
                    System.out.print("Saldo em Aplicações: ");
                    double saldoAplicacoes = scanner.nextDouble();

                    Cliente novoCliente = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldoAplicacoes);

                    if ("Física".equalsIgnoreCase(tipoConta)) {
                        abbPessoaFisica.inserir(novoCliente);
                    } else if ("Jurídica".equalsIgnoreCase(tipoConta)) {
                        abbPessoaJuridica.inserir(novoCliente);
                    } else {
                        System.out.println("Tipo de conta inválido.");
                    }
                    break;
                case 2:
                    System.out.println("Oferta de novo serviço e/ou aplicação");
                    System.out.print("Saldo mínimo necessário para a oferta: ");
                    double saldoMinimo = scanner.nextDouble();
                    System.out.print("Tipo de Cliente (Física ou Jurídica): ");
                    String tipoCliente = scanner.next();

                    ArvoreBinaria abbTipoCliente = null;
                    if ("Física".equalsIgnoreCase(tipoCliente)) {
                        abbTipoCliente = abbPessoaFisica;
                    } else if ("Jurídica".equalsIgnoreCase(tipoCliente)) {
                        abbTipoCliente = abbPessoaJuridica;
                    } else {
                        System.out.println("Tipo de cliente inválido.");
                        break;
                    }

                    List<Cliente> clientesAptos = abbTipoCliente.obterClientesAptos(saldoMinimo);

                    if (clientesAptos.isEmpty()) {
                        System.out.println("Nenhum cliente apto encontrado.");
                    } else {
                        // Percorra a lista de clientes aptos em ordem decrescente de saldo e ofereça o serviço
                        for (Cliente cliente : clientesAptos) {
                            System.out.println("Oferecendo serviço para: " + cliente.getNome());
                            System.out.print("Aceitar a oferta? (S/N): ");
                            String resposta = scanner.next();

                            if ("S".equalsIgnoreCase(resposta)) {
                                System.out.println("Oferta aceita por " + cliente.getNome());
                                abbTipoCliente.remover(cliente);
                            } else {
                                System.out.println("Oferta recusada por " + cliente.getNome());
                            }
                        }
                    }
                    break;
                case 3:
                    // Implemente o menu de consulta
                    break;
                case 4:
                    // Implemente a opção de encerrar o programa
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
