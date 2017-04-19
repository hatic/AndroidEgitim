package com.example.user.celsiusfahrenheit;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity  {
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(EditText) findViewById(R.id.editText1);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button1:
                RadioButton celsiusButton=(RadioButton) findViewById(R.id.radio0);
                RadioButton fahrenheightButton=(RadioButton) findViewById(R.id.radio1);
                if (text.getText().length()==0){
                    Toast.makeText(this,"Lütfen geçerli bir sayı giriniz",
                    Toast.LENGTH_LONG).show();
                    return;
                }
                float editText1=Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()){
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(editText1)));
                    fahrenheightButton.setChecked(true);
                    celsiusButton.setChecked(false);
                }else {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(editText1)));
                    fahrenheightButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                break;

        }

    }
}
