public class Horario_Disponivel {
    private int data;
    private int horario;

    public Horario_Disponivel() {

    }
    public Horario_Disponivel(int data, int horario) {
        this.data = data;
        this.horario = horario;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
}
