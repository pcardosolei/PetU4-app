package pet4u.pet4u.user;

/**
 * Created by Rafael on 01/02/2017.
 */

public class ConsultaDTO {

    private String descricao;
    private int id;
    private boolean partilha;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPartilha() {
        return partilha;
    }

    public void setPartilha(boolean partilha) {
        this.partilha = partilha;
    }

    @Override
    public String toString() {
        return "ConsultaDTO{" +
                "descricao='" + descricao + '\'' +
                ", id=" + id +
                ", partilha=" + partilha +
                '}';
    }
}
