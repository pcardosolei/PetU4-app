package pet4u.pet4u.callbacks;

import pet4u.pet4u.user.RacaDTO;

/**
 * Created by Rafael on 01/02/2017.
 * Pet4U
 */

public interface RacaCallback {
    void onSuccessRaca(RacaDTO racaDTO);
    void onFailureRaca(Throwable t);

}
