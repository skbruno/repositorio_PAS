public enum Plano {
    HAPVIDA(new Calcular_Valor_A()),
    UNIMED(new Calcular_Valor_B()),
    SAUDEUNEB(new Calcular_Valor_C());

    private final CalculoStrategy strategy;

    Plano(CalculoStrategy strategy) {
        this.strategy = strategy;
    }

    public CalculoStrategy getStrategy() {
        return strategy;
    }
}