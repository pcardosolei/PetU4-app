package pet4u.pet4u.user;

import java.util.ArrayList;

/**
 * Created by Rafael on 01/02/2017.
 */

public class EventoDTO {

    private int animalId;
    //private ClinicaDTO clinicaDTO;
    private ConsultaDTO consultaDTO;
    private int consultaId ;
    private String data ;
    private ArrayList<DesparasitacaoDTO> desparasitacoesDTO;
    private int id;
    private ArrayList<VacinaDTO> vacinasDTO;


    public ConsultaDTO getConsultaDTO() {
        return consultaDTO;
    }

    public void setConsultaDTO(ConsultaDTO consultaDTO) {
        this.consultaDTO = consultaDTO;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(int consultaId) {
        this.consultaId = consultaId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<DesparasitacaoDTO> getDesparasitacoesDTO() {
        return desparasitacoesDTO;
    }

    public void setDesparasitacoesDTO(ArrayList<DesparasitacaoDTO> desparasitacoesDTO) {
        this.desparasitacoesDTO = desparasitacoesDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<VacinaDTO> getVacinasDTO() {
        return vacinasDTO;
    }

    public void setVacinasDTO(ArrayList<VacinaDTO> vacinasDTO) {
        this.vacinasDTO = vacinasDTO;
    }

    @Override
    public String toString() {
        return "EventoDTO{" +
                "animalId=" + animalId +
                ", consultaDTO=" + consultaDTO +
                ", consultaId=" + consultaId +
                ", data='" + data + '\'' +
                ", desparasitacoesDTO=" + desparasitacoesDTO +
                ", id=" + id +
                ", vacinasDTO=" + vacinasDTO +
                '}';
    }


}
