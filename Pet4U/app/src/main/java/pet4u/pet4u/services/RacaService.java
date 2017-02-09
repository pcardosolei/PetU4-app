package pet4u.pet4u.services;

import java.util.ArrayList;

import pet4u.pet4u.user.AccountDTO;
import pet4u.pet4u.user.RacaDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by Rafael on 01/02/2017.
 * Pet4U
 */

public interface RacaService {

    @GET("/api/racas/{racaID}")
    Call<AccountDTO> getRaca(
            @Header("Authorization") String Authorization,
            @Path("racaID") int racaID
    );

    @GET("/api/racas")
    Call<ArrayList<RacaDTO>> getAllRacas(
            @Header("Authorization") String Authorization
    );
}
