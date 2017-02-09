package pet4u.pet4u.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import pet4u.pet4u.R;
import pet4u.pet4u.managers.UserManager;
import pet4u.pet4u.user.AddressDTO;
import pet4u.pet4u.user.ClientDTO;

public class EditUserProfileActivity extends AppCompatActivity {

    EditText display_nome;
    EditText display_dataNasc;
    EditText display_telemovel;
    EditText display_rua;
    EditText display_cidade;
    EditText display_pais;
    EditText display_codPostal;
    Spinner display_genero;

    ClientDTO clientDTO;
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);

        Intent intent = getIntent();
        clientDTO = (ClientDTO) intent.getSerializableExtra("cliente");
        userManager = (UserManager) intent.getSerializableExtra("userManager");

        display_nome = (EditText) findViewById(R.id.et_display_nome);
        display_dataNasc = (EditText) findViewById(R.id.et_display_data_nascimento);
        display_telemovel = (EditText) findViewById(R.id.et_display_telemovel);
        display_rua = (EditText) findViewById(R.id.et_display_rua);
        display_cidade = (EditText) findViewById(R.id.et_display_cidade);
        display_pais = (EditText) findViewById(R.id.et_display_pais);
        display_codPostal = (EditText) findViewById(R.id.et_display_codPostal);
        display_genero = (Spinner) findViewById(R.id.spinner_genero);

        String[] items = new String[]{"Masculino", "Feminino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        display_genero.setAdapter(adapter);

        Button b = (Button) findViewById(R.id.b_save);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        display_nome.setText(clientDTO.getNome());
        display_dataNasc.setText(clientDTO.getDataNasc());
        display_telemovel.setText(clientDTO.getTelemovel());
        display_rua.setText(clientDTO.getMoradaDTO().getRua());
        display_cidade.setText(clientDTO.getMoradaDTO().getCidade());
        display_pais.setText(clientDTO.getMoradaDTO().getPais());
        display_codPostal.setText(clientDTO.getMoradaDTO().getCodPostal());
        if(clientDTO.getGenero() == "Masculino" || clientDTO.getGenero() == "masculino")
        display_genero.setSelection(0);
        else display_genero.setSelection(1);
    }


    public void saveData(){
        String nome = display_nome.getText().toString();
        String dataNasc = display_dataNasc.getText().toString();
        String telemovel = display_telemovel.getText().toString();
        String rua = display_rua.getText().toString();
        String cidade = display_cidade.getText().toString();
        String pais = display_pais.getText().toString();
        String codPostal = display_codPostal.getText().toString();
        String genero;
        if(display_genero.getSelectedItemPosition()== 0) genero = "masculino";
        else genero = "feminino";

        AddressDTO addressDTO = clientDTO.getMoradaDTO();

        if(!nome.equals("")) clientDTO.setNome(nome);
        if(!dataNasc.equals("")) clientDTO.setDataNasc(dataNasc);
        if(!telemovel.equals("")) clientDTO.setTelemovel(Integer.parseInt(telemovel));
        if(!rua.equals("")) addressDTO.setRua(rua);
        if(!cidade.equals("")) addressDTO.setCidade(nome);
        if(!pais.equals("")) addressDTO.setPais(nome);
        if(!codPostal.equals("")) addressDTO.setCodPostal(nome);
        if(!genero.equals("")) clientDTO.setGenero(genero);



    }
}

