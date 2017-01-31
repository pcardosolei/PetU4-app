package pet4u.pet4u.services;

import pet4u.pet4u.user.Account;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


/**
 * Created by Rafael on 30/01/2017.
 */

public interface AccountService {
    @GET("/api/account")
    Call<Account> getAccount(
            @Header("Authorization") String Authorization
    );
}
