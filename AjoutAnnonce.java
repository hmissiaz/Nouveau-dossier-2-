package com.achwek.customlistview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class AjoutAnnonce extends AppCompatActivity {
    Button v;
    Button a ;
    final String EXTRA_TYPE = "titre";
    final String EXTRA_CATEGORIE = "desc";
    final String EXTRA_IMAGE = "img";
    Button btn ;
    ImageView img ;

    private static final int permission = 0 ;
    private static final int result =1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creation);
        v=(Button)findViewById(R.id.valide);
        a=(Button)findViewById(R.id.annuler);
        final EditText type = (EditText) findViewById(R.id.typeE);
        final EditText cat = (EditText) findViewById(R.id.catégorieE);
        final ImageView img = (ImageView) findViewById(R.id.imgapp);

         //boutton valider
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String T= type.getText().toString();
                final String C = cat.getText().toString();

                Intent intent1 = new Intent(AjoutAnnonce.this, MainActivity.class);
                intent1.putExtra(EXTRA_TYPE, T);
                intent1.putExtra(EXTRA_CATEGORIE, C);
                startActivity(intent1);

                }
        });

        //boutton annuler
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(AjoutAnnonce.this, First.class);
                startActivity(intent2);



            }
        });









        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},permission);
        }




        btn = (Button) findViewById(R.id.bimg) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI) ;
                startActivityForResult(i,result) ;
            }
        });
}



    public void onRequestPermissionsResult(int requestCode , @NonNull String[] permissions , @NonNull int[] grantResults) {
        switch(requestCode) {
            case permission :
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this , "permission granted" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this , "permission not granted" , Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    protected void onActivityResult(int requestCode , int resultCode , Intent data)
    {
        switch(requestCode) {
            case result :
                if (resultCode == RESULT_OK)
                {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA} ;
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn ,null , null , null ) ;
                    cursor.moveToFirst() ;
                    int ColumnIndex = cursor.getColumnIndex(filePathColumn[0]) ;
                    String picturePath = cursor.getString(ColumnIndex) ;
                    cursor.close();
                    img.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
        }
    }









}

