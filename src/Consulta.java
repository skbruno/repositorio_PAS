public class Consulta {
    private Especialidade especialidade;
    private Medico medico;
    private Paciente paciente;
    private PlanoSaude plano;
    private double custoFinal;
    private int data_consulta;

    public Consulta() {

    }

    public Consulta(Especialidade especialidade, Medico medico, Paciente paciente, PlanoSaude plano, double custoFinal, int dataConsulta) {
        this.especialidade = especialidade;
        this.medico = medico;
        this.paciente = paciente;
        this.plano = plano;
        this.custoFinal = custoFinal;
        data_consulta = dataConsulta;
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


    public void anexar(Observer Observer){

    }

    public void notificar(){

    }
}
