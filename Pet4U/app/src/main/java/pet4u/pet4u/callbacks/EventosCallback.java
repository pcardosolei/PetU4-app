package pet4u.pet4u.callbacks;

import java.util.ArrayList;

import pet4u.pet4u.user.EventoDTO;

/**
 * Created by Rafael on 01/02/2017.
 */

public interface EventosCallback {

    void onSuccessEventos(ArrayList<EventoDTO> eventos);
    void onFailureEventos(Throwable t);

}
