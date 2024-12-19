import java.util.List;

public class Medico {
    private String nome;
    private Especialidade especialidade;
    private Consultorio consultorio;
    private List<Horario_Disponivel> horarios;

    public Medico() {

    }
    public Medico(String nome, Especialidade especialidade, Consultorio consultorio, List<Horario_Disponivel> horarios) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.consultorio = consultorio;
        this.horarios = horarios;
    }

    public Medico(String nome, Especialidade especialidade, List<Horario_Disponivel> horarios) {
        this.nome = nome;
        this.especialidade = especialidade;
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

    public List<Horario_Disponivel> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario_Disponivel> horarios) {
        this.horarios = horarios;
    }
}
