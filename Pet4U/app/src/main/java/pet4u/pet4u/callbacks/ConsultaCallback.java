package pet4u.pet4u.callbacks;

import pet4u.pet4u.user.ConsultaDTO;

/**
 * Created by Rafael on 08/02/2017.
 * Package: pet4u.pet4u.callbacks.
 * Project: Pet4U.
 */

public interface ConsultaCallback {
    void onSuccessConsulta(ConsultaDTO consultaDTO);
    void onFailureConsulta(Throwable t);
}
