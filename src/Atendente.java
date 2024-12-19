import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atendente {
    private String nome;
    private Medico medicos_horarios;
    private PlanoSaude planos_aceitos;
    private Paciente paciente;
    private Responsavel responsavel;
    private Pagamento pagamento;
    Scanner scanner = new Scanner(System.in);

    public Atendente() {

    }
    public Atendente(String nome, Medico medicosHorarios, PlanoSaude planosAceitos, Paciente paciente, Pagamento pagamento) {
        this.nome = nome;
        medicos_horarios = medicosHorarios;
        planos_aceitos = planosAceitos;
        this.paciente = paciente;
        this.pagamento = pagamento;
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

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void verificar_Disponibilidade() {

    }


    public void verificar_Plano(Especialidade especialidade){
        System.out.println("Plano dispoivel" + especialidade);
        for (Plano plano : Plano.values()) {
            if (plano.aceitaEspecialidade(especialidade)) {
                System.out.println("-" + plano.name());
            }
        }
    }

    public void marcar_Consulta(){

    }

    public void cadastrar_paciente() {

        System.out.print("Digite seu nome: ");
        String nomePaciente = scanner.nextLine();

        System.out.print("Digite seu rg: ");
        String rgPaciente = scanner.nextLine();

        System.out.print("Digite seu cpf: ");
        String cpfPaciente = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idadePaciente = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite M para masculino e F para feminino: ");
        String sexoPaciente = scanner.nextLine();

        if (idadePaciente < 18) {
            System.out.print("Digite o nome do responsavel: ");
            String responsavelNomePaciente = scanner.nextLine();

            System.out.print("Digite o rg do responsavel: ");
            String rgNomePaciente = scanner.nextLine();

            responsavel = new Responsavel(responsavelNomePaciente,rgNomePaciente);
            paciente = new Paciente(nomePaciente, rgPaciente, cpfPaciente, idadePaciente, sexoPaciente, responsavel);
            System.out.println("Paciente menor de idade cadastrado com responsavel: " + responsavel.getNome());
        } else {
            paciente = new Paciente(nomePaciente, rgPaciente, cpfPaciente, idadePaciente, sexoPaciente);
            System.out.println("paciente maior de idade cadastrado");
        }
    }

    public void cadastrar_medico() {

        System.out.print("Digite o nome do medico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("Digite o id da filial: ");
        int idconsultorio = Integer.parseInt(scanner.nextLine());

        System.out.println("Escolha uma especialidade: ");
        for (Especialidade especialidade : Especialidade.values()) {
            System.out.println("- " + especialidade);
        }
        System.out.print("Digite a especialidade: ");
        String especialidadeInput = scanner.nextLine();
        Especialidade especialidade;
        try {
            especialidade = Especialidade.valueOf(especialidadeInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("especialidade invalida");
            return;
        }

        List<Horario_Disponivel> horariosDisponiveis = new ArrayList<>();
        System.out.println("Digite os horários disponíveis para o medico. Formato: yyyy-MM-ddTHH:mm(exemplo: 2024-12-20T11:05) (digite 'sair' para encerrar)");

        while (true) {
            System.out.print("Horario: ");
            String horarioInput = scanner.nextLine();

            if (horarioInput.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                LocalDateTime horario = LocalDateTime.parse(horarioInput);
                horariosDisponiveis.add(new Horario_Disponivel(horario.toLocalDate(), horario.toLocalTime()));
            } catch (Exception e) {
                System.out.println("Formato invalido");
            }
        }

        Medico novoMedico = new Medico(nomeMedico, especialidade, horariosDisponiveis);

        this.medicos_horarios = novoMedico;

        System.out.println("Medico cadastrado");
        System.out.println("Nome: " + novoMedico.getNome());
        System.out.println("Especialidade: " + novoMedico.getEspecialidade());
        System.out.println("Horarios disponiveis: ");
        for (Horario_Disponivel horario : novoMedico.getHorarios()) {
            System.out.println("- " + horario.getData() + " " + horario.getHorario());
        }
    }

    public void efetuar_Pagamento(){
        pagamento.realizar_pagamento();
    }
}
