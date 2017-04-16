package com.example.user.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class list_item extends AppCompatActivity implements
        DialogInterface.OnClickListener, View.OnClickListener{
    private static final String[] ZONES={
            "Pasific Time","Mountain Time",
            "Central Time","Eastern Time",
            "Atlantic Time"
    };
    private  static final  String[] OFFSETS={
            "GMT-08:00","GMT-07:00","GMT-06:00",
            "GMT-05:00","GMT-04:00"
    };
    Button mButton;
    AlertDialog mActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_list_item);
       mButton=new Button(this);
       mButton.setText("Click for time zones");
        mButton.setOnClickListener(this);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(
                this,
                R.layout.activity_list_item
        ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row=convertView;
                if (row==null){
                    row=getLayoutInflater().inflate(R.layout.activity_list_item,parent,false);

                }
                TextView name=(TextView) row.findViewById(R.id.text_name);
                TextView detail=(TextView) row.findViewById(R.id.text_detail);
                name.setText(ZONES[position]);
                detail.setText(OFFSETS[position]);
                return  row;
            }

            @Override
            public int getCount() {
                return ZONES.length;
            }
        };
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Set time Zone");
        builder.setAdapter(adapter, this);

        builder.setNegativeButton("Cancel", null);
        mActions=builder.create();
        setContentView(mButton);
    }

    @Override
    public void onClick(View v) {
        mActions.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String selected=ZONES[which];
        mButton.setText(selected);

    }
}
