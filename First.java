package com.achwek.customlistview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class First extends AppCompatActivity {

    Button b1 ;
    Button b2 ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
        b1=(Button)findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this, MainActivity.class);
                startActivity(intent);

            }
        });
        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First.this, AjoutAnnonce.class);
                startActivity(intent);

            }
        });






}






}
