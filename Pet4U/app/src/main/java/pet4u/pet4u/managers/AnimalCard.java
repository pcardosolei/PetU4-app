package pet4u.pet4u.managers;

import android.graphics.drawable.Drawable;

/**
 * Created by Rafael on 06/02/2017.
 */

public class AnimalCard {

    public String nome;
    public Drawable drawable;
    public int animal;

    public AnimalCard(String nome, Drawable drawable, int animal) {
            this.nome = nome;
            this.drawable = drawable;
            this.animal = animal;
    }

    public int getAnimal() {
        return animal;
    }
}