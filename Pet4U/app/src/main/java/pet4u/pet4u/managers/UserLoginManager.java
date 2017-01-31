package pet4u.pet4u.managers;

import android.util.Log;

import pet4u.pet4u.UserToken;

import pet4u.pet4u.callbacks.LoginCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginManager {

    private static UserLoginManager ourInstance;
    private UserToken userToken;
    private String bearerToken;

    private UserLoginManager() {
    }

    public static UserLoginManager getInstance() {
        if(ourInstance == null){
            ourInstance = new UserLoginManager();
        }

        return ourInstance;
    }

    public synchronized void performLogin(String username, String password, final LoginCallback loginCallback){
        Call<UserToken> call =  UserTokenManager.getInstance().getUserToken(username, password);

        call.enqueue(new Callback<UserToken>() {
            @Override
            public void onResponse(Call<UserToken> call, Response<UserToken> response) {
                Log.i("UserLoginManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                userToken = response.body();

                int code = response.code();
                System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    bearerToken = "Bearer " + userToken.getAccessToken();
                    loginCallback.onSuccess(userToken);
                } else {
                    loginCallback.onFailure(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserToken> call, Throwable t) {
                Log.e("UserLoginManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                loginCallback.onFailure(t);
            }
        });
    }

    public UserToken getUserToken(){
        return userToken;
    }

    public String getBearerToken() {
        return bearerToken;
    }
}