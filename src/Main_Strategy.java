import java.util.Scanner;

public class Main_Strategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual e o seu plano? HAPVIDA, UNIMED, SAUDEUNEB)");
        String planoInput = scanner.nextLine().toUpperCase();

        Plano plano;
        try {
            plano = Plano.valueOf(planoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Plano invalido. Escolha entre HAPVIDA, UNIMED, SAUDEUNEB");
            scanner.close();
            return;
        }

        System.out.println("Digite o nome do procedimento:");
        String nomeProcedimento = scanner.nextLine();

        System.out.println("Digite o preco base do procedimento:");
        double precoBase;
        try {
            precoBase = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Preco invalido insira um numero valido.");
            scanner.close();
            return;
        }

        Procedimento procedimento = new Procedimento(nomeProcedimento, precoBase, plano.getStrategy());

        System.out.println("Preco final do " + procedimento.getNome() + " com o plano " + plano + ": " + procedimento.valorBase());

        scanner.close();
    }
}
