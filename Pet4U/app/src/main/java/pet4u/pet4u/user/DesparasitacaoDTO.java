package pet4u.pet4u.user;

/**
 * Created by Rafael on 01/02/2017.
 */

public class DesparasitacaoDTO {

    private int eventoId;
    private int id;
    private String tipo;

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "DesparasitacaoDTO{" +
                "eventoId=" + eventoId +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
