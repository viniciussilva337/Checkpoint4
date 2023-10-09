import java.util.ArrayList;
import java.util.List;

class ArvoreBinaria {
    private Cliente raiz;

    // Outros métodos da classe ArvoreBinaria

    // Método para inserir um cliente na árvore
    public void inserir(Cliente novoCliente) {
        raiz = inserirRec(raiz, novoCliente);
    }

    private Cliente inserirRec(Cliente raizAtual, Cliente novoCliente) {
        if (raizAtual == null) {
            return novoCliente;
        }

        // Compare o saldo do novoCliente com o saldo do cliente na raizAtual
        if (novoCliente.getSaldoAplicacoes() < raizAtual.getSaldoAplicacoes()) {
            raizAtual.setEsquerda(inserirRec(raizAtual.getEsquerda(), novoCliente));
        } else if (novoCliente.getSaldoAplicacoes() > raizAtual.getSaldoAplicacoes()) {
            raizAtual.setDireita(inserirRec(raizAtual.getDireita(), novoCliente));
        }

        return raizAtual;
    }

    public List<Cliente> obterClientesAptosRec(double saldoMinimo) {
        List<Cliente> clientesAptos = new ArrayList<>();
        obterClientesAptosRec(raiz, saldoMinimo, clientesAptos);
        return clientesAptos;
    }

    private void obterClientesAptosRec(Cliente raizAtual, double saldoMinimo, List<Cliente> clientesAptos) {
        if (raizAtual == null) {
            return;
        }

        if (raizAtual.getSaldoAplicacoes() >= saldoMinimo) {
            clientesAptos.add(raizAtual);
        }

        obterClientesAptosRec(raizAtual.getEsquerda(), saldoMinimo, clientesAptos);
        obterClientesAptosRec(raizAtual.getDireita(), saldoMinimo, clientesAptos);
    }

    public List<Cliente> obterClientesAptosRec(double saldoMinimo) {
        List<Cliente> clientesAptos = new ArrayList<>();
        obterClientesAptosRec(raiz, saldoMinimo, clientesAptos);
        return clientesAptos;
    }

    private void obterClientesAptosRec(Cliente raizAtual, double saldoMinimo, List<Cliente> clientesAptos) {
        if (raizAtual == null) {
            return;
        }

        if (raizAtual.getSaldoAplicacoes() >= saldoMinimo) {
            clientesAptos.add(raizAtual);
        }

        obterClientesAptosRec(raizAtual.getEsquerda(), saldoMinimo, clientesAptos);
        obterClientesAptosRec(raizAtual.getDireita(), saldoMinimo, clientesAptos);
    }
}
