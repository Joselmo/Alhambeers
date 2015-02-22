package es.mresti.alhambeers;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

public class DistActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dist);
     ButtonRectangle btn = (ButtonRectangle) findViewById(R.id.btn_high);
     btn.getTextView().setTextSize(45);
     btn = (ButtonRectangle) findViewById(R.id.btn_low);
     btn.getTextView().setTextSize(45);
  }

  public void btnMenos(View v){
      TextView distancia = (TextView) findViewById(R.id.textViewDist);

      int value = Integer.valueOf(distancia.getText().toString());

    if(value>10) {
      value -= 10;
        distancia.setText(String.valueOf(value));
    }
  }

  public void btnMas(View v){
      TextView distancia = (TextView) findViewById(R.id.textViewDist);

    int value = Integer.valueOf(distancia.getText().toString());

    if(value<100) {
      value += 10;
        distancia.setText(String.valueOf(value));
    }
  }
  public void btnOk (View v){

    String texto = getResources().getString(R.string.toast_save);
    Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();

    Intent i = new Intent(this,MainActivity.class);
    startActivity(i);
  }
}
