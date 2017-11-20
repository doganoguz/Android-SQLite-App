package com.doganoguz.stockbox;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn_kayitekle = (Button)findViewById(com.doganoguz.stockbox.R.id.button_kayitekle);

        btn_kayitekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),urunekle.class);
                startActivity(intent);
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
        if (id == R.id.ekle) {

                    Intent intent = new Intent(getApplicationContext(),urunekle.class);
                    startActivity(intent);

            return true;
        }
        else if (id == R.id.liste) {
            Intent intent = new Intent(getApplicationContext(),listele.class);
            startActivity(intent);
        }
        else if (id == R.id.hakkinda) {
            AlertDialog alertMessage = new AlertDialog.Builder(this).create();
            alertMessage.setTitle("Hakkında");
            alertMessage.setMessage("Stock Box: v1.0.0.0 Yapımcı: Doğan Oğuz");

            alertMessage.show();
        }
        else if (id == R.id.cikis) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
}
