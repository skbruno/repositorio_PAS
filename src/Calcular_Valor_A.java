public class Calcular_Valor_A implements CalculoStrategy {
    @Override
    public double calcular(double precoBase){
        return  precoBase * 1.3;
    }
}
