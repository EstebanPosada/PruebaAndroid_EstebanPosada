package com.example.laura.pruebaandroid_estebanposada2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Menu_cine extends AppCompatActivity {


    private Button cart, vis, act;
    private TextView json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cine);

        cart = (Button) findViewById(R.id.btncart);
        vis = (Button) findViewById(R.id.btnvis);
        act = (Button) findViewById(R.id.act);
        json = (TextView) findViewById(R.id.json);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_cine.this, Cartelera.class));
            }
        });
        vis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_cine.this, Visitadas.class));
            }
        });

        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JSONTask().execute("https://www.dropbox.com/s/cfq0hkiuwa074wt/pruebaEleinco_Peliculas.txt?dl=0");
            }
        });

    }
    public class JSONTask extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            ///
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                //URL url = new URL("https://www.dropbox.com/s/cfq0hkiuwa074wt/pruebaEleinco_Peliculas.txt?dl=0");
                //URL url = new URL("http://bit.ly/PeliculaCarteleraEleinco");
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null){
                    connection.disconnect();
                }
                connection.disconnect();
                try {
                    if (reader != null){
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
         ////
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            json.setText(s);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_cine, menu);
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

    /*public class AsyncHttpTask extends AsyncTask<<String, Void, Integer>{

    }*/
}
