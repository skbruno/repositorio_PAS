public enum Plano {
    HAPVIDA(new Especialidade[] {Especialidade.PEDIATRIA, Especialidade.DERMATOLOGIA, Especialidade.ENDOCRINOLOGIA},new Calcular_Valor_Hapvida()),
    PARTICULAR(new Especialidade[] {Especialidade.PEDIATRIA, Especialidade.DERMATOLOGIA, Especialidade.ENDOCRINOLOGIA}, new Calcular_Valor_Particular()),
    SAUDEUNEB(new Especialidade[] {Especialidade.PEDIATRIA, Especialidade.DERMATOLOGIA}, new Calcular_Valor_SaudeUNEB());
    //SaudeUNEB aceita todos, exceto Endocrinologia


    private final Especialidade[] especialidadesAceitas;
    private final CalculoStrategy strategy;

    Plano(Especialidade[] especialidadesAceitas, CalculoStrategy strategy) {
        this.especialidadesAceitas = especialidadesAceitas;
        this.strategy = strategy;
    }

    public boolean aceitaEspecialidade(Especialidade especialidade) {
        for (Especialidade esp : especialidadesAceitas) {
            if (esp == especialidade) {
                return true;
            }
        }
        return false;
    }

    public CalculoStrategy getStrategy() {
        return strategy;
    }
}