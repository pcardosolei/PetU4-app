package pet4u.pet4u.user;

import java.io.Serializable;

/**
 * Created by Rafael on 01/02/2017.
 * Package: pet4u.pet4u.user.
 * Project: Pet4U.
 */


public class FotoDTO implements Serializable {


    private int animalId;
    private int id;
    private String path;

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FotoDTO{" +
                "animalId=" + animalId +
                ", id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
