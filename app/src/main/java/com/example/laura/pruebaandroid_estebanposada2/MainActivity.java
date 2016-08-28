package com.example.laura.pruebaandroid_estebanposada2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnac;
    EditText user, mail, fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnac = (Button) findViewById(R.id.acept);
        user = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.mail);
        fecha = (EditText) findViewById(R.id.date);
        final String users = user.getText().toString();
        final String mails = mail.getText().toString();
        final String fechas = fecha.getText().toString();

        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (users.equals("") && mails.equals("") && fechas.equals("")) {
                    startActivity(new Intent(MainActivity.this, Menu_cine.class));
                } else {
                    Toast.makeText(MainActivity.this, "Introducir todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
