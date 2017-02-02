package pet4u.pet4u.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import pet4u.pet4u.user.Consulta;
import pet4u.pet4u.user.DateConverter;
import pet4u.pet4u.user.EventoDTO;

public class ListaConsultas extends AppCompatActivity implements EventosCallback {

    AnimalDTO animal;
    UserManager user;


    //Create Array of Consultas
    List<Consulta> consultas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consultas);

        //Get User and animal // TODO: 02/02/2017 Acabar
        Intent intent = getIntent();

        // Get Consultas
        //getConsultas();


        // Populate List View
        populate_ListView();



        //
    }


    private void getConsultas() {

        user.getEventos(ListaConsultas.this, animal.getId());
    }

    private void getSampleConsultas() {
        //Consultas passadas


    }


    private void populate_ListView() {

        //sort consultas by date from decending order.
        Collections.sort(consultas);
        Collections.reverse(consultas);

        //Build Adapter
        ArrayAdapter<Consulta> adapter = new ConsultaListAdapter();

        ListView list = (ListView) findViewById(R.id.list_atended_consultas);
        list.setAdapter(adapter);
    }

    @Override
    public void onSuccessEventos(ArrayList<EventoDTO> eventos) {

        for ( EventoDTO evento : eventos) {

            consultas.add(new Consulta(evento.getConsultaDTO(), DateConverter.stringToDate(evento.getData()),evento.getClinicaDTO().getNome()));

        }
    }

    @Override
    public void onFailureEventos(Throwable t) {
        Log.e("ListaConsultas->", "EventoDTO->onFailure ERROR " + t.getMessage());
    }



    private class ConsultaListAdapter extends ArrayAdapter<Consulta> {

        public ConsultaListAdapter() {
            super(ListaConsultas.this, R.layout.listview_consulta, consultas);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View listview_consulta = convertView;

            //make shure the view is created
            if (listview_consulta == null) {
                listview_consulta = getLayoutInflater().inflate(R.layout.listview_consulta, parent, false);
            }

            //get consulta

            Consulta curr_consulta = consultas.get(position);

            //Fill View
            TextView clinica_name = (TextView) listview_consulta.findViewById(R.id.item_clinica);
            clinica_name.setText(curr_consulta.getClinica());

            TextView consulta_date = (TextView) listview_consulta.findViewById(R.id.item_ConsultaDate);
            Date date = curr_consulta.getDate();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            consulta_date.setText(format.format(date));


            return listview_consulta;
        }
    }
}
