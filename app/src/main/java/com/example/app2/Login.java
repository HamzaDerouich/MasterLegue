package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    AccesoDatos accesoDatos;
    Usuario usuario;
    TextView recuperrarContraseña;
    EditText nombre, email, password;
    AppCompatButton login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        accesoDatos = new AccesoDatos(this);
        nombre = findViewById(R.id.editTextNombre);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        recuperrarContraseña = findViewById(R.id.textView8);
        login = findViewById(R.id.buttonLogin);
        signup = findViewById(R.id.buttonSignUp);


        recuperrarContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, RecuperarContrasena.class);
                startActivity(intent);
                Toast.makeText(Login.this, "Todos cometemos errores de vez en cuando.!", Toast.LENGTH_SHORT).show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos ingresados
                String nombreString = nombre.getText().toString().trim();
                String emailString = email.getText().toString().trim();
                String passwordString = password.getText().toString().trim();

                // Validar campos vacíos
                if (nombreString.isEmpty() || emailString.isEmpty() || passwordString.isEmpty()) {
                    Toast.makeText(Login.this, "Rellene todos los campos para continuar.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailString).matches()) {
                    Toast.makeText(Login.this, "Ingrese un email válido.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Usuario usuario = accesoDatos.ConsultarUsuario(nombreString);

                if (usuario != null) {
                    if (nombreString.equals(usuario.getNombre()) &&
                            emailString.equals(usuario.getMail()) &&
                            passwordString.equals(usuario.getContaseña())) {
                        Toast.makeText(Login.this, "Bienvenido!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.putExtra("usuario",usuario);
                        startActivity(intent);
                    } else {
                        Mensaje_Error("Error en la validación", "Los datos ingresados no coinciden. Verifica la información o regístrate si no tienes una cuenta.");
                    }
                } else {
                    Toast.makeText(Login.this, "El usuario no existe. Por favor, regístrese para continuar.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Mensaje_Error (String titulo, String mensaje)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(titulo);
        dialog.setMessage(mensaje);
        dialog.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
        dialog.show();
    }
}