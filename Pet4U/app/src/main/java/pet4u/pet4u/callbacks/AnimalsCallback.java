package pet4u.pet4u.callbacks;

import java.util.ArrayList;

import pet4u.pet4u.user.Animal;

/**
 * Created by Rafael on 31/01/2017.
 */

public interface AnimalsCallback {

    void onSuccessAnimals(ArrayList<Animal> animals);
    void onFailureAnimals(Throwable t);
}
