package pet4u.pet4u.callbacks;


import pet4u.pet4u.user.ClientDTO;

/**
 * Created by Rafael on 31/01/2017.
 * Package: ${PACKAGE_NAME}.
 * Project: Pet4U.
 */

public interface ClientCallback {

    void onSuccessCliente(ClientDTO clientDTO);
    void onFailureCliente(Throwable t);

}
