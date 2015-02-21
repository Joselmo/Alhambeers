package es.mresti.alhambeers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SelecTwitterActivity extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
    }


    public void aniadirTelf (View v) {

        EditText etTwitter = (EditText) findViewById(R.id.etTelefono);
        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("twitter", etTwitter.getText().toString());
        editor.putBoolean("cbTwit",true);
        editor.commit();


        Toast.makeText(this, getResources().getString(R.string.save), Toast.LENGTH_SHORT).show();
    }
}
