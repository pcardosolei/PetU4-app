package pet4u.pet4u.user;

import java.util.Date;

/**
 * Created by NunoOliv on 31-Jan-17.
 */

public class Vacina implements Comparable<Vacina>{

    private int id;
    private Date date;
    private String nome;

    public Vacina(int id, Date date, String nome) {
        this.id = id;
        this.date = date;
        this.nome = nome;
    }

    public Vacina(int id) {
        this.id = id;
        this.date = new Date();
        this.nome = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Vacina o) {
        return getDate().compareTo(o.getDate());
    }
}
