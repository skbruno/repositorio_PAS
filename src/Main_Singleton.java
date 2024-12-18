public class Main_Singleton {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();

        db1.query_Create();
        db1.query_Update();
        db1.query_Delete();

        Database db2 = Database.getInstance();
        System.out.println("sao iguais as instancias? " + (db1 == db2));
    }
}
