package pet4u.pet4u.callbacks;

import pet4u.pet4u.user.Account;

/**
 * Created by Rafael on 30/01/2017.
 */

public interface AccountCallback {
    void onSuccessGetAccount(Account account);
    void onFailureGetAccount(Throwable t);
}
