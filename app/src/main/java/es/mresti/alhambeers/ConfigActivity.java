package es.mresti.alhambeers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.gc.materialdesign.views.ButtonRectangle;


/**
 * Created by Elena on 21/02/2015.
 */
public class ConfigActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void btnSelecTelf (View v){
        Intent i = new Intent(this,SelecTelfActivity.class);
        startActivity(i);
    }
    public void btnSelecTwitter (View v){
        Intent i = new Intent(this,SelecTwitterActivity.class);
        startActivity(i);
    }

    public void btnZona (View v){
        Intent i = new Intent(this,InfoZona.class);
        startActivity(i);
    }

    public void btnBloquear (View v){
        // Vinculamos el Boton con la variable
        ButtonRectangle bloquear = (ButtonRectangle) findViewById(R.id.btn_bloquear);

        //Asignamos el texto que corresponda a las instrucciones
        if (bloquear.getText().equals(R.string.bloquear)) {
            bloquear.setText(getResources().getString(R.string.desbloquear));
        }
        else{
            bloquear.setText(getResources().getString(R.string.bloquear));
        }

    }
}