package pet4u.pet4u.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;
import pet4u.pet4u.ViewTypes;
import pet4u.pet4u.user.DesparasitacaoDTO;
import pet4u.pet4u.user.EventoDTO;
import pet4u.pet4u.user.RecyclerViewClickListener;
import pet4u.pet4u.user.VacinaDTO;

import static pet4u.pet4u.R.id.rv;
import static pet4u.pet4u.R.id.vaccines;
import pet4u.pet4u.managers.Card;
import pet4u.pet4u.managers.RVAdapter;


public class EventoActivity extends AppCompatActivity implements RecyclerViewClickListener{


    TextView clinica;
    TextView date;
    TextView consulta;

    RecyclerView rv_eventos;

    EventoDTO evento;

    List<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);


        evento = (EventoDTO) getIntent().getSerializableExtra("evento");


        clinica = (TextView)  findViewById(R.id.tv_clinica);
        date = (TextView) findViewById(R.id.event_date);
        consulta = (TextView) findViewById(R.id.evento_consulta);
        rv_eventos = (RecyclerView)findViewById(R.id.rv_eventos);


        clinica.setText(evento.getClinicaDTO().getNome());
        date.setText(evento.getData());
        try {
            consulta.setText(evento.getConsultaDTO().getDescricao());
        } catch (Exception exeption){
            consulta.setText("Não é possivel apresentar esta informação");
        }

        getEventoContents(evento);


        consulta.setMovementMethod(new ScrollingMovementMethod());


        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv_eventos.setLayoutManager(llm);


        RVAdapter adapter = new RVAdapter(EventoActivity.this,this,cards);
        rv_eventos.setAdapter(adapter);
    }



    private void getEventoContents(EventoDTO evento) {
        for (VacinaDTO v : evento.getVacinasDTO()) {
            cards.add(new Card(v.getNome(), getResources().getString(R.string.Vaccine), R.drawable.ic_colorize_black_24dp,0));
        }
        for (DesparasitacaoDTO d : evento.getDesparasitacoesDTO()) {
            cards.add(new Card(d.getTipo(), getResources().getString(R.string.Deworming),  R.drawable.ic_local_hospital_black_24dp,0));
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {

    }
}
