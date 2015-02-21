package es.mresti.alhambeers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by asus on 21/02/2015.
 */
public class SelecTelfActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telf);
    }

    public void aniadirTelf (View v) {

        EditText etTelf = (EditText) findViewById(R.id.etTelefono);

        SharedPreferences prefs =
                getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("tlf", etTelf.getText().toString());
        editor.commit();


        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(
                        AndroidPrefScreensActivity.this);

        Log.i("", "Opción 1: " + pref.getString("tlf"));
    }
}
