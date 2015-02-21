package es.mresti.alhambeers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SelecTelfActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telf);
    }

    public void aniadirTelf (View v) {

        EditText etTelf = (EditText) findViewById(R.id.etTelefono);
        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("tlf", etTelf.getText().toString());
        editor.putBoolean("cbTelf",true);
        editor.commit();


        Toast.makeText(this,getResources().getString(R.string.save),Toast.LENGTH_SHORT).show();
    }
}
