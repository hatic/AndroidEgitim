package com.example.user.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements
        DialogInterface.OnClickListener, View.OnClickListener {
    private static final String[] ZONES = {
            "Pasific Time", "Mountin Time",
            "Central Time", "Eastern Time",
            "Atlantic Time"
    };
    Button mButton;
    AlertDialog mActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        mButton = new Button(this);
        mButton.setText("Click for Time Zones");
        mButton.setOnClickListener(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select time zone");
        builder.setItems(ZONES, (DialogInterface.OnClickListener) this);
        //Cancel butonu için de extra şeyler yapılabilirdi
        builder.setNegativeButton("Cancel", null);
        mActions = builder.create();

        setContentView(mButton);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String selected = ZONES[which];
        mButton.setText(selected);

    }

    @Override
    public void onClick(View v) {
        mActions.show();

    }
}

