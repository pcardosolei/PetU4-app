package pet4u.pet4u.services;

import pet4u.pet4u.user.RegisterCliente;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Tania on 28/04/2016.
 */

public interface RegisterService {
    @POST("/api/register/cliente")
    Call<Void> registerAccount(
            @Body RegisterCliente registerCliente
    );

}