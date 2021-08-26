package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText add_temp;
    RadioButton buttn1;
    RadioButton buttn2;
    Button cal_buttn;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_temp = findViewById(R.id.add_temp);
        buttn1 = findViewById(R.id.buttn1);
        buttn2 = findViewById(R.id.buttn2);
        cal_buttn = findViewById(R.id.cal_buttn);
        text1 = findViewById(R.id.text1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cal_buttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
                ;
            }
        });

    }
    public void calculateAnswer() {
        Calculations cal = new Calculations();
        String value = add_temp.getText().toString();
        if (TextUtils.isEmpty(value)){/* input value is empty */
            Toast.makeText(this, "Enter the temperature!",Toast.LENGTH_SHORT).show();
        }else {
            Float temp = Float.parseFloat(value);
            if(buttn1.isChecked()){ /* celcius button is checked */
                temp = cal.convertCelciusToFahrenheit(temp);
            }
            else if(buttn2.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            }else {
                Toast.makeText(this, "Select the Radio Button!",Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            text1.setText(new Float(temp).toString());

        }
    }
}