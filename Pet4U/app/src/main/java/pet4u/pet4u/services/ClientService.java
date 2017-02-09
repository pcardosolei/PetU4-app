package pet4u.pet4u.services;

import pet4u.pet4u.user.ClientDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Rafael on 31/01/2017.
 * Package: ${PACKAGE_NAME}.
 * Project: Pet4U.
 */

public interface ClientService {

    @GET("/api/clientes/{id}")
    Call<ClientDTO> getCliente(
            @Header("Authorization") String Authorization,
            @Path("id") int id
    );


    @PUT("/api/clientes")
    Call<Void> updateClient(
            @Header("Authorization") String Authorization,
            @Body ClientDTO clienteDTO
    );

}
