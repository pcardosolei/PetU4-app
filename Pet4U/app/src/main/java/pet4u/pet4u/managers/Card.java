package pet4u.pet4u.managers;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;

/**
 * Created by andregeraldes on 01/02/17.
 */

public class Card {
    String texto;
    String data;
    int iconId;

    public Card(String texto, String data, int iconId) {
        this.texto = texto;
        this.data = data;
        this.iconId = iconId;
    }
}