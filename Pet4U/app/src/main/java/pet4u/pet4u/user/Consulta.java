package pet4u.pet4u.user;

import java.util.Date;

/**
 * Created by NunoOliv on 01-Feb-17.
 */

public class Consulta {
    private int id;
    private String descriçao;
    private boolean pertilhado;
    private Date data;

    public Consulta(int id, String descriçao, boolean pertilhado, Date data) {
        this.id = id;
        this.descriçao = descriçao;
        this.pertilhado = pertilhado;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
    }

    public boolean isPertilhado() {
        return pertilhado;
    }

    public void setPertilhado(boolean pertilhado) {
        this.pertilhado = pertilhado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consulta consulta = (Consulta) o;

        if (getId() != consulta.getId()) return false;
        if (isPertilhado() != consulta.isPertilhado()) return false;
        if (!getDescriçao().equals(consulta.getDescriçao())) return false;
        return getData().equals(consulta.getData());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDescriçao().hashCode();
        result = 31 * result + (isPertilhado() ? 1 : 0);
        result = 31 * result + getData().hashCode();
        return result;
    }
}
