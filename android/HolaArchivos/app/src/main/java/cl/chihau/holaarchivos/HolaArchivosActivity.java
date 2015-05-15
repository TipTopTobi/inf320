package cl.chihau.holaarchivos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HolaArchivosActivity extends Activity {
    TextView txtResultado;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txtResultado = (TextView) findViewById(R.id.TxtResultado);
    }
    
    public void escribirArchivo(View view) {
        try {
            FileOutputStream fout = openFileOutput("prueba_int.txt", Context.MODE_PRIVATE);

            String texto = "Texto de prueba desde memoria interna";
            fout.write(texto.getBytes());
            fout.close();
            txtResultado.setText("Archivo creado!");
        } catch(Exception ex) {
            Log.e("HolaArchivos", "Error al escribir el archivo en memoria interna");
        }
    }
    
    public void leerArchivo(View view) {
        try {
            BufferedReader fin = new BufferedReader(new InputStreamReader(
                    openFileInput("prueba_int.txt")));
            
            String texto = fin.readLine();
            fin.close();
            txtResultado.setText(texto);
        } catch(Exception ex) {
            Log.e("HolaArchivos", "Error al leer el archivo en memoria interna");
        }
    }

    public void escribirSD(View view) {
        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;
        
        String estado = Environment.getExternalStorageState();
        
        if(estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        } else if(estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoEscritura = false;
        } else {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }
        
        if(sdDisponible && sdAccesoEscritura) {
            try {
                File ruta_sd = Environment.getExternalStorageDirectory();
                File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                OutputStreamWriter fout = new OutputStreamWriter(
                        new FileOutputStream(f));
                fout.write("Texto de prueba desde memoria externa");
                fout.close();
                
                txtResultado.setText("Archivo SD creado!");
            } catch(Exception ex) {
                Log.e("HolaArchivos", "Error al escribir el archivo en memoria externa");
            }
        } else {
            Log.e("HolaArchivos", "Error: la tarjeta SD no se encuentra " + 
                    "o no tiene permisos de escritura");
        }
    }
    
    public void leerSD(View view) {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            
            BufferedReader fin = new BufferedReader(new InputStreamReader(
                    new FileInputStream(f)));
            String texto = fin.readLine();
            fin.close();
            
            txtResultado.setText(texto);
        } catch(Exception ex) {
            Log.e("HolaArchivos", "Error al leer el archivo desde la memoria externa");
        }
    }
    
    public void leerRaw(View view) {
        try {
            InputStream fraw = getResources().openRawResource(R.raw.prueba_raw);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            String texto = brin.readLine();
            fraw.close();
            
            txtResultado.setText(texto);
        } catch(Exception ex) {
            Log.e("HolaArchivos", "Error al leer el archivo desde recurso raw");
        }
    }
}
