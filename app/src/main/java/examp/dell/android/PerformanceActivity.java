package examp.dell.android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import examp.dell.android.utils.HttpHandler;

public class PerformanceActivity extends AppCompatActivity{
    Button submit,btntest;
   // EditText cdfirst,cdlast,duration,whostage;

    private ProgressBar progressBar;
    String age1, cdfirst1, cdlast1, duration1, whostage1,totaltest1;


    String url ="http://198.211.110.81:8000/pat_per?";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
         final EditText cdfirst = (EditText)findViewById(R.id.cdfirst);
         final EditText cdlast = (EditText)findViewById(R.id.cdfinal);
         final EditText duration = (EditText)findViewById(R.id.duration);
         final EditText whostage = (EditText)findViewById(R.id.whoStage);
         final EditText totaltest = (EditText)findViewById(R.id.totaltest);
         final EditText age = (EditText)findViewById(R.id.age);


//        url = url +"?"+"gender="+age1+"&who_stage="+whostage1 +"&duration="+duration1+"&start_cd4="+cdfirst1+"&no_cd4_done="+totaltest1+"&recent_cd4="+cdlast1;


//
//        btntest=findViewById(R.id.btntest);
//        btntest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new BackgroundWork().execute();
//            }
//        });


        submit=findViewById(R.id.btnsubmit);
        submit.setOnClickListener(new View.OnClickListener() {

            
            @Override
            public void onClick(View view) {
                age1 = age.getText().toString();
                cdfirst1 = cdfirst.getText().toString();
                cdlast1 = cdlast.getText().toString();
                duration1 = duration.getText().toString();
                whostage1 = whostage.getText().toString();
                totaltest1 = totaltest.getText().toString();
                JSONObject postDataParams = new JSONObject();
                //postDataParams.put("name", "abc");
                //postDataParams.put("email", "abc@gmail.com");

                try {
                    postDataParams.put("gender","12");
                    postDataParams.put("who_stage",whostage1);
                    postDataParams.put("duration",duration1);
                    postDataParams.put("start_cd4",cdfirst1);
                    postDataParams.put("no_cd4_done",totaltest1);
                    postDataParams.put("recent_cd4",cdlast1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.e("params",postDataParams.toString());

                new BackgroundWork().execute();
//                String cdfirstStr = cdfirst.getText().toString();
//                String cdlastStr = cdlast.getText().toString();
//                String durationStr =duration.getText().toString();
//                String whostageStr =whostage.getText().toString();
//                String totaltestStr =totaltest.getText().toString();
//                String ageStr =totaltest.getText().toString();
//
//                if(TextUtils.isEmpty(cdfirstStr)){
//                    cdfirst.setError("Cannot leave empty!!");
//                    cdfirst.requestFocus();
//                    return;
//                }
//
//                if(TextUtils.isEmpty(ageStr)){
//                    age.setError("Cannot leave empty!!");
//                    age.requestFocus();
//                    return;
//                }
//                if (TextUtils.isEmpty(cdlastStr)){
//                    cdlast.setError("Cannot leave empty!!");
//                    cdlast.requestFocus();
//                    return;
//                }
//                if (TextUtils.isEmpty(durationStr)){
//                    duration.setError("Cannot leave empty!!");
//                    duration.requestFocus();
//                    return;
//                }
//                if (TextUtils.isEmpty(whostageStr)){
//                    whostage.setError("Cannot leave empty!!");
//                    whostage.requestFocus();
//                    return;
//                }
//                if (TextUtils.isEmpty(totaltestStr)){
//                    totaltest.setError("Cannot leave empty!!");
//                    totaltest.requestFocus();
//                    return;
//                }
//
////                Intent i= new Intent(PerformanceActivity.this, ResultActivity.class);
////                startActivity(i);
            }
        });



//        cdfirst.setFilters(new InputFilter[]{ new MinMaxFilter("1", "2000")});
//        cdlast.setFilters(new InputFilter[]{ new MinMaxFilter("1", "2000")});
//        duration.setFilters(new InputFilter[]{ new MinMaxFilter("1", "50")});
//        whostage.setFilters(new InputFilter[]{ new MinMaxFilter("1", "4")});
//        totaltest.setFilters(new InputFilter[]{ new MinMaxFilter("1", "50")});
//        age.setFilters(new InputFilter[]{ new MinMaxFilter("1", "100")});
    }


@SuppressLint("StaticFieldLeak")
private class BackgroundWork extends AsyncTask<Void,Void,String>{

    @Override
    protected String doInBackground(Void... voids) {

        HttpHandler handler = new HttpHandler();

//        String jsonStr = handler.makeServiceCall(url);

            try {

                JSONObject postDataParams = new JSONObject();
                //postDataParams.put("name", "abc");
                //postDataParams.put("email", "abc@gmail.com");

                postDataParams.put("gender",age1);
                postDataParams.put("who_stage",whostage1);
                postDataParams.put("duration",duration1);
                postDataParams.put("start_cd4",cdfirst1);
                postDataParams.put("no_cd4_done",totaltest1);
                postDataParams.put("recent_cd4",cdlast1);


//                HashMap<String,String> paramMap = new HashMap<>();
//
//                paramMap.put("gender",age1);
//                paramMap.put("who_stage",whostage1);
//                paramMap.put("duration",duration1);
//                paramMap.put("start_cd4",cdfirst1);
//                paramMap.put("no_cd4_done",totaltest1);
//                paramMap.put("recent_cd4",cdlast1);

                URL torequestUrl = new URL(url);

                HttpURLConnection conn = (HttpURLConnection)torequestUrl.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
//                conn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
                conn.setRequestProperty("Accept", "application/json");

//                OutputStream os = conn.getOutputStream();
//                BufferedWriter writer = new BufferedWriter(
//                        new OutputStreamWriter(os, "UTF-8"));
//                writer.write(getPostDataString(postDataParams));

                OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
Log.e("params",getPostDataString(postDataParams));
                writer.write(getPostDataString(postDataParams));
                writer.flush();
                writer.close();
                int responseCode=conn.getResponseCode();

                if ((responseCode == HttpsURLConnection.HTTP_OK) || responseCode==201) {

                    BufferedReader in=new BufferedReader(
                            new InputStreamReader(
                                    conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }


            }catch (Exception e){
                System.out.println("error -->> + " + e.getMessage());

            }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       Log.e(PerformanceActivity.class.getSimpleName(),"connecting to :"+url);
        Toast.makeText(getApplicationContext(), "Please wailt calling the api: " ,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(getApplicationContext(), s,
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(PerformanceActivity.this,ResultActivity.class);
        intent.putExtra("result",s);
        startActivity(intent);
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }


}
}
