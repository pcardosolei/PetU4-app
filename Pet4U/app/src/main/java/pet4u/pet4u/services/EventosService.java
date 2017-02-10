package pet4u.pet4u.services;

import java.util.ArrayList;

import pet4u.pet4u.user.EventoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Rafael on 30/01/2017.
 * Package: pet4u.pet4u.services.
 * Project: Pet4U.
 */

public interface EventosService {

    @GET("/api/evento/vacinas/animal/{animalId}")
    Call<ArrayList<EventoDTO>> getEventosAnimal(
            @Header("Authorization") String Authorization,
            @Path("animalId") int animalId
    );


    @GET("/api/cliente/eventos/{clienteID}")
    Call<ArrayList<EventoDTO>> getEventosCliente(
            @Header("Authorization") String Authorization,
            @Path("clienteID") int clienteID
    );
}
