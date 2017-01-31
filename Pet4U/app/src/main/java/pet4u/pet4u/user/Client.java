package pet4u.pet4u.user;

/**
 * Created by Rafael on 30/01/2017.
 */

public class Client {

    private String codigoassociacao;
    private String dataNasc;
    private String foto;
    private String genero;
    private int id;
    private Address moradaDTO;
    private String nif;
    private String nome;
    private String placeid ;
    private int telemovel ;
    private int userId ;

    public String getCodigoassociacao() {
        return codigoassociacao;
    }

    public void setCodigoassociacao(String codigoassociacao) {
        this.codigoassociacao = codigoassociacao;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getMoradaDTO() {
        return moradaDTO;
    }

    public void setMoradaDTO(Address moradaDTO) {
        this.moradaDTO = moradaDTO;
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

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "codigoassociacao='" + codigoassociacao + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", foto='" + foto + '\'' +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                ", moradaDTO=" + moradaDTO +
                ", nif='" + nif + '\'' +
                ", nome='" + nome + '\'' +
                ", placeid='" + placeid + '\'' +
                ", telemovel=" + telemovel +
                ", userId=" + userId +
                '}';
    }
}
