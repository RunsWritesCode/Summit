package com.example.codeclan.summit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class SummitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summits);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        String mySummits = sharedPref.getString("MySummits", new ArrayList<Summit>().toString());

        Gson gson = new Gson();
        TypeToken<ArrayList<Summit>> summitArrayList = new TypeToken<ArrayList<Summit>>(){};
        ArrayList<Summit> list = gson.fromJson(mySummits, summitArrayList.getType());
        Log.d("mySummits", list.toString());

//        first seed for shared prefs - only needed if app deleted (but not required for app functionality even in that case).
//
//        Summits summits = new Summits();
//        ArrayList<Summit> list = summits.getList();
//
//        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//
//        Gson gson = new Gson();
//        editor.putString("MySummits", gson.toJson(list));
//        editor.apply();

        SummitsAdapter summitAdapter = new SummitsAdapter(this, list);
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

    public void getSummit(View listItem) {
        Summit summit = (Summit) listItem.getTag();
        Log.d("Summit name:", summit.getName());

        Intent intent = new Intent(this, SummitActivity.class);
        intent.putExtra("summit", summit);
        startActivity(intent);

    }

}
