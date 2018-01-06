package com.example.codeclan.summit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SummitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summits);

        Summits summits = new Summits();
        ArrayList<Summit> list = summits.getList();

        SummitsAdapter summitAdapter = new SummitsAdapter(this, list);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(summitAdapter);

    }


    public void getSummit(View listItem) {
        Summit summit = (Summit) listItem.getTag();
        Log.d("Summit name:", summit.getName());

        Intent intent = new Intent(this, SummitActivity.class);
        intent.putExtra("summit", summit);
        startActivity(intent);

    }

}
