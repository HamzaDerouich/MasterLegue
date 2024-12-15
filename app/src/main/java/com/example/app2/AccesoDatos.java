package com.example.app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class AccesoDatos
{
    private Context contexto;
    MasterLegueBD masterLegueBD;

    public AccesoDatos( Context contexto)
    {
        this.contexto = contexto;
        masterLegueBD = new MasterLegueBD(this.contexto);
    }

    public Usuario ConsultarUsuario(String nombre) {

        SQLiteDatabase accesoLectura = masterLegueBD.getReadableDatabase();
        Usuario usuario = null;

        String[] campos = new String[]{"nombre", "email", "password"};

        String seleccion = "nombre = ?";
        String[] argumentos = new String[]{nombre};

        Cursor c = accesoLectura.query("usuarios", campos, seleccion, argumentos, null, null, null);
        if (c != null) {
            if (c.moveToFirst()) {

                usuario = new Usuario();
                usuario.setNombre(c.getString(0));
                usuario.setMail(c.getString(1));
                usuario.setContaseña(c.getString(2));
            }
            c.close();
        }

        return usuario;
    }

    public boolean RegistrarUsuario(Usuario usuario)
    {

        SQLiteDatabase accesoEscritura = masterLegueBD.getWritableDatabase();

        ContentValues registro = new ContentValues();

        registro.put("nombre",usuario.getNombre());

        registro.put("email",usuario.getMail());

        registro.put("password",usuario.getContaseña());

        long resultado = accesoEscritura.insert("usuarios",null,registro);

        if( resultado != -1 )
        {
            return  true;
        }
        return false;
    }

    public boolean ActualizarDatosUsuario(Usuario usuario)
    {
        SQLiteDatabase acceso_escritura = masterLegueBD.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nombre", usuario.getNombre());
        contentValues.put("email", usuario.getMail());
        contentValues.put("password", usuario.getContaseña());

        long filas_Afectadas = acceso_escritura.update("usuarios", contentValues, " nombre = ? ", new String[]{String.valueOf(usuario.getNombre())});

        if( filas_Afectadas != -1 )
        {
            Toast.makeText(contexto, "Datos actualizados correctamente!!", Toast.LENGTH_SHORT).show();
            return  true;
        }
        else
        {
            Toast.makeText(contexto, "No se han podido actualizar los datos!!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
