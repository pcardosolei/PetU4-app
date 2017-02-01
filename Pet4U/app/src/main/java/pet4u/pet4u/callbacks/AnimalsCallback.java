package pet4u.pet4u.callbacks;

import java.util.ArrayList;

import pet4u.pet4u.user.AnimalDTO;

/**
 * Created by Rafael on 31/01/2017.
 * Package: ${PACKAGE_NAME}.
 * Project: Pet4U.
 */

public interface AnimalsCallback {

    void onSuccessAnimals(ArrayList<AnimalDTO> animals);
    void onFailureAnimals(Throwable t);
}
