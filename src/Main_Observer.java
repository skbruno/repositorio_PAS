public class Main_Observer {
    public static void main(String[] args) {
        Consulta consulta = new Consulta();

        Observer_Concreto obs1 = new Observer_Concreto("Observer 1");
        Observer_Concreto obs2 = new Observer_Concreto("Observer 2");

        consulta.anexar(obs1);
        consulta.anexar(obs2);

        consulta.alterarEstado(Status_Consulta.MARCADA);
        consulta.alterarEstado(Status_Consulta.CANCELADA);
    }
}