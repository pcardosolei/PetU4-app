package pet4u.pet4u.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import pet4u.pet4u.R;
import pet4u.pet4u.ViewTypes;
import pet4u.pet4u.callbacks.AnimalsCallback;
import pet4u.pet4u.callbacks.ClientCallback;
import pet4u.pet4u.callbacks.ConsultaCallback;
import pet4u.pet4u.callbacks.EventosCallback;
import pet4u.pet4u.managers.AnimalCard;
import pet4u.pet4u.managers.Card;
import pet4u.pet4u.managers.DownloadImageTask;
import pet4u.pet4u.managers.RVAdapter;
import pet4u.pet4u.managers.RVAdapterAnimal;
import pet4u.pet4u.user.AccountDTO;
import pet4u.pet4u.managers.UserToken;
import pet4u.pet4u.callbacks.AccountCallback;
import pet4u.pet4u.managers.UserManager;
import pet4u.pet4u.user.AddressDTO;
import pet4u.pet4u.user.AnimalDTO;
import pet4u.pet4u.user.ClientDTO;
import pet4u.pet4u.user.ConsultaDTO;
import pet4u.pet4u.user.EventoDTO;
import pet4u.pet4u.user.FotoDTO;
import pet4u.pet4u.user.RecyclerViewClickListener;
import pet4u.pet4u.user.RecyclerViewClickListenerAnimal;

import static android.R.attr.type;

