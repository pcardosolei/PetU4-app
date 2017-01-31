package pet4u.pet4u.callbacks;


import pet4u.pet4u.user.Client;

/**
 * Created by Rafael on 31/01/2017.
 */

public interface ClientCallback {

    void onSuccessCliente(Client client);
    void onFailureCliente(Throwable t);

}
