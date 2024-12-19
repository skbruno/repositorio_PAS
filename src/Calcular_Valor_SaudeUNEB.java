public class Calcular_Valor_SaudeUNEB implements  CalculoStrategy{
    @Override
    public double calcular(double precoBase) {
        return precoBase * 0.1;
    }
}
// Procedimento SaudeUNEB