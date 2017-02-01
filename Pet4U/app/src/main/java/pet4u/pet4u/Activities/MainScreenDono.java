package pet4u.pet4u.activities;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import pet4u.pet4u.R;

import pet4u.pet4u.callbacks.AnimalsCallback;

import pet4u.pet4u.callbacks.ClientCallback;

import pet4u.pet4u.callbacks.EventosCallback;
import pet4u.pet4u.user.AccountDTO;
import pet4u.pet4u.UserToken;
import pet4u.pet4u.callbacks.AccountCallback;
import pet4u.pet4u.managers.UserManager;
import pet4u.pet4u.user.AddressDTO;
import pet4u.pet4u.user.AnimalDTO;
import pet4u.pet4u.user.ClientDTO;
import pet4u.pet4u.user.EventoDTO;

public class MainScreenDono
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AccountCallback,
        ClientCallback,
        AnimalsCallback,
        EventosCallback{

    private UserManager userManager;
    private UserToken userToken;
    private AccountDTO accountDTO;
    private ClientDTO clientDTO;
    private AddressDTO addressDTO;
    private ArrayList<AnimalDTO> animals;
    private ArrayList<EventoDTO> eventoDTOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen_dono);

        // TODO: 26/01/2017  Tava a dar erro... teve q ser commentado...
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // TODO: 26/01/2017  Tava a dar erro... teve q ser commentado...
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        //toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //display info...

        userToken = (UserToken) getIntent().getSerializableExtra("userToken");

        //ServerHttpClient httpClient = new ServerHttpClient();
        userManager = new UserManager(userToken);

        userManager.getAccount(MainScreenDono.this);



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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // TODO: 30/01/2017 VERIFICAR ESTES 2

    @Override
    public void onSuccessGetAccount(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
        TextView tv = (TextView) findViewById(R.id.tv_nome);
        tv.setText(accountDTO.getFirstName() + " " + accountDTO.getLastName());
        tv = (TextView) findViewById(R.id.tv_email);
        tv.setText(this.accountDTO.getEmail());


        // TODO: 31/01/2017 Teste, remover.

        System.out.println("\n\nTest AccountDTO:\n" + accountDTO.toString()+ "\n\n");


        userManager.getCliente(MainScreenDono.this, accountDTO.getClienteId());

    }

    @Override
    public void onFailureGetAccount(Throwable t) {
        Log.e("MainScreenDono->", "AccountDTO->onFailure ERROR " + t.getMessage());

        TextView tv = (TextView) findViewById(R.id.tv_nome);
        tv.setText("FAILURE");  // TODO: 01/02/2017  Remove!!!! 

        // TODO: Manage Errors


    }


    @Override
    public void onSuccessCliente(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
        this.addressDTO = clientDTO.getMoradaDTO();

        userManager.getAnimals(MainScreenDono.this, clientDTO.getId());

        // TODO: 31/01/2017 Teste, remover.
        System.out.println("\n\nTest ClientDTO:\n" + clientDTO.toString()+ "\n\n");
    }

    @Override
    public void onFailureCliente(Throwable t) {
        Log.e("MainScreenDono->", "ClientDTO->onFailure ERROR " + t.getMessage());

        // TODO: 31/01/2017 check errors 
    }

    @Override
    public void onSuccessAnimals(ArrayList<AnimalDTO> animals) {
        this.animals = animals;

        System.out.println("\n\nTest Animals:\n" + animals.toString()+ "\n\n");

        userManager.getEventos(MainScreenDono.this, animals.get(0).getId());

        System.out.println("Test Animal Foto: " + animals.get(0).getFotos().get(0).getPath());
    }

    @Override
    public void onFailureAnimals(Throwable t) {
        Log.e("MainScreenDono->", "Animals->onFailure ERROR " + t.getMessage());
    }

    @Override
    public void onSuccessEventos(ArrayList<EventoDTO> eventos) {
        eventoDTOs = eventos;

        System.out.println("\n\nTest Eventos:\n" + eventos.toString()+ "\n\n");


    }

    @Override
    public void onFailureEventos(Throwable t) {
        Log.e("MainScreenDono->", "Eventos->onFailure ERROR " + t.getMessage());
    }
}
