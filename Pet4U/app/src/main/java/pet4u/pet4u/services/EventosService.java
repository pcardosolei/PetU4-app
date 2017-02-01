package pet4u.pet4u.services;

import java.util.ArrayList;

import pet4u.pet4u.user.EventoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Rafael on 01/02/2017.
 */

public interface EventosService {

    @GET("/api/evento/vacinas/animal/{animalId}")
    Call<ArrayList<EventoDTO>> getEventos(
            @Header("Authorization") String Authorization,
            @Path("animalId") int animalId
    );

}
