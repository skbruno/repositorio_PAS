import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private Especialidade especialidade;
    private Medico medico;
    private Paciente paciente;
    private PlanoSaude plano;
    private double custoFinal;
    private int data_consulta;

    private List<Observer> observadores = new ArrayList<>();
    private Consulta_Estado estadoConsulta;

    public Consulta() {
        this.estadoConsulta = new Consulta_Estado(Status_Consulta.INICIAL);
    }

    public Consulta(Especialidade especialidade, Medico medico, Paciente paciente, PlanoSaude plano, double custoFinal, int dataConsulta) {
        this.especialidade = especialidade;
        this.medico = medico;
        this.paciente = paciente;
        this.plano = plano;
        this.custoFinal = custoFinal;
        this.data_consulta = dataConsulta;
        this.estadoConsulta = new Consulta_Estado(Status_Consulta.INICIAL);
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(int data_consulta) {
        this.data_consulta = data_consulta;
    }

    public double getCustoFinal() {
        return custoFinal;
    }

    public void setCustoFinal(double custoFinal) {
        this.custoFinal = custoFinal;
    }

    public PlanoSaude getPlano() {
        return plano;
    }

    public void setPlano(PlanoSaude plano) {
        this.plano = plano;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }


    public void anexar(Observer observer) {
        observadores.add(observer);
    }

    public void notificar() {
        for (Observer observer : observadores) {
            observer.atualizar(estadoConsulta);
        }
    }

    public void alterarEstado(Status_Consulta novoStatus) {
        if (estadoConsulta == null) {
            System.out.println("O estado da consulta não foi inicializado");
        }
        estadoConsulta.setStatus(novoStatus);
        System.out.println("Estado da consulta alterado para: " + novoStatus);
        notificar();
    }
}
