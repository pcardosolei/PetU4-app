package pet4u.pet4u.callbacks;

import pet4u.pet4u.user.AccountDTO;

/**
 * Created by Rafael on 30/01/2017.
 * Package: ${PACKAGE_NAME}.
 * Project: Pet4U.
 */

public interface AccountCallback {
    void onSuccessGetAccount(AccountDTO accountDTO);
    void onFailureGetAccount(Throwable t);
}
