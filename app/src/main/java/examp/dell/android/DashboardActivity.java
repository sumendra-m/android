package examp.dell.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
   Button performance,whostage,calculator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashb);


       performance = findViewById(R.id.performance);
        performance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardActivity.this,PerformanceActivity.class);
                startActivity(i);


            }
        });


        whostage = findViewById(R.id.whostage);
        whostage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardActivity.this,WhoActivity.class);
                startActivity(i);


            }
        });

        calculator = findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DashboardActivity.this,CalculatorActivity.class);
                startActivity(i);


            }
        });



    }
}
