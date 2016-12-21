package pet4u.pet4u.services;


import pet4u.pet4u.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Tania on 28/04/2016.
 */

public interface RegisterService {
    @POST("api/register")
    Call<Void> registerAccount(
            @Body UserDTO userDTO
    );

}