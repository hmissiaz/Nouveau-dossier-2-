package com.achwek.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Description extends AppCompatActivity {
    ViewFlipper flipper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        int images[] = {R.drawable.maison3 , R.drawable.maison1 , R.drawable.maison2} ;
        flipper = findViewById(R.id.flipper) ;
        //for loop
        for (int image: images){
            flipperImages(image);

        }
    }



    public void flipperImages (int image ){
        ImageView iv = new ImageView(this) ;
        iv.setBackgroundResource(image);

        flipper.addView(iv);
        flipper.setFlipInterval(4000);
        flipper.setAutoStart(true);
        flipper.setInAnimation( this ,android.R.anim.slide_in_left );
        flipper.setOutAnimation( this , android.R.anim.slide_out_right);

    }
}
