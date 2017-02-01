package pet4u.pet4u.user;

/**
 * Created by Rafael on 31/01/2017.
 * Pet4U
 */

public class AnimalDTO {


    private String dataNasc;
    private String genero;
    private int id;
    private String nome;
    private int peso ;
    private String porte ;
    private int racaId ;
    private String racaNome ;
    private String tipo ;


    public String getDataNasc() {
        return dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    public String getPorte() {
        return porte;
    }

    public int getRacaId() {
        return racaId;
    }

    public String getRacaNome() {
        return racaNome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public void setRacaId(int racaId) {
        this.racaId = racaId;
    }

    public void setRacaNome(String racaNome) {
        this.racaNome = racaNome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "AnimalDTO{" +
                "dataNasc='" + dataNasc + '\'' +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", porte='" + porte + '\'' +
                ", racaId=" + racaId +
                ", racaNome='" + racaNome + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public void fillRace(){

    }
}
