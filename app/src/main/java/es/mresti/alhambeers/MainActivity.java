package es.mresti.alhambeers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.net.Uri;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;


public class MainActivity extends Activity {

  private static final String LOGTAG = "LogsAndroid";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButtonRectangle btn_tlf = (ButtonRectangle) findViewById(R.id.btn_telefono);
    ButtonRectangle btn_twi = (ButtonRectangle) findViewById(R.id.btn_twitter);
    ButtonRectangle btn_sos = (ButtonRectangle) findViewById(R.id.btn_sos);
    /*if(getSaveDataBtnPhone()){
      btn_tlf.setEnabled(true);
    }else{
      btn_tlf.setEnabled(false);
    }
    if(getSaveDataBtnTwitter()){
      btn_twi.setEnabled(true);
    }else{
      btn_twi.setEnabled(false);
    }
    if(getSaveDataBtnZone()){
      btn_sos.setEnabled(true);
    }else{
      btn_sos.setEnabled(false);
    }*/
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
        Toast.makeText(this,R.string.send_SOS,Toast.LENGTH_LONG).show();
    }

    public void btnTwitter (View v){
        Toast.makeText(this,R.string.send_twitter,Toast.LENGTH_LONG).show();
    }

    public void btnTelefono (View v){
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:686972826"));
        startActivity(intent);
    }


  private boolean getSaveDataBtnPhone(){
    SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
    return prefs.getBoolean("cbTelf",false);
  }

  private boolean getSaveDataBtnZone(){
    SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
    return prefs.getBoolean("cbZona",false);
  }

  private boolean getSaveDataBtnTwitter(){
    SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
    return prefs.getBoolean("cbTwit",false);
  }
}
