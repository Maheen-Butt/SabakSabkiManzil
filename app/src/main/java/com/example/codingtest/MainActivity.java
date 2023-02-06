package com.example.codingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, sabak, sabki, manzil, incorrect;
    Button btnupdate, btncommits;
    TextView txt1;
    DbHandler DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.textView);

        id = findViewById(R.id.Sid);
        sabak = findViewById(R.id.Sabak);
        sabki = findViewById(R.id.Sabki);
        manzil = findViewById(R.id.Manzil);
        incorrect = findViewById(R.id.incorrect);
        btnupdate = findViewById(R.id.Insert);



        DB = new DbHandler(this);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid = id.getText().toString();
                String sSabak = sabak.getText().toString();
                String sSabaki = sabki.getText().toString();
                String sManzil = sabki.getText().toString();
                String incorrect = sabki.getText().toString();

                //SabaqDiary s = new SabaqDiary(sid, sSabak, sSabaki, sManzil, incorrect);
                Boolean checkupdatedata = DB.upgrade(sid, sSabak, sSabaki, sManzil, incorrect);
                if (checkupdatedata == true)
                    Toast.makeText(MainActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });

        btncommits = findViewById(R.id.Commit);
        btncommits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://github.com/komalafzaal123/SabaqDiary/commits/main");
            }

            private void goToUrl(String url) {
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        //RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}