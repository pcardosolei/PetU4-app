package pet4u.pet4u.managers;

import android.util.Log;

import java.util.ArrayList;

import pet4u.pet4u.AppProperties;
import pet4u.pet4u.callbacks.AccountCallback;

import pet4u.pet4u.callbacks.AnimalsCallback;
import pet4u.pet4u.callbacks.ClientCallback;
import pet4u.pet4u.callbacks.EventosCallback;
import pet4u.pet4u.services.AnimalsService;

import pet4u.pet4u.services.ClientService;
import pet4u.pet4u.services.EventosService;
import pet4u.pet4u.user.AccountDTO;
import pet4u.pet4u.UserToken;
import pet4u.pet4u.services.AccountService;
import pet4u.pet4u.user.AnimalDTO;
import pet4u.pet4u.user.ClientDTO;
import pet4u.pet4u.user.EventoDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael on 30/01/2017.
 * Package: ${PACKAGE_NAME}.
 * Project: Pet4U.
 */

public class UserManager {
    private static UserManager ourInstance;
    private UserToken userToken;
    private AccountDTO accountDTO;
    private ClientDTO clientDTO;
    private ArrayList<AnimalDTO> animals;
    private ArrayList<EventoDTO> eventos;


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


    public synchronized void getEventos(final EventosCallback eventosCallback, int animalID){
        eventos = new ArrayList<>();
        Retrofit retrofit;
        EventosService eventosService;

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppProperties.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            eventosService = retrofit.create(EventosService.class);
        }catch  (Exception e) {
            Log.e("UserManager->", "constructor->source.getBytes('UTF-8') ERROR: " + e);
            return;
        }

        //System.out.println("System TOKEN: " + "Bearer " +  userToken.getAccessToken());
        Call<ArrayList<EventoDTO>> call = eventosService.getEventos("Bearer " + userToken.getAccessToken(), animalID);

        call.enqueue(new Callback<ArrayList<EventoDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<EventoDTO>> call, Response<ArrayList<EventoDTO>> response) {
                Log.i("UserManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                eventos = response.body();

                int code = response.code();
                //System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    eventosCallback.onSuccessEventos(eventos);
                } else {
                    eventosCallback.onFailureEventos(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EventoDTO>> call, Throwable t) {
                Log.e("UserLoginManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                eventosCallback.onFailureEventos(t);
            }
        });
    }


    public synchronized void getCliente(final ClientCallback clientCallback, int accountID){
        clientDTO = new ClientDTO();
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
        Call<ClientDTO> call = clientService.getCliente("Bearer " + userToken.getAccessToken(), accountID);

        call.enqueue(new Callback<ClientDTO>() {
            @Override
            public void onResponse(Call<ClientDTO> call, Response<ClientDTO> response) {
                Log.i("UserLoginManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                clientDTO = response.body();

                int code = response.code();
                //System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    clientCallback.onSuccessCliente(clientDTO);
                } else {
                    clientCallback.onFailureCliente(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<ClientDTO> call, Throwable t) {
                Log.e("UserManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                clientCallback.onFailureCliente(t);
            }
        });

    }


    public synchronized void getAnimals(final AnimalsCallback animalsCallback, int id){
        animals = new ArrayList<>();
        Retrofit retrofit;
        AnimalsService animalsService;

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppProperties.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            animalsService = retrofit.create(AnimalsService.class);
        }catch  (Exception e) {
            Log.e("UserManager", "constructor->source.getBytes('UTF-8') ERROR: " + e);
            return;
        }

        //System.out.println("System TOKEN: " + "Bearer " +  userToken.getAccessToken());
        Call<ArrayList<AnimalDTO>> call = animalsService.getAnimals("Bearer " + userToken.getAccessToken(), id);

        call.enqueue(new Callback<ArrayList<AnimalDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<AnimalDTO>> call, Response<ArrayList<AnimalDTO>> response) {
                Log.i("UserLoginManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                animals = response.body();

                int code = response.code();
                //System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    animalsCallback.onSuccessAnimals(animals);
                } else {
                    animalsCallback.onFailureAnimals(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AnimalDTO>> call, Throwable t) {
                Log.e("UserManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                animalsCallback.onFailureAnimals(t);
            }
        });
    }

    public synchronized void getAccount(final AccountCallback accountCallback) {
        accountDTO = new AccountDTO();
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
        Call<AccountDTO> call = getAccServ.getAccount("Bearer " + userToken.getAccessToken());

        call.enqueue(new Callback<AccountDTO>() {
            @Override
            public void onResponse(Call<AccountDTO> call, Response<AccountDTO> response) {
                Log.i("UserManager ", " performtaks->call.enqueue->onResponse res: " + response.body());
                accountDTO = response.body();

                int code = response.code();
                //System.out.println("RESPONSE: " + response.toString());

                //System.out.println(response.toString());

                if (code == 200 || code == 201) {
                    //bearerToken = "Bearer " + userToken.getAccessToken();
                    accountCallback.onSuccessGetAccount(accountDTO);
                } else {
                    accountCallback.onFailureGetAccount(new Throwable("ERROR " + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<AccountDTO> call, Throwable t) {
                Log.e("UserManager ", " performtaks->call.enqueue->onResponse err: " + t.toString());
                accountCallback.onFailureGetAccount(t);
            }
        });
    }
}
