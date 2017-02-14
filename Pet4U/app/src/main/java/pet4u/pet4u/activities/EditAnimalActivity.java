package pet4u.pet4u.activities;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import pet4u.pet4u.R;
import pet4u.pet4u.callbacks.NewAnimalCallback;
import pet4u.pet4u.callbacks.RacasAllCallback;
import pet4u.pet4u.managers.UserManager;
import pet4u.pet4u.user.AnimalCreate;
import pet4u.pet4u.user.AnimalDTO;
import pet4u.pet4u.user.ClientDTO;
import pet4u.pet4u.user.RacaDTO;

public class EditAnimalActivity extends AppCompatActivity implements RacasAllCallback, NewAnimalCallback{

    private EditText display_nome;
    private EditText display_dataNasc;
    private Spinner display_genero;
    private Spinner display_tipo;
    private Spinner display_raca;

    private UserManager userManager;
    private AnimalDTO animalDTO;
    private ClientDTO clientDTO;

    private ArrayList<RacaDTO> racas;
    private ArrayList<RacaDTO> racasTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_animal);

        try {
            Intent intent = getIntent();
            userManager = (UserManager) intent.getSerializableExtra("userManager");
            clientDTO = (ClientDTO) intent.getSerializableExtra("client");
        }catch (Exception e){
            Log.e("EditAnimalActivity","Fatal error, info not loaded");
            finish();
        }
        userManager.getAllRaces(EditAnimalActivity.this);


        display_nome = (EditText) findViewById(R.id.et_display_nome);
        display_dataNasc = (EditText) findViewById(R.id.et_display_data_nascimento);
        display_genero = (Spinner) findViewById(R.id.spinner_genero);
        display_tipo = (Spinner) findViewById(R.id.spinner_tipo);
        display_raca = (Spinner) findViewById(R.id.spinner_raca);

        String[] itemsGenero = new String[]{"Masculino", "Feminino"};
        ArrayAdapter<String> adapterGenero = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsGenero);
        display_genero.setAdapter(adapterGenero);

        Button b = (Button) findViewById(R.id.b_save);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAnimal();
            }
        });
    }

    public void saveAnimal(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditAnimalActivity.this);
        AlertDialog alertDialog;

        // set dialog message
        alertDialogBuilder.setMessage("Feature is still in development...");

        // create alert dialog
        alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
/*
        String nome = display_nome.getText().toString();
        String dataNasc = display_dataNasc.getText().toString();
        String tipo = display_tipo.getSelectedItem().toString().toLowerCase();
        String raça = display_raca.getSelectedItem().toString();
        String genero = display_genero.getSelectedItem().toString();


        animalDTO = new AnimalDTO();

        if(!nome.equals("")) animalDTO.setNome(nome);
        if(!dataNasc.equals("")) animalDTO.setDataNasc(dataNasc);
        if(!tipo.equals("")) animalDTO.setTipo(tipo);
        if(!raça.equals("")) animalDTO.setRacaNome(raça);
        animalDTO.setRacaId(getRaca(raça).getId());
        if(!genero.equals("")) animalDTO.setGenero(genero);

        animalDTO.setClientDTO(clientDTO);

        Log.d("animalDTO after",animalDTO.toString());


        userManager.newAnimal(EditAnimalActivity.this, animalDTO);*/
    }

    public ArrayList<String> getStringFromRaca(ArrayList<RacaDTO> racasAUX){
        ArrayList<String> strings = new ArrayList<>();
        for(RacaDTO r : racasAUX){
            strings.add(r.getRaca());
        }
        return strings;
    }

    public RacaDTO getRaca(int racaID){
        for(RacaDTO r : racas){
            if(r.getId()==racaID) return r;
        }
        return null;
    }

    public RacaDTO getRaca(String raca){
        for(RacaDTO r : racas){
            if(r.getRaca().equals(raca)) return r;
        }
        return null;
    }

    public ArrayList<RacaDTO> getRacasTipo (String tipo){
        ArrayList<RacaDTO> specific = new ArrayList<>();
        for(RacaDTO r : racas){
            if(r.getTipo().equals(tipo)) specific.add(r);
        }
        return specific;
    }

    @Override
    public void onSuccessRacasAll(ArrayList<RacaDTO> racas) {
        this.racas = racas;

        String[] itemsTipo = new String[]{"Cão", "Gato"};
        ArrayAdapter<String> adapterTipo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsTipo);
        display_tipo.setAdapter(adapterTipo);
        display_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) racasTipo = getRacasTipo("cão");
                else racasTipo = getRacasTipo("gato");

                ArrayAdapter<String> adapterRaca = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, getStringFromRaca(racasTipo));
                display_raca.setAdapter(adapterRaca);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        racasTipo = getRacasTipo("cão");

        ArrayAdapter<String> adapterRaca = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getStringFromRaca(racasTipo));
        display_raca.setAdapter(adapterRaca);

    }

    @Override
    public void onFailureRacasAll(Throwable t) {
        Log.e("EditAnimalActivity", "Fail getting racas!!");
    }

    @Override
    public void onSuccessAnimals(AnimalDTO animal) {

        Log.d("EditAnimalActivity", "Update animal com sucesso " + animal.toString());
        Toast.makeText(EditAnimalActivity.this, "Adicionado com sucesso!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent();
        intent.putExtra("newAnimal", animal);
        setResult(200, intent);
        finish();

    }

    @Override
    public void onFailureAnimals(Throwable t) {
        Log.e("EditAnimalActivity", "Fail putting Animal!! : " + t.toString());
    }
}
