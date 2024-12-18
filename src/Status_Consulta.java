public enum Status_Consulta {
    INICIAL(1),
    MARCADA(2),
    CANCELADA(3),
    REMARCADA(4);

    private final int codigo;

    Status_Consulta(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
