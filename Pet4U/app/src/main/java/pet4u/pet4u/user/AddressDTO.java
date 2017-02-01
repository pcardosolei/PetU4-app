package pet4u.pet4u.user;

/**
 * Created by Rafael on 30/01/2017.
 * Pet4U
 */

public class AddressDTO {

    private String cidade ;
    private String codPostal;
    private int id;
    private String pais;
    private String rua;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "cidade='" + cidade + '\'' +
                ", codPostal='" + codPostal + '\'' +
                ", id=" + id +
                ", pais='" + pais + '\'' +
                ", rua='" + rua + '\'' +
                '}';
    }
}
