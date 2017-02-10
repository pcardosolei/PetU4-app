package pet4u.pet4u.callbacks;

import pet4u.pet4u.user.AnimalDTO;

/**
 * Created by Rafael on 09/02/2017.
 */

public interface NewAnimalCallback {
    void onSuccessAnimals(AnimalDTO animal);
    void onFailureAnimals(Throwable t);
}
