package pet4u.pet4u.managers;

import pet4u.pet4u.user.Account;

/**
 * Created by Rafael on 30/01/2017.
 */

public interface AccountCallback {
    void onSuccess(Account account);
    void onFailure(Throwable t);
}
