public class PlanoSaude {
    private String nome;
    private Procedimento procedimento_nome;

    public PlanoSaude() {

    }
    public PlanoSaude(String nome, Procedimento procedimentoNome) {
        this.nome = nome;
        procedimento_nome = procedimentoNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Procedimento getProcedimento_nome() {
        return procedimento_nome;
    }

    public void setProcedimento_nome(Procedimento procedimento_nome) {
        this.procedimento_nome = procedimento_nome;
    }

    public void validarProcedimento(){

    }

}
