package pet4u.pet4u.managers;

import android.graphics.drawable.Drawable;

/**
 * Created by Rafael on 06/02/2017.
 */

public class AnimalCard {

    public String nome;
    public Drawable drawable;

    public AnimalCard(String nome, Drawable drawable) {
            this.nome = nome;
            this.drawable = drawable;
    }
}