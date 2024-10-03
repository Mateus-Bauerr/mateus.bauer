import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Cria uma conta com saldo inicial e limite
        ContaBancaria conta = new ContaBancaria(500, 100);
        FazPix fazoPix = new FazPix();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Enviar Pix");
            System.out.println("4 - Adicionar Chave Pix");
            System.out.println("5 - Listar Chaves Pix");
            System.out.println("6 - Remover Chave Pix");
            System.out.println("7 - Ver Saldo");
            System.out.println("8 - Ver Histórico de Transações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            // Verifica qual opção foi escolhida
            switch (opcao) {
                case 1: // Depósito
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2: // Saque
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3: // Enviar Pix
                    System.out.print("Digite o valor do Pix: ");
                    double valorPix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Digite a chave Pix: ");
                    String chavePix = scanner.nextLine();
                    if (fazoPix.chaveExiste(chavePix)) {
                        if (conta.sacar(valorPix)) {
                            System.out.println("Pix enviado para " + chavePix);
                        }
                    } else {
                        System.out.println("Chave Pix não encontrada.");
                    }
                    break;
                case 4: // Adicionar chave Pix
                    System.out.print("Digite a chave Pix: ");
                    String novaChavePix = scanner.nextLine();
                    System.out.print("Digite o nome do contato da chave: ");
                    String contatoPix = scanner.nextLine();
                    fazoPix.adicionarChavePix(novaChavePix, contatoPix);
                    break;
                case 5: // Listar chaves Pix
                    fazoPix.listarChavesPix();
                    break;
                case 6: // Remover Chave Pix
                    System.out.print("Digite a chave Pix que deseja remover: ");
                    String chaveRemover = scanner.nextLine();
                    if (fazoPix.chaveExiste(chaveRemover)) {
                        System.out.print("Tem certeza que deseja remover a chave " + chaveRemover + "? (s/n): ");
                        String confirmacao = scanner.nextLine();
                        if (confirmacao.equalsIgnoreCase("s")) {
                            fazoPix.removerChavePix(chaveRemover);
                        } else {
                            System.out.println("Remoção cancelada.");
                        }
                    } else {
                        System.out.println("Chave Pix não encontrada.");
                    }
                    break;
                case 7: // Mostrar saldo
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    break;
                case 8: // Mostrar Histórico
                    conta.mostrarHistorico();
                    break;
                case 0:
                    System.out.println("Saindo, bom dia :D");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
