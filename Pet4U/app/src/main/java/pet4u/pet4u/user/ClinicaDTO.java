package pet4u.pet4u.user;

import java.util.ArrayList;

/**
 * Created by Rafael on 01/02/2017.
 * Pet4U
 */

public class ClinicaDTO {

    private ArrayList<Animal> animais;
    private ArrayList<Client> clientes;
    private String codigoassociacao;
    private int creatorId;
    private int id;
    private String nif;
    private String nome;
    private String placeid;

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

    public ArrayList<Client> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Client> clientes) {
        this.clientes = clientes;
    }

    public String getCodigoassociacao() {
        return codigoassociacao;
    }

    public void setCodigoassociacao(String codigoassociacao) {
        this.codigoassociacao = codigoassociacao;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaceid() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    @Override
    public String toString() {
        return "ClinicaDTO{" +
                "animais=" + animais +
                ", clientes=" + clientes +
                ", codigoassociacao='" + codigoassociacao + '\'' +
                ", creatorId=" + creatorId +
                ", id=" + id +
                ", nif='" + nif + '\'' +
                ", nome='" + nome + '\'' +
                ", placeid='" + placeid + '\'' +
                '}';
    }
}
