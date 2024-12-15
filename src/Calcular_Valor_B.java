public class Calcular_Valor_B implements CalculoStrategy{
    @Override
    public double calcular(double precoBase){
        return precoBase * 0.8;
    }
}
