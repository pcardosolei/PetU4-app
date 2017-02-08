package pet4u.pet4u.services;

import pet4u.pet4u.user.ConsultaDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Rafael on 08/02/2017.
 * Package: pet4u.pet4u.services.
 * Project: Pet4U.
 */

public interface ConsultaService {

    @GET("/api/consultas/{id}")
    Call<ConsultaDTO> getConsulta(
            @Header("Authorization") String Authorization,
            @Path("id") int id
    );

}
