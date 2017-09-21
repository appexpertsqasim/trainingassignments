package com.example.taeconsultant.intents;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_phone, button_maps, button_email, button_alarm, button_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_phone = (Button) findViewById(R.id.btn_phone);
        button_maps = (Button) findViewById(R.id.btn_maps);
        button_alarm = (Button) findViewById(R.id.btn_alarm);
        button_camera = (Button) findViewById(R.id.btn_camera);
        button_email = (Button) findViewById(R.id.btn_email);
    }


    public void launchIntents(View view){
       if(view.getId()==R.id.btn_phone){
            Intent dialIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:000000"));
            startActivity(dialIntent);
        }
       else if(view.getId()==R.id.btn_maps){
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:47.6,-122.3?z=11"));
            startActivity(mapIntent);
        }
       else if(view.getId()==R.id.btn_alarm) {
           Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM).putExtra(AlarmClock.EXTRA_MESSAGE, "alarm").putExtra(AlarmClock.EXTRA_HOUR, "12").putExtra(AlarmClock.EXTRA_MINUTES, "30");

           startActivity(alarmIntent);

       }
       else if(view.getId()==R.id.btn_email) {
           Intent intent = new Intent(Intent.ACTION_SENDTO);
           intent.setData(Uri.parse("mailto:")); // only email apps should handle this
         intent.putExtra(Intent.EXTRA_EMAIL,"qazbutt@gmail.com");
         intent.putExtra(Intent.EXTRA_SUBJECT, "test");
           startActivity(intent);

       }
       else if(view.getId()==R.id.btn_camera) {
           Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
           startActivity(intent);

       }


    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFECYCLE"," onStart executed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE"," onPause executed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE","onResume executed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE","onStop executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE","onDestroy executed");
    }

}
