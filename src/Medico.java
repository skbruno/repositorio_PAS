public class Medico {
    private String nome;
    private Especialidade especialidade;
    private Consultorio consultorio;
    private Horario_Disponivel horarios;

    public Medico() {

    }
    public Medico(String nome, Especialidade especialidade, Consultorio consultorio, Horario_Disponivel horarios) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.consultorio = consultorio;
        this.horarios = horarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Horario_Disponivel getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario_Disponivel horarios) {
        this.horarios = horarios;
    }
}
