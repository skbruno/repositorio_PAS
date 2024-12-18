public class Database {
    private Consulta consulta;
    private static final Database instance = new Database();

    private Database(){

    }

    public static Database getInstance() {
        return instance;
    }


    public void query_Create() {
        System.out.println("Criando.....");
    }

    public void query_Delete() {
        System.out.println("Deletando......");
    }

    public void query_Update() {
        System.out.println("Atualizando.....");
    }
}
