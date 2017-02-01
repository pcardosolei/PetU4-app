package pet4u.pet4u.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;
import pet4u.pet4u.user.Consulta;

public class Lista_Consultas extends AppCompatActivity {

    //Create Array of Consultas
    List<Consulta> consultas_passadas = new ArrayList<>();
    List<Consulta> consultas_futuras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_consultas);

        // Get Consultas
        getConsultas();


        // Populate List View
        populateListViewPast();

        populateListViewFuture();

        //
    }


    private void getConsultas() {
        //Apagar getSampleConsultas apos ligaçao a base de dados
        getSampleConsultas();
    }

    private void getSampleConsultas() {
        //Consultas passadas


    }

    private void populateListViewFuture() {
    }

    private void populateListViewPast() {
    }

}
