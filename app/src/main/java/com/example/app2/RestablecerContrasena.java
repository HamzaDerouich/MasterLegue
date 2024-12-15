package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RestablecerContrasena extends AppCompatActivity {

    EditText nombre, email, password , passwordValidation;
    Button restablecer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restablecer_contrasena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre = findViewById(R.id.editTextNombre);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        passwordValidation = findViewById(R.id.editTextPasswordValidation);
        restablecer = findViewById(R.id.button);

        restablecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String nombreString = nombre.getText().toString();
                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();
                String passwordValidationString = passwordValidation.getText().toString();


                if( nombreString.isEmpty() || emailString.isEmpty() || passwordString.isEmpty() || passwordValidationString.isEmpty() )
                {
                    Toast.makeText(RestablecerContrasena.this, "Rellene todos las campos, para seguir!!", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    if(  passwordValidationString.equals(passwordString) )
                    {

                        Intent intent = new Intent(RestablecerContrasena.this,Login.class);
                        startActivity(intent);
                        Toast.makeText(RestablecerContrasena.this, "Tu contraseña ha sido cambiada exitosamente.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Mensaje("Error en el registro", "Por favor verifica los campos ingresados.");

                    }

                }
            }
        });

    }
    public void Mensaje(String titulo, String mensaje)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(titulo);
        dialog.setMessage(mensaje);
        dialog.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
        dialog.show();
    }
    }

