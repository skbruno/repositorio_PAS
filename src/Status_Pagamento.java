public enum Status_Pagamento {
    PENDENTE(1),
    CANCELADO(2),
    PAGO(3);

    private final int codigo;

    Status_Pagamento(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

}
