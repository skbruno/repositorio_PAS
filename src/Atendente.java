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
    private Consultorio consultorio;
    private Pagamento pagamento = new Pagamento();
    private List<Consulta> consultas = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Atendente() {

    }
    public Atendente(String nome) {
        this.nome = nome;
    }

    public Atendente(String nome, Medico medicosHorarios, PlanoSaude planosAceitos, Paciente paciente) {
        this.nome = nome;
        medicos_horarios = medicosHorarios;
        planos_aceitos = planosAceitos;
        this.paciente = paciente;
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
        System.out.print("Digite o nome do medico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("Digite a data e horário no formato yyyy-MM-ddTHH:mm (exemplo: 2024-12-20T11:05): ");
        String horarioInput = scanner.nextLine();

        LocalDateTime horarioDesejado;
        try {
            horarioDesejado = LocalDateTime.parse(horarioInput);
        } catch (Exception e) {
            System.out.println("Formato de horario invalido");
            return;
        }

        if (medicos_horarios == null || !medicos_horarios.getNome().equalsIgnoreCase(nomeMedico)) {
            System.out.println("Medico nao encontrado");
            return;
        }

        List<Horario_Disponivel> horariosDisponiveis = medicos_horarios.getHorarios();
        if (horariosDisponiveis == null || horariosDisponiveis.isEmpty()) {
            System.out.println("O medico " + nomeMedico + " nao possui horarios cadastrados");
            return;
        }

        boolean horarioDisponivel = false;
        for (Horario_Disponivel horario : horariosDisponiveis) {
            if (horario.getData().equals(horarioDesejado.toLocalDate()) &&
                    horario.getHorario().equals(horarioDesejado.toLocalTime())) {
                horarioDisponivel = true;
                break;
            }
        }

        if (horarioDisponivel) {
            System.out.println("O horario está disponivel para o medico " + nomeMedico + ".");
        } else {
            System.out.println("O horario não está disponivel para o medico " + nomeMedico + ".");
        }
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
        Especialidade especialidade;
        Plano plano;

        //Regiao listar e selecionar paciente
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        System.out.println("Selecione um paciente:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + 1 + ". " + pacientes.get(i).getNome());
        }
        System.out.print("Digite o número do paciente: ");
        int pacienteIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (pacienteIndex < 0 || pacienteIndex >= pacientes.size()) {
            System.out.println("Paciente inválido.");
            return;
        }
        Paciente pacienteSelecionado = pacientes.get(pacienteIndex);

        //Regiao selecionar especialidade
        System.out.print("Digite a especialidade desejada entre PEDIATRIA, DERMATOLOGIA, ENDOCRINOLOGIA: ");
        String especialidadeDesejada = scanner.nextLine().toUpperCase();

        //Regiao listar e selecionar medico
        List<Medico> medicosComEspecialidade = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico.getEspecialidade().name().equalsIgnoreCase(especialidadeDesejada)) {
                medicosComEspecialidade.add(medico);
            }
        }
        if (medicosComEspecialidade.isEmpty()) {
            System.out.println("Nenhum mEdico encontrado para essa especialidade");
            return;
        }
        System.out.println("Médicos disponíveis para a especialidade " + especialidadeDesejada + ":");
        for (int i = 0; i < medicosComEspecialidade.size(); i++) {
            System.out.println(i + 1 + ". " + medicosComEspecialidade.get(i).getNome());
        }
        System.out.print("Digite o número do médico: ");
        int medicoIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (medicoIndex < 0 || medicoIndex >= medicosComEspecialidade.size()) {
            System.out.println("Médico inválido.");
            return;
        }
        Medico medicoSelecionado = medicosComEspecialidade.get(medicoIndex);

        //Regiao listar e selecionar horario
        System.out.print("Digite o horário no formato yyyy-MM-ddTHH:mm: ");
        String horarioInput = scanner.nextLine();
        LocalDateTime horarioDesejado;
        try {
            horarioDesejado = LocalDateTime.parse(horarioInput);
        } catch (Exception e) {
            System.out.println("Formato de horário inválido.");
            return;
        }

        List<Horario_Disponivel> horariosDisponiveis = medicoSelecionado.getHorarios();
        boolean horarioDisponivel = false;
        for (Horario_Disponivel horario : horariosDisponiveis) {
            if (horario.getData().equals(horarioDesejado.toLocalDate()) &&
                    horario.getHorario().equals(horarioDesejado.toLocalTime())) {
                horarioDisponivel = true;
                break;
            }
        }

        if (horarioDisponivel) {
            System.out.println("Horario disponivel para o paciente " +
                    pacienteSelecionado.getNome() + " com o médico " + medicoSelecionado.getNome() +
                    " no horário " + horarioDesejado + ".");
        } else {
            System.out.println("Horário indisponível para o médico " + medicoSelecionado.getNome() + ".");
            return;
        }

        //Regiao dizer o plano
        System.out.print("Qual e o seu plano? (HAPVIDA, PARTICULAR, SAUDEUNEB): ");
        String planoInput = scanner.nextLine().toUpperCase();

        try {
            plano = Plano.valueOf(planoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Infelizmente nao aceitamos esse plano. Escolha entre HAPVIDA, PARTICULAR, SAUDEUNEB");
            scanner.close();
            return;
        }

        try {
            especialidade = Especialidade.valueOf(especialidadeDesejada);
        } catch (IllegalArgumentException e) {
            System.out.println("Especialidade invalida Escolha entre PEDIATRIA, DERMATOLOGIA, ENDOCRINOLOGIA: ");
            scanner.close();
            return;
        }

        if (!plano.aceitaEspecialidade(especialidade)) {
            System.out.println("O plano " + plano + " não aceita a especialidade " + especialidade);
            scanner.close();
            return;
        }
        double precoBase = especialidade.getPrecoBase();

        Procedimento procedimento = new Procedimento(especialidade.name(), precoBase, plano.getStrategy());
        System.out.println("Preco final da consulta de " + procedimento.getNome() + " com o plano " + plano + ": R$" + procedimento.valorBase());

        planos_aceitos = new PlanoSaude(planoInput,procedimento);

        // Confirmar e marcar consulta
        System.out.print("Deseja marcar a consulta? Digite 1 para SIM ou 2 para NÃO:");
        int escolha = Integer.parseInt(scanner.nextLine());

        if (escolha == 1) {
            Consulta novaConsulta = new Consulta(especialidade, medicoSelecionado, pacienteSelecionado, planos_aceitos, procedimento.valorBase(), horarioDesejado.getDayOfYear());
            consultas.add(novaConsulta);
            System.out.println("Consulta marcada com sucesso para " + pacienteSelecionado.getNome() + " com o médico " + medicoSelecionado.getNome() +
                    " no horário " + horarioDesejado + ".");
        } else if (escolha == 2) {
            System.out.println("Voltando");
        } else {
            System.out.println("Opção invalida");
        }

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
            System.out.println("Paciente maior de idade cadastrado");
        }
        pacientes.add(paciente);
    }

    public void cadastrar_medico() {

        System.out.print("Digite o nome do medico: ");
        String nomeMedico = scanner.nextLine();

        System.out.print("Digite o id da filial: ");
        int idconsultorio = Integer.parseInt(scanner.nextLine());

        System.out.println("Escolha uma especialidade : ");
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

        consultorio = new Consultorio(idconsultorio);
        Medico novoMedico = new Medico(nomeMedico, especialidade, consultorio ,horariosDisponiveis);

        this.medicos_horarios = novoMedico;

        System.out.println("Medico cadastrado");
        System.out.println("Nome: " + novoMedico.getNome());
        System.out.println("Especialidade: " + novoMedico.getEspecialidade());
        System.out.println("Horarios disponiveis: ");
        for (Horario_Disponivel horario : novoMedico.getHorarios()) {
            System.out.println("- " + horario.getData() + " " + horario.getHorario());
        }
        medicos.add(novoMedico);
    }

    public void efetuar_Pagamento(){
        if (consultas == null || consultas.isEmpty()) {
            System.out.println("Nenhuma consulta foi encontrada.");
            return;
        }

        System.out.println("Consultas disponíveis:");
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            System.out.println((i + 1) + ". Paciente: " + consulta.getPaciente().getNome() +
                    ", Medico: " + consulta.getMedico().getNome() +
                    ", Especialidade: " + consulta.getEspecialidade() +
                    ", Estado: " + consulta.getEstadoConsulta());
            Observer_Concreto obs1 = new Observer_Concreto(consulta.getPaciente().getNome());
            consulta.anexar(obs1);
        }

        System.out.print("Digite o número da consulta que deseja Pagar: ");
        pagamento.realizar_pagamento();
    }

    public void alterar_estado() {
        if (consultas == null || consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada");
            return;
        }

        System.out.println("Consultas disponíveis:");
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            System.out.println((i + 1) + ". Paciente: " + consulta.getPaciente().getNome() +
                    ", Medico: " + consulta.getMedico().getNome() +
                    ", Especialidade: " + consulta.getEspecialidade() +
                    ", Estado: " + consulta.getEstadoConsulta());
            Observer_Concreto obs1 = new Observer_Concreto(consulta.getPaciente().getNome());
            consulta.anexar(obs1);
        }

        System.out.print("Digite o numero da consulta que deseja alterar: ");
        int consultaIndex = Integer.parseInt(scanner.nextLine()) - 1;

        Consulta consultaSelecionada = consultas.get(consultaIndex);

        System.out.println("Estados disponiveis: MARCADA, CANCELADA, REMARCADA");
        System.out.print("Digite o novo estado para a consulta: ");
        String novoEstadoInput = scanner.nextLine().toUpperCase();

        try {
            Status_Consulta novoEstado = Status_Consulta.valueOf(novoEstadoInput);
            consultaSelecionada.alterarEstado(novoEstado);
        } catch (IllegalArgumentException e) {
            System.out.println("Estado inválido. Operação cancelada.");
        }
    }
}
