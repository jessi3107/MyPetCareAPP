package com.example.mypetcareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistroPerfilMascotaActivity extends AppCompatActivity {

    Toolbar toolbar;

    Spinner spinnerTipoMas;

    Spinner spinnerGeneroMas;

    Spinner spinnerRegistroDatosMas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_perfil_mascota);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerTipoMas = (Spinner) findViewById(R.id.spinnerTipoMascota);
        spinnerGeneroMas = (Spinner) findViewById(R.id.spinnerGeneroMascota);
        spinnerRegistroDatosMas = (Spinner) findViewById(R.id.spinnerRegistroDatosMascota);

        ArrayList<String> tipoMascota = new ArrayList<>();
        ArrayList<String> generoMascota = new ArrayList<>();
        ArrayList<String> registroDatosMascota = new ArrayList<>();

        tipoMascota.add("Seleccione tipo de mascota");
        tipoMascota.add("Perro");
        tipoMascota.add("Gato");
        tipoMascota.add("Caballo");
        tipoMascota.add("Hamster");
        tipoMascota.add("Ave");
        tipoMascota.add("Pez");

        generoMascota.add("Seleccione genero de mascota");
        generoMascota.add("Macho");
        generoMascota.add("Hembra");

        registroDatosMascota.add("Desea registrar los datos de su mascota");
        registroDatosMascota.add("Si");
        registroDatosMascota.add("No");

        ArrayAdapter adp = new ArrayAdapter(RegistroPerfilMascotaActivity.this, android.R.layout.simple_spinner_dropdown_item, tipoMascota);
        ArrayAdapter adp2 = new ArrayAdapter(RegistroPerfilMascotaActivity.this, android.R.layout.simple_spinner_dropdown_item, generoMascota);
        ArrayAdapter adp3 = new ArrayAdapter(RegistroPerfilMascotaActivity.this, android.R.layout.simple_spinner_dropdown_item, registroDatosMascota);

        spinnerTipoMas.setAdapter(adp);
        spinnerGeneroMas.setAdapter(adp2);
        spinnerRegistroDatosMas.setAdapter(adp3);

        spinnerTipoMas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipo = (String) spinnerTipoMas.getAdapter().getItem(position);

                //Toast.makeText(RegistroPerfilMascotaActivity.this, "Seleccionaste: " + tipo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerGeneroMas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipo = (String) spinnerGeneroMas.getAdapter().getItem(position);

                //Toast.makeText(RegistroPerfilMascotaActivity.this, "Seleccionaste: " + tipo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerRegistroDatosMas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipo = (String) spinnerRegistroDatosMas.getAdapter().getItem(position);

                //Toast.makeText(RegistroPerfilMascotaActivity.this, "Seleccionaste: " + tipo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opcion1) {
            Toast.makeText(this, "Mascota", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.buscar) {
            Toast.makeText(this, "OPRIMISTE BUSCAR", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}