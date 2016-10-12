package net.andrewaj_media.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void onSaveClick(View v) {
        if ( v.getId() == R.id.BTNsave) {
            EditText name = (EditText) findViewById(R.id.TFname);
            EditText phone = (EditText) findViewById(R.id.TFphone);
            EditText email = (EditText) findViewById(R.id.TFemail);

            String n = name.getText().toString();
            String p = phone.getText().toString();
            String e = email.getText().toString();

            Intent i = new Intent(MainActivity1.this, Main2Activity.class);
            i.putExtra("name", n);
            i.putExtra("phone", p);
            i.putExtra("email", e);

            startActivity(i);
        }
    }
}
