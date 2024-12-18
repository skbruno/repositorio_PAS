public class Consulta_Estado {
    private Status_Consulta status;

    public  Consulta_Estado() {

    }

    public Consulta_Estado(Status_Consulta status) {
        this.status = status;
    }

    public Status_Consulta getStatus() {
        return status;
    }

    public void setStatus(Status_Consulta status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status + " (Código: " + status.getCodigo() + ")";
    }
}
