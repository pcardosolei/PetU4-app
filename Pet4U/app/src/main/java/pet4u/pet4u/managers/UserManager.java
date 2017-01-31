package pet4u.pet4u.managers;

import android.util.Log;

import pet4u.pet4u.AppProperties;
import pet4u.pet4u.user.Account;
import pet4u.pet4u.UserToken;
import pet4u.pet4u.services.GetAccountService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael on 30/01/2017.
 */

public class UserManager {
    private static UserManager ourInstance;
    private UserToken userToken;
    private Account account;


    public UserManager (){
        this.userToken = null;
    }

    public UserManager (UserToken userToken){
        this.userToken = userToken;
    }


    public static UserManager getInstance() {
        if(ourInstance == null){
            ourInstance = new UserManager();
        }

        return ourInstance;
    }

    public synchronized void getAccount(final AccountCallback accountCallback) {
        account = new Account();
        Retrofit retrofit;
        GetAccountService getAccServ;

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppProperties.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getAccServ = retrofit.create(GetAccountService.class);
        }catch  (Exception e) {
            Log.e("UserTokenManager->", "constructor->source.getBytes('UTF-8') ERROR: " + e);
            return;
        }

        System.out.println("System TOKEN: " + "Bearer " +  userToken.getAccessToken());
        Call<Account> call = getAccServ.getAccount("Bearer " + userToken.getAccessToken());

        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                Log.i("UserLoginManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                account = response.body();

                int code = response.code();
                System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    accountCallback.onSuccess(account);
                } else {
                    accountCallback.onFailure(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("UserLoginManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                accountCallback.onFailure(t);
            }
        });
    }
}
