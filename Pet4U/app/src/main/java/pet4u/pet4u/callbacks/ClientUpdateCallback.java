package pet4u.pet4u.callbacks;

import pet4u.pet4u.user.ClientDTO;

/**
 * Created by Rafael on 09/02/2017.
 * Package: pet4u.pet4u.callbacks.
 * Project: Pet4U.
 */

public interface ClientUpdateCallback {

    void onSuccessClientUpdate(ClientDTO clientDTO);
    void onFailureClientUpdate(Throwable t);

}
