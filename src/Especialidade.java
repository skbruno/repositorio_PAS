public enum Especialidade {
    PEDIATRIA(150.0),
    DERMATOLOGIA(180.0),
    ENDOCRINOLOGIA(200.0);

    private final double precoBase;

    Especialidade(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getPrecoBase() {
        return precoBase;
    }
}
