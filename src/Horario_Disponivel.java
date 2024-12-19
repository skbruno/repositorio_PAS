import java.time.LocalDate;
import java.time.LocalTime;

public class Horario_Disponivel {
    private LocalDate data;
    private LocalTime horario;

    public Horario_Disponivel() {

    }
    public Horario_Disponivel(LocalDate data, LocalTime horario) {
        this.data = data;
        this.horario = horario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
