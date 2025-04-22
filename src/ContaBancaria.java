// ContaBancaria.java
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private int numeroConta;
    private String titular;
    private double saldo;
    private List<String> historicoTransacoes;

    public ContaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        setTitular(titular);
        this.saldo = 0.0;
        this.historicoTransacoes = new ArrayList<>();
        registrarTransacao("Conta criada para " + titular);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String novoTitular) {
        if (novoTitular != null && !novoTitular.isEmpty()) {
            this.titular = novoTitular;
        } else {
            System.out.println("Titular inválido.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            registrarTransacao("Depósito de R$ " + valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Erro: valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            registrarTransacao("Saque de R$ " + valor);
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Erro: saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    private void registrarTransacao(String transacao) {
        historicoTransacoes.add(transacao);
    }

    public void exibirResumo() {
        System.out.printf("Conta: %03d | Titular: %s | Saldo: R$ %.2f\n", numeroConta, titular, saldo);
        System.out.println("Histórico de Transações:");
        for (String transacao : historicoTransacoes) {
            System.out.println("- " + transacao);
        }
    }
}