package examp.dell.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView = (TextView)findViewById(R.id.resultTv);

       Intent intent= getIntent();

       String result = intent.getStringExtra("result");
        try {
            JSONObject jsonObject = new JSONObject(result);
            String resultValue = jsonObject.getString("result");
        //change the settext value according to the condition as your wish
            if(resultValue.equals("['A']"))
            textView.setText("Result value is: A"+"\nYour performance is good.");
            else if (resultValue.equals("['B']"))
                textView.setText("Result value is: B"+"\nYour performance is Moderate.");
            else if (result.equals("['C']"))
                textView.setText("Result value is: C"+"\nYour performance is Bad.");
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
