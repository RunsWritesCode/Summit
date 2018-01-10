package com.example.codeclan.summit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

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

    public void onSubmitButtonClicked(View button) {
        Log.d(getClass().toString(), "onSubmitButtonClicked was called");
        EditText nameField = (EditText) findViewById(R.id.editName);
        Log.d("NAME", nameField.getText().toString());

    }




//    onClickSubmit { get back from shared prefs, convert to java arraylist, arraylist.add(new summit), convert back to string and saved back to SPrefs.

}
