package es.mresti.alhambeers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;


public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


  }

    /** Botones de inicio
     *
     *
     */
   public void btnConfig (View v){
        Intent i = new Intent(this,ConfigActivity.class);
        startActivity(i);
    }

    public void btnSos (View v){
        Intent i = new Intent(this,ConfigActivity.class);
        startActivity(i);
    }

    public void btnTwitter (View v){
        Intent i = new Intent(this,ConfigActivity.class);
        startActivity(i);
    }

    public void btnTelefono (View v){
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:686972826"));
        startActivity(intent);
    }
}
