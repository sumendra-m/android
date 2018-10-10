package examp.dell.android;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    Button calculate;
    EditText weight,height;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final EditText weight= (EditText)findViewById(R.id.weight);
        final EditText height= (EditText)findViewById(R.id.height);
        final TextView Result=findViewById(R.id.result);



        calculate=findViewById(R.id.btncalculate);
        calculate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();
                if(TextUtils.isEmpty(heightStr)){
                    height.setError("Please enter your height");
                    height.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(weightStr)){
                    weight.setError("Please enter your weight");
                    weight.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(weightStr);
                float height = Float.parseFloat(heightStr)/100;
                //calculating bmivalue
                float bmiValue = calculateBMI(weight, height);


                //the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                Result.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });
        weight.setText(null);
        height.setText(null);


    }
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }




    }
}
