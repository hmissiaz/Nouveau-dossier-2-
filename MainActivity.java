package com.achwek.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    protected ListView l ;
    final String EXTRA_TYPE = "titre";
    final String EXTRA_CATEGORIE = "desc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l= (ListView)findViewById(R.id.listv);
        ArrayList <HashMap <String , String >> listItem = new ArrayList<>();
        HashMap<String , String> map;

        Intent intent1 = getIntent();

        map= new HashMap<>();
        map.put("titre" , intent1.getStringExtra(EXTRA_CATEGORIE));
        map.put("desc" , intent1.getStringExtra(EXTRA_TYPE));
        map.put("img", String.valueOf(R.drawable.img));
        listItem.add(map);




        map= new HashMap<>();
        map.put("titre" , "maison");
        map.put("desc" , "S+3 ");
        map.put("img", String.valueOf(R.drawable.maison3));
        listItem.add(map);

        map= new HashMap<>();
        map.put("titre" , "appartement");
        map.put("desc" , "S+2");
        map.put("img", String.valueOf(R.drawable.ap1));
        listItem.add(map);

        map= new HashMap<>();
        map.put("titre" , "villa de luxe");
        map.put("desc" , "s+3");
        map.put("img", String.valueOf(R.drawable.villa));
        listItem.add(map);

        map= new HashMap<>();
        map.put("titre" , "appartement");
        map.put("desc" , "s+1 ");
        map.put("img", String.valueOf(R.drawable.ap1));




        listItem.add(map);

        SimpleAdapter ad = new SimpleAdapter(this.getBaseContext() , listItem , R.layout.l2
                , new  String[]{"img","titre" , "desc"}, new int [] {R.id.img , R.id.titre , R.id.desc});
        l.setAdapter(ad);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent newActivity = new Intent(MainActivity.this, Description.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity2 = new Intent(MainActivity.this, Description2.class);
                        startActivity(newActivity2);
                        break;
                    case 2:
                        Intent newActivity3 = new Intent(MainActivity.this, Description3.class);
                        startActivity(newActivity3);
                        break;
                    case 3:
                        Intent newActivity4 = new Intent(MainActivity.this, Description4.class);
                        startActivity(newActivity4);
                        break;
                }


            }
        });


    }
}

