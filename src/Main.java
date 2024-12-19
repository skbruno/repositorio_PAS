import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Atendente atendente = new Atendente("Ana", null, null, null, null);

        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1 -Cadastrar paciente");
            System.out.println("2 -Cadastrar médico");
            System.out.println("3 -Verificar plano");
            System.out.println("4 -Verificar horário");
            System.out.println("5 -Marcar consulta");
            System.out.println("6 -Efe6tuar pagamento");
            System.out.println("0 -Sair");
            System.out.print("Escolha uma opcao: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    atendente.cadastrar_paciente();
                    break;

                case 2:
                    atendente.cadastrar_medico();
                    break;

                case 3:
                    System.out.print("Digite a especialidade para verificar o plano: ");
                    String especialidadeInput = scanner.nextLine();
                    try {
                        Especialidade especialidade = Especialidade.valueOf(especialidadeInput.toUpperCase());
                        atendente.verificar_Plano(especialidade);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Especialidade invalida");
                    }
                    break;

                case 4:

                    break;

                case 5:
                    break;

                case 6:
                    atendente.efetuar_Pagamento();
                    break;

                case 0:
                    System.out.println("Saindo do sistema");
                    return;

                default:
                    System.out.println("Opção invalida");
            }
        }
    }
}
