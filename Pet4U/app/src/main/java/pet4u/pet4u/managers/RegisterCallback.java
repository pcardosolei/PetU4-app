package pet4u.pet4u.managers;


public interface RegisterCallback {
    void onSuccess();
    void onFailure(Throwable t);
}
