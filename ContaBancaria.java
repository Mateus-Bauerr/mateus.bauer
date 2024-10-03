import java.util.ArrayList;

public class ContaBancaria {
    private double saldo;
    private double limite;
    private ArrayList<String> transacoes;


    public ContaBancaria(double saldoInicial, double limiteInicial) {
        this.saldo = saldoInicial;
        this.limite = limiteInicial;
        this.transacoes = new ArrayList<>();
    }

    // Saldo
    public double getSaldo() {
        return saldo;
    }

    //Define o limite
    public void setLimite(double limite) {
        this.limite = limite;
    }

    // Verifica limite
    public double getLimite() {
        return limite;
    }

    //Depósito
    public void depositar(double valor) {
        if (valor > 0) { 
            saldo += valor;
            transacoes.add("Depósito de R$ " + valor); // Adiciona ao histórico
        } else {
            System.out.println("O valor precisa ser positivo!");
        }
    }

    // Saque com validação simples
    public boolean sacar(double valor) {
        if (valor > 0 && (saldo + limite) >= valor) { // Verifica saldo/limite
            saldo -= valor;
            transacoes.add("Saque de R$ " + valor); // Registra a transação
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }

    // Histórico de transações
    public void mostrarHistorico() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            System.out.println("Histórico de transações:");
            for (String transacao : transacoes) {
                System.out.println(transacao);
            }
        }
    }
}
