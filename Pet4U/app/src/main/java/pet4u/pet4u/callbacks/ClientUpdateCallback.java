package pet4u.pet4u.callbacks;

/**
 * Created by Rafael on 09/02/2017.
 * Package: pet4u.pet4u.callbacks.
 * Project: Pet4U.
 */

public interface ClientUpdateCallback {

    void onSuccessClientUpdate();
    void onFailureClientUpdate(Throwable t);

}
