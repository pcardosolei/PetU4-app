package pet4u.pet4u.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;

import static pet4u.pet4u.R.id.rv;

public class EventoActivity extends AppCompatActivity {


    TextView clinica;
    TextView date;
    TextView consulta;

    RecyclerView rv_eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);


        clinica = (TextView)  findViewById(R.id.tv_clinica);
        date = (TextView) findViewById(R.id.event_date);
        consulta = (TextView) findViewById(R.id.evento_consulta);
        rv_eventos = (RecyclerView)findViewById(R.id.rv_eventos);

        consulta.setMovementMethod(new ScrollingMovementMethod());


        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv_eventos.setLayoutManager(llm);

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Tetano", "Vacina", R.drawable.ic_colorize_black_24dp));
        cards.add(new Card("Desparasitação", "Desparasitação", R.drawable.ic_local_hospital_black_24dp));
        cards.add(new Card("Raiva", "Vacina", R.drawable.ic_colorize_black_24dp));


        RVAdapter adapter = new RVAdapter(cards);
        rv_eventos.setAdapter(adapter);
    }
}
