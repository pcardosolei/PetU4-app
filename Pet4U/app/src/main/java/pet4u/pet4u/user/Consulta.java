package pet4u.pet4u.user;

import java.util.Date;

/**
 * Created by NunoOliv on 01-Feb-17.
 */

public class Consulta implements Comparable<Consulta>{
    private int id;
    private String descriçao;
    private boolean pertilhado;
    private Date data;
    private String clinica;

    public Consulta(int id, String descriçao, boolean pertilhado, Date data, String clinica) {
        this.id = id;
        this.descriçao = descriçao;
        this.pertilhado = pertilhado;
        this.data = data;
        this.clinica = clinica;
    }

    public Consulta(ConsultaDTO c, Date data, String clinica) {
        this.id = c.getId();
        this.descriçao = c.getDescricao();
        this.pertilhado = c.isPartilha();
        this.data = data;
        this.clinica = clinica;
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

    public Date getDate() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    @Override
    public int compareTo(Consulta o) {
        return getDate().compareTo(o.getDate());
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", descriçao='" + descriçao + '\'' +
                ", pertilhado=" + pertilhado +
                ", data=" + data +
                ", clinica='" + clinica + '\'' +
                '}';
    }
}
