package pet4u.pet4u.managers;

import android.util.Log;

import pet4u.pet4u.AppProperties;
import pet4u.pet4u.callbacks.AccountCallback;
import pet4u.pet4u.callbacks.ClientCallback;
import pet4u.pet4u.services.ClientService;
import pet4u.pet4u.user.Account;
import pet4u.pet4u.UserToken;
import pet4u.pet4u.services.AccountService;
import pet4u.pet4u.user.Address;
import pet4u.pet4u.user.Client;
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
    private Client client;
    private Address address;


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

    public synchronized void getCliente(final ClientCallback clientCallback, int id){
        client = new Client();
        Retrofit retrofit;
        ClientService clientService;

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppProperties.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            clientService = retrofit.create(ClientService.class);
        }catch  (Exception e) {
            Log.e("UserManager->", "constructor->source.getBytes('UTF-8') ERROR: " + e);
            return;
        }

        //System.out.println("System TOKEN: " + "Bearer " +  userToken.getAccessToken());
        Call<Client> call = clientService.getCliente("Bearer " + userToken.getAccessToken(), id);

        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                Log.i("UserLoginManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                client = response.body();

                int code = response.code();
                System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    clientCallback.onSuccessCliente(client);
                } else {
                    clientCallback.onFailureCliente(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("UserLoginManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                clientCallback.onFailureCliente(t);
            }
        });

    }


    /*public synchronized void getAddress(final AddressCallback addressCallback){
        address = new Address();
        Retrofit retrofit;
        AddressService addressService;

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppProperties.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            addressService = retrofit.create(AddressService.class);
        }catch  (Exception e) {
            Log.e("UserManager", "constructor->source.getBytes('UTF-8') ERROR: " + e);
            return;
        }

        //System.out.println("System TOKEN: " + "Bearer " +  userToken.getAccessToken());
        Call<Address> call = addressService.getAdress("Bearer " + userToken.getAccessToken(), client.getId());  // TODO: 31/01/2017  TA MAAAALLL

        call.enqueue(new Callback<Address>() {
            @Override
            public void onResponse(Call<Address> call, Response<Address> response) {
                Log.i("UserLoginManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                address = response.body();

                int code = response.code();
                System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    addressCallback.onSuccessAddress(address);
                } else {
                    addressCallback.onFailureAddress(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Address> call, Throwable t) {
                Log.e("UserLoginManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                addressCallback.onFailureAddress(t);
            }
        });
    }*/

    public synchronized void getAccount(final AccountCallback accountCallback) {
        account = new Account();
        Retrofit retrofit;
        AccountService getAccServ;

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppProperties.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            getAccServ = retrofit.create(AccountService.class);
        }catch  (Exception e) {
            Log.e("UserTokenManager->", "constructor->source.getBytes('UTF-8') ERROR: " + e);
            return;
        }

        //System.out.println("System TOKEN: " + "Bearer " +  userToken.getAccessToken());
        Call<Account> call = getAccServ.getAccount("Bearer " + userToken.getAccessToken());

        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                Log.i("UserManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                account = response.body();

                int code = response.code();
                System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    accountCallback.onSuccessGetAccount(account);
                } else {
                    accountCallback.onFailureGetAccount(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("UserLoginManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                accountCallback.onFailureGetAccount(t);
            }
        });
    }
}
