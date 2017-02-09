package pet4u.pet4u.managers;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;
import pet4u.pet4u.user.EventoDTO;

/**
 * Created by andregeraldes on 01/02/17.
 */

public class Card {
    String texto;
    String data;
    int iconId;
    int eventid;




    public Card(String texto, String data, int iconId, int eventid) {
        this.texto = texto;
        this.data = data;
        this.iconId = iconId;
        this.eventid = eventid;


    }



    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }
}