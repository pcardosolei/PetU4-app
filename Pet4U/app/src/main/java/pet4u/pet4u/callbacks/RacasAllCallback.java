package pet4u.pet4u.callbacks;

import java.util.ArrayList;

import pet4u.pet4u.user.RacaDTO;

/**
 * Created by Rafael on 09/02/2017.
 * Package: pet4u.pet4u.callbacks.
 * Project: Pet4U.
 */

public interface RacasAllCallback {

    void onSuccessRacasAll(ArrayList<RacaDTO> racas);
    void onFailureRacasAll(Throwable t);

}
