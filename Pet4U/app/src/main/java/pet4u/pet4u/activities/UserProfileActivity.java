package pet4u.pet4u.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import pet4u.pet4u.R;
import pet4u.pet4u.managers.AnimalCard;
import pet4u.pet4u.managers.Card;
import pet4u.pet4u.managers.DownloadImageTask;
import pet4u.pet4u.managers.RVAdapter;
import pet4u.pet4u.managers.RVAdapterAnimal;
import pet4u.pet4u.user.AccountDTO;
import pet4u.pet4u.user.AddressDTO;
import pet4u.pet4u.user.AnimalDTO;
import pet4u.pet4u.user.ClientDTO;
import pet4u.pet4u.user.FotoDTO;

public class UserProfileActivity extends AppCompatActivity {
    TextView display_nome;
    TextView display_nascimento;
    TextView display_genero;
    TextView display_morada;
    TextView display_telemovel;
    TextView display_email;
    TextView display_historico;
    ImageView display_fotoPerfil;
    RecyclerView rv_animais;

    private AccountDTO accountDTO;
    private ClientDTO clientDTO;
    private AddressDTO addressDTO;
    private ArrayList<AnimalDTO> animals;
    private RVAdapterAnimal animalAdapter;
    private ArrayList<AnimalCard> animalCards;

    private Drawable catDrawable;
    private Drawable dogDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        display_nome = (TextView)findViewById(R.id.tv_display_nome);
        display_nascimento = (TextView)findViewById(R.id.tv_display_nascimento);
        display_genero = (TextView)findViewById(R.id.tv_display_genero);
        display_morada = (TextView)findViewById(R.id.tv_display_morada);
        display_telemovel = (TextView)findViewById(R.id.tv_display_telemovel);
        display_email = (TextView)findViewById(R.id.tv_display_email);
        display_historico = (TextView)findViewById(R.id.tv_eventos);
        display_fotoPerfil = (ImageView) findViewById(R.id.iv_foto_perfil);




        catDrawable = ContextCompat.getDrawable(UserProfileActivity.this, R.drawable.cat_icon_black);
        dogDrawable = ContextCompat.getDrawable(UserProfileActivity.this, R.drawable.dog_icon);

        rv_animais = (RecyclerView)findViewById(R.id.rv_animais);

        // Carregar eventos para as cards:
        //rv.setHasFixedSize(true);

        Intent intent = getIntent();
        accountDTO = (AccountDTO) intent.getSerializableExtra("account");
        clientDTO = (ClientDTO) intent.getSerializableExtra("client");
        if(clientDTO!=null) addressDTO = clientDTO.getMoradaDTO();
        else Log.e("UserProfileActivity","ClientDTO is null!");
        this.animals = (ArrayList<AnimalDTO>) intent.getSerializableExtra("animals");
        if(animals==null) Log.e("UserProfileActivity","Animal List is null!");


        // display user
        display_nome.setText(clientDTO.getNome());
        display_nascimento.setText(clientDTO.getDataNasc());
        display_genero.setText(clientDTO.getGenero());
        if(addressDTO!=null) display_morada.setText(addressDTO.getMoradaCompleta());
        System.out.println("O TELEMOVEL É: "+clientDTO.getTelemovel());
        display_telemovel.setText(Integer.toString(clientDTO.getTelemovel()));
        display_email.setText(accountDTO.getEmail());


        try {
            String fotoPath = clientDTO.getFoto();
            new DownloadImageTask(display_fotoPerfil).execute(fotoPath);
        }catch (Exception e){
            Log.e("MainScreenDono", "Foto fail in user "+clientDTO.getNome()+", probably has none: " + e.getMessage());
            //e.printStackTrace();
        }



        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv_animais.setLayoutManager(llm);
        animalCards = new ArrayList<>();

        for (AnimalDTO animal : animals){
            if(animal.getPhotoNumber() != 0){
                FotoDTO fotoAux = animal.getFotos().get(0);
                InputStream is = null;
                Drawable d = null;
                try {
                    d = drawableFromUrl(fotoAux.getPath());
                } catch (Exception e1) {
                    Log.e("UserProfileActivity", "Photo fail: pet \""+animal.getNome()+"\" bad/missread url: " + e1.getMessage());
                    e1.printStackTrace();
                    d=dogDrawable;
                }
                animalCards.add(new AnimalCard(animal.getNome(), d));
            }else{
                switch (animal.getTipo()){ // TODO: 06/02/2017 acrescentar icons nos casos de falha
                    case("Gato"):
                        animalCards.add(new AnimalCard(animal.getNome(), catDrawable));
                        break;
                    case("Cão"):
                        animalCards.add(new AnimalCard(animal.getNome(), dogDrawable));
                        break;
                    default:
                }
            }
        }
        System.out.println("Animal cards tem: "+ animalCards.size()+" cards\n"+animalCards.toString());
        animalAdapter = new RVAdapterAnimal(animalCards);
        rv_animais.setAdapter(animalAdapter);



        /*LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Bobby", "", R.drawable.dog_icon));
        cards.add(new Card("Pantufa", "", R.drawable.cat_icon_black));


        RVAdapter adapter = new RVAdapter(cards);
        rv.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.edit_info);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    public static Drawable drawableFromUrl(String url) throws IOException {
        Bitmap x;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(x);
    }
}
