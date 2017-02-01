package pet4u.pet4u.user;

/**
 * Created by Rafael on 01/02/2017.
 */

public class VacinaDTO {

    private int eventoId;
    private int id ;
    private String nome ;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "VacinaDTO{" +
                "eventoId=" + eventoId +
                ", id=" + id +
                ", nome=" + nome +
                '}';
    }
}
