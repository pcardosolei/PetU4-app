package pet4u.pet4u.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import pet4u.pet4u.R;
import pet4u.pet4u.callbacks.ClientCallback;
import pet4u.pet4u.callbacks.ClientUpdateCallback;
import pet4u.pet4u.managers.UserManager;
import pet4u.pet4u.user.AddressDTO;
import pet4u.pet4u.user.ClientDTO;

public class EditUserProfileActivity extends AppCompatActivity implements ClientUpdateCallback {

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

        Log.d("clientDTO before change",clientDTO.toString());

        display_nome.setText(clientDTO.getNome());
        display_dataNasc.setText(clientDTO.getDataNasc());
        display_telemovel.setText(Integer.toString(clientDTO.getTelemovel()));
        display_rua.setText(clientDTO.getMoradaDTO().getRua());
        display_cidade.setText(clientDTO.getMoradaDTO().getCidade());
        display_pais.setText(clientDTO.getMoradaDTO().getPais());
        display_codPostal.setText(clientDTO.getMoradaDTO().getCodPostal());
        if(clientDTO.getGenero().equals("Masculino") || clientDTO.getGenero().equals("masculino"))
            display_genero.setSelection(0);
        else
            display_genero.setSelection(1);
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
        if(!cidade.equals("")) addressDTO.setCidade(cidade);
        if(!pais.equals("")) addressDTO.setPais(pais);
        if(!codPostal.equals("")) addressDTO.setCodPostal(codPostal);
        if(!genero.equals("")) clientDTO.setGenero(genero);

        Log.d("clientDTO after change",clientDTO.toString());

        userManager.updateClient(EditUserProfileActivity.this, clientDTO);

    }

    @Override
    public void onSuccessClientUpdate(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
        Log.d("EditUserProfileActivity", "Update cliente com sucesso " + clientDTO.toString());
        Toast.makeText(EditUserProfileActivity.this, "Alterado com sucesso!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.putExtra("updatedClient",clientDTO);
        setResult(100, intent);
        finish();
    }

    @Override
    public void onFailureClientUpdate(Throwable t) {
        Log.d("EditUserProfileActivity", "Fail ao Update cliente!!!");
        Toast.makeText(EditUserProfileActivity.this, "Falha ao alterar!", Toast.LENGTH_SHORT).show();
    }
}