public class MainScreenDono
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AccountCallback,
        ClientCallback,
        AnimalsCallback,
        EventosCallback,
        RecyclerViewClickListener,
        RecyclerViewClickListenerAnimal,
        ConsultaCallback{


    private UserManager userManager;
    private UserToken userToken;
    private AccountDTO accountDTO;
    private ClientDTO clientDTO;
    private AddressDTO addressDTO;
    private ArrayList<AnimalDTO> animals;
    private ArrayList<EventoDTO> eventoDTOs;
    private ArrayList<AnimalCard> animalCards;
    private ArrayList<Card> eventoCards;
    private RVAdapterAnimal animalAdapter;
    private RVAdapter eventosAdapters;
    private Drawable catDrawable;
    private Drawable dogDrawable;

    RecyclerView rv_animais;
    RecyclerView rv_eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_dono);

        // TODO: 26/01/2017  Tava a dar erro... teve q ser commentado...
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pet4U");

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // TODO: 26/01/2017  Tava a dar erro... teve q ser commentado...
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //permissões para ir à net...
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        //display info...

        displayInfo();

    }

    private void displayInfo() {

        catDrawable = ContextCompat.getDrawable(MainScreenDono.this, R.drawable.cat_icon_black);
        dogDrawable = ContextCompat.getDrawable(MainScreenDono.this, R.drawable.dog_icon);


        rv_animais = (RecyclerView)findViewById(R.id.rv_animais);
        rv_eventos = (RecyclerView)findViewById(R.id.rv_eventos);


        // Carregar eventos para as animalCards:
        //rv_animais.setHasFixedSize(true);
        //rv_eventos.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv_eventos.setLayoutManager(llm);


        // animalCards.add(new AnimalCard("Bobby", R.drawable.dog_icon));
        //animalCards.add(new AnimalCard("Pantufa", R.drawable.cat_icon_black));
        //animalCards.add(new AnimalCard("Tigrinha",R.drawable.cat_icon_black));
        // animalCards.add(new AnimalCard("Riscas",R.drawable.cat_icon_black));


        eventoCards = new ArrayList<>();
        eventoCards.add(new Card("Consulta","10/10/2010",R.drawable.ic_today_black_24dp, 0));
        eventoCards.add(new Card("Vacina","10/10/2010", R.drawable.ic_colorize_black_24dp, 1));
        eventoCards.add(new Card("Desparasitação", "05/01/2017", R.drawable.ic_local_hospital_black_24dp, 2));
        eventoCards.add(new Card("Desparasitação", "04/01/2017", R.drawable.ic_local_hospital_black_24dp, 3));



        eventosAdapters = new RVAdapter(MainScreenDono.this, this, eventoCards);
        rv_eventos.setAdapter(eventosAdapters);

        //System.out.println("ANTES\n");
        userToken = (UserToken) getIntent().getSerializableExtra("userToken");
        //System.out.println("MEIO\n");
        userManager = new UserManager(userToken);
        //System.out.println("MEIO222\n");
        userManager.getAccount(MainScreenDono.this);
        //System.out.println("FIM\n");

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen_dono, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainScreenDono.this);
        AlertDialog alertDialog;
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                // TODO: 04/02/2017  
                // User chose the "Settings" item, show the app settings UI...

                // set dialog message
                alertDialogBuilder.setMessage("Feature is still in development...");

                // create alert dialog
                alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();

                //Snackbar.make(CoordinatorLayout , "In Development...",
                //        Snackbar.LENGTH_LONG).setAction("Action", null).show();
                return true;

            case R.id.action_addAnimal:
                // TODO: 04/02/2017

                // set dialog message
                alertDialogBuilder.setMessage("Feature is still in development...");

                // create alert dialog
                alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
                
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case (R.id.nav_camera):
                break;
            case (R.id.nav_gallery):
                break;
            case (R.id.nav_slideshow):
                break;
            case (R.id.nav_manage):
                break;
            case (R.id.nav_share):
                break;
            case (R.id.nav_send):
                break;
            default:

        }

        // TODO: 04/02/2017
        // User chose the "Settings" item, show the app settings UI...
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainScreenDono.this);
        AlertDialog alertDialog;
        // set dialog message
        alertDialogBuilder.setMessage("Feature is still in development...");

        // create alert dialog
        alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // TODO: 30/01/2017 VERIFICAR ESTES 2

    @Override
    public void onSuccessGetAccount(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
        //TextView tv = (TextView) findViewById(R.id.tv_nome);
        //tv.setText(accountDTO.getFirstName() + " " + accountDTO.getLastName());
        //tv = (TextView) findViewById(R.id.tv_email);
        //tv.setText(this.accountDTO.getEmail());


        //System.out.println("\n\nTest AccountDTO:\n" + accountDTO.toString()+ "\n\n");


        userManager.getCliente(MainScreenDono.this, accountDTO.getClienteId());

    }

    @Override
    public void onFailureGetAccount(Throwable t) {
        Log.e("MainScreenDono->", "AccountDTO->onFailure ERROR " + t.getMessage());

        // TODO: Manage Errors
    }

    @Override
    public void onSuccessCliente(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
        this.addressDTO = clientDTO.getMoradaDTO();

        TextView tv = (TextView) findViewById(R.id.tv_display_nome);
        tv.setText(this.clientDTO.getNome());

        try {
            String fotoPath = clientDTO.getFoto();
            ImageView im = (ImageView) findViewById(R.id.im_fotoPerfil);
            new DownloadImageTask(im).execute(fotoPath);
        }catch (Exception e){
            Log.e("MainScreenDono", "Foto fail, probably has none: " + e.getMessage());
            //e.printStackTrace();
        }

        // TODO: 31/01/2017 Teste, remover.
        System.out.println("\n\nTest ClientDTO:\n" + clientDTO.toString()+ "\n\n");
        userManager.getAnimals(MainScreenDono.this, clientDTO.getId());
    }

    @Override
    public void onFailureCliente(Throwable t) {
        Log.e("MainScreenDono->", "ClientDTO->onFailure ERROR " + t.getMessage());

        // TODO: 31/01/2017 check errors 
    }

    @Override
    public void onSuccessAnimals(ArrayList<AnimalDTO> animals) {
        this.animals = animals;

        AnimalDTO ani = this.animals.get(0);
        userManager.getEventos(MainScreenDono.this, ani.getId());

        System.out.println("\n\nTest Animals:\n" + animals.toString()+ "\n\n");

        //userManager.getEventosAnimal(MainScreenDono.this, animals.get(0).getId());
        //System.out.println("Test Animal Foto: " + animals.get(0).getFotos().get(0).getPath());

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
                    Log.e("MainScreenDono", "Photo fail: pet \""+animal.getNome()+"\" bad/missread url: " + e1.getMessage());
                    e1.printStackTrace();
                    d=dogDrawable;
                }
                animalCards.add(new AnimalCard(animal.getNome(), d, animal.getId()));
            }else{
                switch (animal.getTipo()){ // TODO: 06/02/2017 acrescentar icons nos casos de falha
                    case("Gato"):
                        animalCards.add(new AnimalCard(animal.getNome(), catDrawable, animal.getId()));
                        break;
                    case("Cão"):
                        animalCards.add(new AnimalCard(animal.getNome(), dogDrawable, animal.getId()));
                        break;
                    default:
                }
            }
        }
        System.out.println("Animal cards tem: "+ animalCards.size()+" cards\n"+animalCards.toString());
        animalAdapter = new RVAdapterAnimal(MainScreenDono.this, this, animalCards);
        rv_animais.setAdapter(animalAdapter);
    }

    public static Drawable drawableFromUrl(String url) throws IOException {
        Bitmap x;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(x);
    }

    @Override
    public void onFailureAnimals(Throwable t) {
        Log.e("MainScreenDono->", "Animals->onFailure ERROR " + t.getMessage());
    }

    @Override
    public void onSuccessEventos(ArrayList<EventoDTO> eventos) {
        eventoDTOs = eventos;

        System.out.println("\n\nTest Eventos:\n" + eventos.toString()+ "\n\n");


        for(EventoDTO event : eventoDTOs){
            userManager.getConsulta(MainScreenDono.this, event.getConsultaId());

        }

    }

    @Override
    public void onFailureEventos(Throwable t) {
        Log.e("MainScreenDono->", "Eventos->onFailure ERROR " + t.getMessage());
    }

    public void goToUserProfile( View view){
        Intent intent = new Intent(MainScreenDono.this, UserProfileActivity.class);
        if(accountDTO!=null) intent.putExtra("account", accountDTO);
        if(clientDTO!=null) intent.putExtra("client", clientDTO);
        if(animals!=null) intent.putExtra("animals", animals);
        if(userManager!=null) intent.putExtra("userManager", userManager);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayInfo();
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {
        EventoDTO evento;


        try {
            for(EventoDTO e : this.eventoDTOs) {

                if (e.getId() == eventoCards.get(position).getEventid()) {
                    evento = e;

                    Intent intent = new Intent(MainScreenDono.this, EventoActivity.class);
                    intent.putExtra("evento", evento);
                    startActivity(intent);
                }
            }
            } catch (Exception exeption) {
                Toast.makeText(MainScreenDono.this, "Pedimos desculpa mas não é possivel apresentar o evento.", Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    public void recyclerViewListClickedAnimal(View v, int position) {
        AnimalDTO animal;


        try {
            for (AnimalDTO a : this.animals) {
                if (a.getId() == animalCards.get(position).getAnimal()) {
                    animal = a;

                    Intent intent = new Intent(MainScreenDono.this, AnimalActivity.class);
                    intent.putExtra("animal", animal);
                    intent.putExtra("userManager", userManager);
                    startActivity(intent);
                }
            }
        } catch (Exception exeption) {
            Toast.makeText(MainScreenDono.this, "Pedimos desculpa mas não é possivel apresentar o animal.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSuccessConsulta(ConsultaDTO consultaDTO) {
        for(EventoDTO event : eventoDTOs){
            if(event.getConsultaId() == consultaDTO.getId()) event.setConsultaDTO(consultaDTO);
        }
    }

    @Override
    public void onFailureConsulta(Throwable t) {
        Log.e("MainScreenDono->", "Consulta->onFailure ERROR " + t.getMessage());

    }
}

