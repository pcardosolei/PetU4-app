package pet4u.pet4u.user;

import java.io.Serializable;

/**
 * Created by Rafael on 01/02/2017.
 * Pet4U
 */

public class RacaDTO implements Serializable {

    private int id;
    private String raca;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "RacaDTO{" +
                "id=" + id +
                ", raca='" + raca + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
