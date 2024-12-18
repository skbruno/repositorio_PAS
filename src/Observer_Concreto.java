public class Observer_Concreto extends Observer {
    private String nome;

    public Observer_Concreto(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(Consulta_Estado estadoConsulta) {
        System.out.println(nome + " foi notificado. Novo estado da consulta: " + estadoConsulta);
    }
}