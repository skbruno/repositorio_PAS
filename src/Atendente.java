public class Atendente {
    private String nome;
    private Medico medicos_horarios;
    private PlanoSaude planos_aceitos;
    private Paciente paciente;
    private Pagamento pagamentol;

    public Atendente() {

    }
    public Atendente(String nome, Medico medicosHorarios, PlanoSaude planosAceitos, Paciente paciente, Pagamento pagamentol) {
        this.nome = nome;
        medicos_horarios = medicosHorarios;
        planos_aceitos = planosAceitos;
        this.paciente = paciente;
        this.pagamentol = pagamentol;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medico getMedicos_horarios() {
        return medicos_horarios;
    }

    public void setMedicos_horarios(Medico medicos_horarios) {
        this.medicos_horarios = medicos_horarios;
    }

    public PlanoSaude getPlanos_aceitos() {
        return planos_aceitos;
    }

    public void setPlanos_aceitos(PlanoSaude planos_aceitos) {
        this.planos_aceitos = planos_aceitos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Pagamento getPagamentol() {
        return pagamentol;
    }

    public void setPagamentol(Pagamento pagamentol) {
        this.pagamentol = pagamentol;
    }

    public void verificar_Disponibilidade(){

    }

    public void verificar_Plano(){

    }

    public void marcar_Consulta(){

    }

    public void efetuar_Pagamento(){

    }
}
