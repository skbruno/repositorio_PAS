public class Calcular_Valor_C  implements  CalculoStrategy{
    @Override
    public double calcular(double precoBase) {
        return precoBase * 0.5;
    }
}
