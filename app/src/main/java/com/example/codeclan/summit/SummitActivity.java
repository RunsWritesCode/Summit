package com.example.codeclan.summit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by sophiemullins on 06/01/2018.
 */



public class SummitActivity extends AppCompatActivity {

    TextView name;
    TextView height;
    TextView range;
    TextView country;
    Summit currentSummit;
    ToggleButton climbedStat;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.summit_details);

            name = findViewById(R.id.name);
            height = findViewById(R.id.height);
            range = findViewById(R.id.range);
            country = findViewById(R.id.country);
            climbedStat = findViewById(R.id.toggleClimb);

            Intent intent = getIntent();
            currentSummit = (Summit)intent.getSerializableExtra("summit");
            Log.d("Summit name:", currentSummit.getName());

            climbedStat.setChecked(currentSummit.getClimbed());

            name.setText(currentSummit.getName());
            height.setText(currentSummit.getHeight().toString());
            range.setText(currentSummit.getRange());
            country.setText(currentSummit.getCountry());

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

        public void onToggleClimbClicked(View button) {


            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

            String mySummits = sharedPref.getString("MySummits", new ArrayList<Summit>().toString());

            SharedPreferences.Editor editor = sharedPref.edit();
            Gson gson = new Gson();
            TypeToken<ArrayList<Summit>> summitArrayList = new TypeToken<ArrayList<Summit>>(){};
            ArrayList<Summit> list = gson.fromJson(mySummits, summitArrayList.getType());

            for (Summit summit: list) {
                if (summit.getName().equals(currentSummit.getName())) {
                    if (currentSummit.getClimbed()) {
                        summit.setNotClimbed();
                    }
                    else {
                        summit.setClimbed();
                    }
                }
            }
            editor.putString("MySummits", gson.toJson(list));
            editor.apply();

        }

        public void onDeleteButtonClicked(View button) {

            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

            String mySummits = sharedPref.getString("MySummits", new ArrayList<Summit>().toString());

            SharedPreferences.Editor editor = sharedPref.edit();
            Gson gson = new Gson();
            TypeToken<ArrayList<Summit>> summitArrayList = new TypeToken<ArrayList<Summit>>(){};
            ArrayList<Summit> list = gson.fromJson(mySummits, summitArrayList.getType());


            for (Summit summit: list) {
                if (summit.getName().equals(currentSummit.getName())) {
                    list.remove(summit);
                }
            }
            editor.putString("MySummits", gson.toJson(list));
            editor.apply();

            Intent intent = new Intent(this, SummitsActivity.class);
            startActivity(intent);
        }


    }

