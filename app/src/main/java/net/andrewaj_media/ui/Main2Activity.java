package net.andrewaj_media.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import static net.andrewaj_media.ui.R.id.responseCode;


public class Main2Activity extends AppCompatActivity {

    private boolean nameSelected = false;
    private boolean phoneSelected = false;
    private boolean emailSelected = false;

    private String name;
    private String phone;
    private String email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = getIntent().getStringExtra("name");
        phone = getIntent().getStringExtra("phone");
        email = getIntent().getStringExtra("email");

        Button nameButton = (Button) findViewById(R.id.nameButton);
        Button phoneButton = (Button) findViewById(R.id.phoneButton);
        Button emailButton = (Button) findViewById(R.id.emailButton);

        nameButton.setText(name);
        phoneButton.setText(phone);
        emailButton.setText(email);

    }

    //takes you to edit screen
    public void editClick(View v) {
        if (v.getId() == R.id.button2) {
            Intent i = new Intent(Main2Activity.this, MainActivity1.class);
            startActivity(i);
        }
    }

    //selects name so you can add it to the swap
    public void nameClick(View v) {
        if (v.getId() == R.id.nameButton) {
            nameSelected = true;
        }
    }

    //selects phone so you can add it to the swap
    public void phoneClick(View v) {
        if (v.getId() == R.id.phoneButton) {
            phoneSelected = true;
        }
    }

    //selects email so you can add it to the swap
    public void emailClick(View v) {
        if (v.getId() == R.id.emailButton) {
            emailSelected = true;
        }
    }

    //swaps the contact info if they are true
    public void swapClick(View v) {
        if (v.getId() == R.id.swapButton) {
            TextView tv = (TextView) findViewById(responseCode);
            int responseCode = 0;
            try {
                responseCode = new HttpPost().execute(name).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            tv.setText("" + responseCode);




        }
    }


}
