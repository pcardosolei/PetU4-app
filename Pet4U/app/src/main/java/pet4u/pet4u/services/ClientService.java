package pet4u.pet4u.services;

import pet4u.pet4u.user.Client;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Rafael on 31/01/2017.
 */

public interface ClientService {

    @GET("/api/clientes/{id}")
    Call<Client> getCliente(
            @Header("Authorization") String Authorization,
            @Path("id") int id
    );

}
