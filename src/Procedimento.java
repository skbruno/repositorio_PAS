public class Procedimento {
    private String nome;
    private double preco;
    private CalculoStrategy strategy;

    public Procedimento() {

    }
    public Procedimento(String nome, double preco, CalculoStrategy strategy) {
        this.nome = nome;
        this.preco = preco;
        this.strategy = strategy;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CalculoStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(CalculoStrategy strategy) {
        this.strategy = strategy;
    }

    public double valorBase(){
        if(strategy== null) {
            System.out.println("sem estrategia de calculo definido");
        }
        return strategy.calcular(preco);
    }
}
