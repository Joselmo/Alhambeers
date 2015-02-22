package es.mresti.alhambeers;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gc.materialdesign.widgets.ProgressDialog;

import org.apache.http.NameValuePair;


public class ZonaActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zona);
  }

  public void btnBack (View v){
    Intent i = new Intent(this,MainActivity.class);
    startActivity(i);
  }

    public void btnGetPosition (View v){
       // Async_Consulta sal = new Async_Consulta();
       // sal.execute();
        Toast.makeText(this,"Posicion tomada",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,DistActivity.class);
        startActivity(i);
    }


    class Async_Consulta extends AsyncTask<String, String, String> {
        private ProgressDialog pDialog;

        protected void onPreExecute() {
            pDialog = new ProgressDialog(ZonaActivity.this,"Obteniendo posición...");

            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... params) {
            String result = "noexiste";
            //Lanzamos la consulta al servidor GPS
            // Recogemos los datos del servidor y se lo pasamos a la capa de java

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                Log.e("...........ERROR:"," Recibiendo posicion");
            }

            return "";
        }

        protected void onPostExecute(String result) {
            // Recogemos los datos del servidor y ya podemos utilizarlos en la app
            // Mediante la API REST
            //
            pDialog.dismiss();
            if (result.equals("noexiste")) {
                Toast.makeText(getApplicationContext(),
                        "Error al obtener posicionamiento",
                        Toast.LENGTH_LONG).show();
            }

        }
    }

  
}
