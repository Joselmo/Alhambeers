package es.mresti.alhambeers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;


/**
 * Created by Elena on 21/02/2015.
 */
public class ConfigActivity extends Activity {

  private static final String LOGTAG = "LogsAndroid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);


      //TODO: check if/else
      if(getSaveData()){
        ButtonRectangle bloquear = (ButtonRectangle) findViewById(R.id.btn_bloquear);
        if (bloquear.getText().equals(getSaveDataB())){
          setUnblocked();
        }else{
          setBlocked();
        }
      }else{
        setUnblocked();
      }

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
      Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
      if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(takePictureIntent, 0);
      }
    }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    ButtonRectangle bloquear = (ButtonRectangle) findViewById(R.id.btn_bloquear);

    if (bloquear.getText().equals(getResources().getString(R.string.bloquear))) {
      setBlocked();
      setSaveData(true);
      bloquear.setText(getResources().getString(R.string.desbloquear));
    }else{
      setUnblocked();
      setSaveData(false);
      bloquear.setText(getResources().getString(R.string.bloquear));
    }
  }

  private void setBlocked(){
    ButtonRectangle btn_zona = (ButtonRectangle) findViewById(R.id.btn_zona);
    ButtonRectangle btn_twitter = (ButtonRectangle) findViewById(R.id.btn_twitter);
    ButtonRectangle btn_tlf = (ButtonRectangle) findViewById(R.id.btn_tlf);
    btn_zona.setEnabled(false);
    btn_twitter.setEnabled(false);
    btn_tlf.setEnabled(false);
  }

  private void setUnblocked(){
    ButtonRectangle btn_zona = (ButtonRectangle) findViewById(R.id.btn_zona);
    ButtonRectangle btn_twitter = (ButtonRectangle) findViewById(R.id.btn_twitter);
    ButtonRectangle btn_tlf = (ButtonRectangle) findViewById(R.id.btn_tlf);
    btn_zona.setEnabled(true);
    btn_twitter.setEnabled(true);
    btn_tlf.setEnabled(true);
  }

  private void setSaveData(boolean value){
    ButtonRectangle bloquear = (ButtonRectangle) findViewById(R.id.btn_bloquear);
    SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();
    if(value){
      editor.putString("bloqueo", "Desbloquear");
    }else{
      editor.putString("bloqueo", "Bloquear");
    }
    editor.putBoolean("cbBloqueo", value);
    editor.commit();
    Toast.makeText(this,getResources().getString(R.string.save),Toast.LENGTH_SHORT).show();
  }

  private boolean getSaveData(){
    SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
    return prefs.getBoolean("cbBloqueo",false);
  }

  private String getSaveDataB(){
    SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
    return prefs.getString("bloqueo","Bloquear");
  }

}