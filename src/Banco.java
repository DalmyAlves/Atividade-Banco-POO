import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contas;
    private int proximoNumeroConta = 1;

    public Banco() {
        contas = new ArrayList<>();
    }

    public ContaBancaria adicionarConta(String titular) {
        ContaBancaria nova = new ContaBancaria(proximoNumeroConta, titular);
        contas.add(nova);
        proximoNumeroConta++;
        return nova;
    }

    public ContaBancaria buscarConta(int numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (ContaBancaria conta : contas) {
                conta.exibirResumo();
            }
        }
    }
}