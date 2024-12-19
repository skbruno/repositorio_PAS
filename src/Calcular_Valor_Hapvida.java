public class Calcular_Valor_Hapvida implements CalculoStrategy {
    @Override
    public double calcular(double precoBase){
        return  precoBase * 0.2;
    }
}
// Procedimento Hapvida