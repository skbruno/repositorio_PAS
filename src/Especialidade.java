public enum Especialidade {
    PEDIATRIA(1),
    DERMATOLOGIA(2),
    ENDOCRINOLOGIA(3);

    private final int codigo;

    Especialidade(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
