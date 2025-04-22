import java.util.Scanner;

public class AplicacaoBanco {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Banco banco = new Banco();
        int opcaoMenuPrincipal, numeroConta;

        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Informações da Conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Listar Contas");
            System.out.println("6 - Sair");
            System.out.println("==========================");
            System.out.print("Escolha uma opção: ");
            opcaoMenuPrincipal = entrada.nextInt();
            entrada.nextLine();

            switch (opcaoMenuPrincipal) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String titular = entrada.nextLine();

                    ContaBancaria novaConta = banco.adicionarConta(titular);
                    System.out.println("Conta criada com sucesso! Número: " + novaConta.getNumeroConta());

                    System.out.print("Deseja fazer um depósito inicial? (s/n): ");
                    String resposta = entrada.nextLine();
                    if (resposta.equalsIgnoreCase("s")) {
                        System.out.print("Valor do depósito: ");
                        double valor = entrada.nextDouble();
                        entrada.nextLine();
                        novaConta.depositar(valor);
                    }
                    break;

                case 2:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = entrada.nextInt();
                    entrada.nextLine();

                    ContaBancaria contaInfo = banco.buscarConta(numeroConta);
                    if (contaInfo != null) {
                        contaInfo.exibirResumo();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta para depósito: ");
                    numeroConta = entrada.nextInt();
                    entrada.nextLine();
                    ContaBancaria contaDeposito = banco.buscarConta(numeroConta);
                    if (contaDeposito != null) {
                        System.out.print("Valor para depositar: ");
                        double valor = entrada.nextDouble();
                        entrada.nextLine();
                        contaDeposito.depositar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta para saque: ");
                    numeroConta = entrada.nextInt();
                    entrada.nextLine();
                    ContaBancaria contaSaque = banco.buscarConta(numeroConta);
                    if (contaSaque != null) {
                        System.out.print("Valor para sacar: ");
                        double valor = entrada.nextDouble();
                        entrada.nextLine();
                        contaSaque.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    banco.listarContas();
                    break;

                case 6:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcaoMenuPrincipal != 6);

        entrada.close();
    }
}