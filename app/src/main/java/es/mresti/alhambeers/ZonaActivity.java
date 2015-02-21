package es.mresti.alhambeers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ZonaActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void btnBack (View v){
    Intent i = new Intent(this,MainActivity.class);
    startActivity(i);
  }

  
}
