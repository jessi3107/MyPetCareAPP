package com.example.mypetcareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseReference mRootReference;

    private EditText textNombre;
    private EditText textTelefono;
    private EditText textEmail;
    private EditText textPassword;
    //private EditText textPasswordConfirmar;
    private Button botonRegistrar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth = FirebaseAuth.getInstance();
        mRootReference = FirebaseDatabase.getInstance().getReference();

        textNombre = (EditText) findViewById(R.id.editTextNombre);
        textTelefono = (EditText) findViewById(R.id.editTextTelefono);
        textEmail = (EditText) findViewById(R.id.editTextEmail);
        textPassword = (EditText) findViewById(R.id.editTextPassword);
        //textPasswordConfirmar = (EditText) findViewById(R.id.editTextConfirmarPassword);

        botonRegistrar = (Button) findViewById(R.id.buttonRegistrar);
        botonRegistrar.setOnClickListener(this);

    }

    private void registrarUsuario(){

        String nombre = textNombre.getText().toString().trim();
        String telefono = textTelefono.getText().toString().trim();
        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();
        //String passwordConfirmar = textPasswordConfirmar.getText().toString().trim();

        if(TextUtils.isEmpty(nombre)){
            Toast.makeText(this,"Se debe ingresar el nombre",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        /*
        if(TextUtils.isEmpty(passwordConfirmar)){
            Toast.makeText(this,"Debe confirmar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.equals(password, passwordConfirmar)){
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();
            return;
        }

         */

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(RegistroActivity.this,"Se ha registrado el usuario: "+ textEmail.getText(),Toast.LENGTH_LONG).show();
                        }else{
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(RegistroActivity.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegistroActivity.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

        Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("Nombre", nombre);
        datosUsuario.put("Telefono", telefono);
        datosUsuario.put("Email", email);
        datosUsuario.put("Password", password);

        mRootReference.child("usuario").push().setValue(datosUsuario);

    }

    @Override
    public void onClick(View view) {
        //Invocamos al método:
        registrarUsuario();
    }
}