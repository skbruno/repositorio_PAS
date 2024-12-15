public class Database {
    private Consulta consulta;
    private static Database instance;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
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
