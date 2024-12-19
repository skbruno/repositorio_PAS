import java.util.Scanner;

public class Main_Strategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual e o seu plano? (HAPVIDA, PARTICULAR, SAUDEUNEB)");
        String planoInput = scanner.nextLine().toUpperCase();

        Plano plano;
        try {
            plano = Plano.valueOf(planoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Infelizmente nao aceitamos esse plano. Escolha entre HAPVIDA, PARTICULAR, SAUDEUNEB");
            scanner.close();
            return;
        }

        System.out.println("Escolha a especialidade da consulta: PEDIATRIA, DERMATOLOGIA, ENDOCRINOLOGIA ");
        String especialidadeInput = scanner.nextLine().toUpperCase();

        Especialidade especialidade;
        try {
            especialidade = Especialidade.valueOf(especialidadeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Especialidade invalida. Escolha entre PEDIATRIA, DERMATOLOGIA, ENDOCRINOLOGIA.");
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

        scanner.close();
    }
}
