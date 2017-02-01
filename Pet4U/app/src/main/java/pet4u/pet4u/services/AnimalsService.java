package pet4u.pet4u.services;

import java.util.ArrayList;

import pet4u.pet4u.user.AnimalDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Rafael on 31/01/2017.
 * Package: ${PACKAGE_NAME}.
 * Project: Pet4U.
 */

public interface AnimalsService {


    @GET("/api/animais/cliente/{clienteId}")
    Call<ArrayList<AnimalDTO>> getAnimals(
            @Header("Authorization") String Authorization,
            @Path("clienteId") int clienteId
    );

}
