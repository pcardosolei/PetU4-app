package pet4u.pet4u.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;
import pet4u.pet4u.managers.Card;
import pet4u.pet4u.managers.RVAdapter;

public class AnimalActivity extends AppCompatActivity {
    TextView display_nome;
    TextView display_nascimento;
    TextView display_genero;
    TextView display_peso;
    TextView display_porte;
    TextView display_raca;
    TextView display_historico;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        display_nome = (TextView)findViewById(R.id.tv_display_nome);
        display_nascimento = (TextView)findViewById(R.id.tv_display_nascimento);
        display_genero = (TextView)findViewById(R.id.tv_display_genero);
        display_peso = (TextView)findViewById(R.id.tv_display_peso);
        display_porte = (TextView)findViewById(R.id.tv_display_porte);
        display_raca = (TextView)findViewById(R.id.tv_display_raca);
        display_historico = (TextView)findViewById(R.id.tv_eventos);

        rv = (RecyclerView)findViewById(R.id.rv);


        //TODO : Carregar os dados do animal
        display_nome.setText("Bobby");
        display_nascimento.setText("20/02/2012");
        display_genero.setText("Macho");
        display_peso.setText("100 kg");
        display_porte.setText("Grande");
        display_raca.setText("Bulldog");

        display_historico.setText("Últimos eventos do " + "Bobby");

        // Carregar eventos para as cards:
        //rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Consulta", "30/01/2017", R.drawable.ic_today_black_24dp));
        cards.add(new Card("Vacina", "25/01/2017", R.drawable.ic_colorize_black_24dp));
        cards.add(new Card("Desparasitação", "20/01/2017", R.drawable.ic_local_hospital_black_24dp));
        cards.add(new Card("Consulta", "15/01/2017", R.drawable.ic_today_black_24dp));
        cards.add(new Card("Vacina", "10/01/2017", R.drawable.ic_colorize_black_24dp));
        cards.add(new Card("Desparasitação", "05/01/2017", R.drawable.ic_local_hospital_black_24dp));
        cards.add(new Card("Desparasitação", "05/01/2017", R.drawable.ic_local_hospital_black_24dp));

        RVAdapter adapter = new RVAdapter(cards);
        rv.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.edit_info);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
