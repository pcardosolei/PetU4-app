package pet4u.pet4u.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;
import pet4u.pet4u.callbacks.EventosCallback;
import pet4u.pet4u.managers.Card;
import pet4u.pet4u.managers.DownloadImageTask;
import pet4u.pet4u.managers.RVAdapter;
import pet4u.pet4u.managers.UserManager;
import pet4u.pet4u.user.AnimalDTO;
import pet4u.pet4u.user.EventoDTO;

public class AnimalActivity extends AppCompatActivity implements EventosCallback{
    TextView display_nome;
    TextView display_nascimento;
    TextView display_genero;
    TextView display_peso;
    TextView display_porte;
    TextView display_raca;
    TextView display_historico;
    RecyclerView rv;
    ImageView foto_animal;

    ArrayList<EventoDTO> eventos;
    UserManager userManager;
    AnimalDTO animal;

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
        foto_animal =(ImageView) findViewById(R.id.foto_animal);
        rv = (RecyclerView)findViewById(R.id.rv);


        Intent intent = getIntent();
        animal = (AnimalDTO) intent.getSerializableExtra("animal");
        userManager = (UserManager) intent.getSerializableExtra("userManager");


        if(animal == null) Log.e("AnimalActivity","Animal is null!");
        else userManager.getEventos(AnimalActivity.this, animal.getId());

        //TODO : Carregar os dados do animal
        display_nome.setText(animal.getNome());
        display_nascimento.setText(animal.getDataNasc());
        display_genero.setText(animal.getGenero());
        display_peso.setText(""+animal.getPeso()/1000+" Kg");
        //display_porte.setText("Grande");
        display_raca.setText(animal.getRacaNome());

        try {
            String fotoPath = animal.getFotos().get(0).getPath();
            new DownloadImageTask(foto_animal).execute(fotoPath);
        }catch (Exception e){
            Log.e("AnimalActivity", "Foto fail in user "+animal.getNome()+": " + e.getMessage());
            //e.printStackTrace();
        }


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

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.edit_info);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public void onSuccessEventos(ArrayList<EventoDTO> eventos) {
        this.eventos = eventos;
    }

    @Override
    public void onFailureEventos(Throwable t) {
        Log.e("AnimalActivity","Fail abuscar evnetos do animal "+animal.getNome());
    }
}
