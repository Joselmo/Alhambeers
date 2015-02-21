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
    setContentView(R.layout.activity_main);
    TextView texto = (TextView) findViewById(R.id.textViewDist);
    texto.setText("0");
  }

  public void btnMenos(View v){
    ButtonRectangle btn = (ButtonRectangle) findViewById(R.id.btn_low);

    int value = Integer.getInteger(btn.getText());

    if(value>10) {
      value -= 10;
      btn.setText(String.valueOf(value));
    }
  }

  public void btnMas(View v){
    ButtonRectangle btn = (ButtonRectangle) findViewById(R.id.btn_high);

    int value = Integer.getInteger(btn.getText());

    if(value<100) {
      value += 10;
      btn.setText(String.valueOf(value));
    }
  }
  public void btnOk (View v){

    String texto = getResources().getString(R.string.toast_save);
    Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();

    Intent i = new Intent(this,MainActivity.class);
    startActivity(i);
  }
}
