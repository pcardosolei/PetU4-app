package pet4u.pet4u.callbacks;

import pet4u.pet4u.managers.UserToken;

public interface LoginCallback {
    void onSuccess(UserToken userToken);
    void onFailure(Throwable t);
}
