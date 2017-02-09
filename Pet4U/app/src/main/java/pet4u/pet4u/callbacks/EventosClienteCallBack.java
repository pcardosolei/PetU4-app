package pet4u.pet4u.callbacks;

import java.util.ArrayList;

import pet4u.pet4u.user.EventoDTO;

/**
 * Created by Rafael on 09/02/2017.
 * Package: pet4u.pet4u.callbacks.
 * Project: Pet4U.
 */

public interface EventosClienteCallBack {

    void onSuccessEventosCliente(ArrayList<EventoDTO> eventos);
    void onFailureEventosCliente(Throwable t);

}
