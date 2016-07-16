package com.exemplo.thomas.atvdd2;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText emptyField,horasField,minutsField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyField = (EditText) findViewById(R.id.emptyField);
        horasField = (EditText) findViewById(R.id.horasField);
        minutsField = (EditText) findViewById(R.id.minutsField);
    }
    public void settings(View v){
        Intent i = new Intent(Settings.ACTION_SETTINGS);
        startActivity(i);
    }

    public void maps(View v) {
        Uri link = Uri.parse("https://www.google.com.br/maps?source=tldsi&hl=en");
        Intent i = new Intent(Intent.ACTION_VIEW, link);
        startActivity(i);

    }

        public void directSearch(View v){

        String term = emptyField.getText().toString();
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, term);
        startActivity(intent);
    }


    public void music(View v) {
        String artista = emptyField.getText().toString();
        Intent i = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        i.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
        i.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artista);
        i.putExtra(SearchManager.QUERY, artista);
        if (i.resolveActivity(getPackageManager()) != null) {
        startActivity(i);
    }
}
    public void sms(View v) {

        String number = emptyField.getText().toString();
        Uri msg = Uri.parse("send:"+number);
        Intent sms_intent = new Intent(Intent.ACTION_SENDTO, msg);
        sms_intent.putExtra("text", "");
        startActivity(sms_intent);


    }

    public void alarme(View v){

        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE,"New Alarm");
        i.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(horasField.getText().toString()));
        i.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minutsField.getText().toString()));
        startActivity(i);

    }

}
