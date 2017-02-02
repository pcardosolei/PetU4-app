package pet4u.pet4u.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pet4u.pet4u.R;
import pet4u.pet4u.callbacks.EventosCallback;
import pet4u.pet4u.managers.UserManager;
import pet4u.pet4u.user.AnimalDTO;
import pet4u.pet4u.user.ClientDTO;
import pet4u.pet4u.user.DateConverter;
import pet4u.pet4u.user.EventoDTO;
import pet4u.pet4u.user.Vacina;
import pet4u.pet4u.user.VacinaDTO;

public class PlanoVacinacao extends AppCompatActivity implements EventosCallback {

    AnimalDTO animal;
    UserManager user;

    List<Vacina> vacinas= new ArrayList<Vacina>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plano_vacinacao);

        //Get User and animal
        getIntent();


        // GET ARRAY OF Vacinas
        //getVacinas();



        populate_ListView();

        //Update vaccines counter



        TextView missing_Vaccines = (TextView) this.findViewById(R.id.n_missing_vaccines);
        missing_Vaccines.setText(""+vacinas.size());

        if (vacinas.size()>0) {
            TextView missing_Vaccines_text = (TextView) this.findViewById(R.id.n_missing_vaccines_text);
            missing_Vaccines_text.setText("Vacina\\s nao tomadas");

        }


    }
    //Get Vaccine list from DB
    private void getVacinas() {
        user.getEventos(PlanoVacinacao.this, animal.getId());

    }


    private void populate_ListView() {
        // Create list of items
        //test
        /*
        vacinas.add(new Vacina(1, new Date(2017-1900,10,2), "Tetano"));
        vacinas.add(new Vacina(2, new Date(2016-1900,10,2), "Raiva"));
        vacinas.add(new Vacina(3, new Date(2018-1900,10,2), "Tetano"));
        vacinas.add(new Vacina(4, new Date(2017-1900,2,2), "Tetano"));
        vacinas.add(new Vacina(5, new Date(2016-1900,1,2), "Raiva"));
        vacinas.add(new Vacina(6, new Date(2018-1900,12,2), "Tetano"));
        vacinas.add(new Vacina(7, new Date(2017-1900,7,2), "Tetano"));
        vacinas.add(new Vacina(8, new Date(2016-1900,3,2), "Raiva"));
        vacinas.add(new Vacina(9, new Date(2018-1900,9,2), "Tetano"));
        vacinas.add(new Vacina(11, new Date(2017-1900,2,2), "Tetano"));
        vacinas.add(new Vacina(212, new Date(2016-1900,9,2), "Raiva"));
        vacinas.add(new Vacina(32, new Date(2018-1900,1,2), "Tetano"));
        */
        //Oreder Vaccines

        Collections.sort(vacinas);

        //Build adapter
        ArrayAdapter<Vacina> adapter = new VacinaListAdapter();


        //coonfigure list view
        ListView list = (ListView) findViewById(R.id.vaccines);
        list.setAdapter(adapter);
    }

    @Override
    public void onSuccessEventos(ArrayList<EventoDTO> eventos) {
        List<VacinaDTO> vac;

        for ( EventoDTO evento : eventos) {

            vac = evento.getVacinasDTO();

            for (VacinaDTO v : vac ) {
                vacinas.add(new Vacina(v, DateConverter.stringToDate(evento.getData())));
            }
        }
    }

    @Override
    public void onFailureEventos(Throwable t) {
        Log.e("PlanoVacinacao->", "EventoDTO->onFailure ERROR " + t.getMessage());
    }

    private class VacinaListAdapter extends ArrayAdapter<Vacina> {

        public VacinaListAdapter() {
            super(PlanoVacinacao.this, R.layout.listview_vacina, vacinas);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View listview_vacina = convertView;

            //make shure the view is created
            if (listview_vacina == null) {
                listview_vacina = getLayoutInflater().inflate(R.layout.listview_vacina, parent, false);
            }

            //Get Vacine

            Vacina curr_vacina = vacinas.get(position);

            //Fill View
            TextView vacine_name = (TextView) listview_vacina.findViewById(R.id.item_VacineName);
            vacine_name.setText(curr_vacina.getNome());

            TextView vacine_date = (TextView) listview_vacina.findViewById(R.id.item_VacineDate);
            Date date = curr_vacina.getDate();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            vacine_date.setText(format.format(date));


            return listview_vacina;
        }
    }
}
