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
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
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

    public void onSubmitButtonClicked(View button) {
        Log.d(getClass().toString(), "onSubmitButtonClicked was called");
        EditText nameField = (EditText) findViewById(R.id.editName);
        EditText rangeField = (EditText) findViewById(R.id.editRange);
        EditText countryField = (EditText) findViewById(R.id.editCountry);
        EditText heightField = (EditText) findViewById(R.id.editHeight);
        Log.d("NAME", nameField.getText().toString());

        String name = nameField.getText().toString();
        String range = rangeField.getText().toString();
        String country = countryField.getText().toString();
        Integer height = Integer.parseInt(heightField.getText().toString());

        Summit newSummit = new Summit(name, height, range, country);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        String mySummits = sharedPref.getString("MySummits", new ArrayList<Summit>().toString());

        Gson gson = new Gson();
        TypeToken<ArrayList<Summit>> summitArrayList = new TypeToken<ArrayList<Summit>>(){};
        ArrayList<Summit> list = gson.fromJson(mySummits, summitArrayList.getType());

        list.add(newSummit);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("MySummits", gson.toJson(list));
        editor.apply();


        Intent intent = new Intent(this, SummitsActivity.class);
        startActivity(intent);

    }



}
