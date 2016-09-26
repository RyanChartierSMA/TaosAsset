package com.example.rac.toasapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class AssetSelection extends AppCompatActivity {
    /*the aim of this class is to populate a list based on the assets we have.
    Use a local database to load this information
    An array will do fine for now.
    */
    //layout that will link to xml layout to add buttons
    LinearLayout buttonHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonHolder = (LinearLayout)findViewById(R.id.buttonLayout);
        //maps it so i can add buttons to it dynamically

        populateLayout();

    }

    private void populateLayout()
    //for each index in the array, create a button and add it to the layout.
    {

    }
}
