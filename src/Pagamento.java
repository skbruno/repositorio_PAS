public class Pagamento {
    private char tipo_pagamento;
    private double valor;
    private Status_Pagamento status;
    private String codigo;

    public Pagamento () {

    }

    public Pagamento(char tipoPagamento, double valor, Status_Pagamento status, String codigo) {
        tipo_pagamento = tipoPagamento;
        this.valor = valor;
        this.status = status;
        this.codigo = codigo;
    }

    public char getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(char tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Status_Pagamento getStatus() {
        return status;
    }

    public void setStatus(Status_Pagamento status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void realizar_pagamento(){
        System.out.println("Pagamento Concluido");
    }
}
