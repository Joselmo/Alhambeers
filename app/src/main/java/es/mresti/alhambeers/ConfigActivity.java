package es.mresti.alhambeers;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;


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
}