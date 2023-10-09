class Cliente {
    private String nome;
    private String cpfCnpj;
    private String numeroConta;
    private String tipoConta;
    private double saldoAplicacoes;
    private Cliente proximo; // Para vincular clientes na ABB

    // Construtor
    public Cliente(String nome, String cpfCnpj, String numeroConta, String tipoConta, double saldoAplicacoes) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldoAplicacoes = saldoAplicacoes;
        this.proximo = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldoAplicacoes() {
        return saldoAplicacoes;
    }

    public void setSaldoAplicacoes(double saldoAplicacoes) {
        this.saldoAplicacoes = saldoAplicacoes;
    }

    public Cliente getProximo() {
        return proximo;
    }

    public void setProximo(Cliente proximo) {
        this.proximo = proximo;
    }

    // Outros métodos, se necessário
}
