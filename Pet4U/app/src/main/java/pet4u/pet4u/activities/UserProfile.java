package pet4u.pet4u.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;

public class UserProfile extends AppCompatActivity {
    TextView display_nome;
    TextView display_nascimento;
    TextView display_genero;
    TextView display_morada;
    TextView display_telemovel;
    TextView display_email;
    TextView display_historico;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        display_nome = (TextView)findViewById(R.id.tv_display_nome);
        display_nascimento = (TextView)findViewById(R.id.tv_display_nascimento);
        display_genero = (TextView)findViewById(R.id.tv_display_genero);
        display_morada = (TextView)findViewById(R.id.tv_display_peso);
        display_telemovel = (TextView)findViewById(R.id.tv_display_porte);
        display_email = (TextView)findViewById(R.id.tv_display_raca);
        display_historico = (TextView)findViewById(R.id.tv_eventos);

        rv = (RecyclerView)findViewById(R.id.rv);

        // Carregar eventos para as cards:
        //rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Bobby", "30/01/2017", R.drawable.dog_icon));
        cards.add(new Card("Pantufa", "25/01/2017", R.drawable.cat_icon_black));


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
