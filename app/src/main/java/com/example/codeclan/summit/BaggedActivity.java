package com.example.codeclan.summit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class BaggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagged);

        Summits summits = new Summits();
        ArrayList<Summit> list = summits.getList();

        ArrayList<Summit> baggedList = new ArrayList<>();

        for (Summit summit: list) {
            if (summit.getClimbed() == true)
            {
                baggedList.add(summit);
            }

        }

        SummitsAdapter summitAdapter = new SummitsAdapter(this, baggedList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(summitAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_welcome) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.action_summits) {
            Intent intent = new Intent(this, SummitsActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.action_to_climb) {
            Intent intent = new Intent(this, ToClimbActivity.class);
            startActivity(intent);
            return true;
        }

        if (item.getItemId() == R.id.action_climbed) {
            Intent intent = new Intent(this, BaggedActivity.class);
            startActivity(intent);
            return true;
        }

        if (item.getItemId() == R.id.action_add_new) {
            Intent intent = new Intent(this, AddNewActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    list of climbed summits
}
