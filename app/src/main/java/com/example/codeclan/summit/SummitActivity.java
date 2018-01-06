package com.example.codeclan.summit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sophiemullins on 06/01/2018.
 */



public class SummitActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_summits);

            Intent intent = getIntent();
            Summit summit = (Summit)intent.getSerializableExtra("summit");
            Log.d("Summit name:", summit.getName());
        }

    }

