public enum Status_Consulta {
    MARCADA(1),
    CANCELADA(2),
    REMARCADA(3);

    private final int codigo;

    Status_Consulta(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
